package cn.edu.usst.competitionweb.handler;

import lombok.extern.slf4j.Slf4j;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

@Slf4j
public class VideoStreamHandler extends BinaryWebSocketHandler {

    private volatile boolean running = true;

    @Override
    public void afterConnectionEstablished(WebSocketSession session){
        log.info("WebSocket connection established: {}", session.getId());
        startVideoStream(session);
    }

    private void startVideoStream(WebSocketSession session) {
        new Thread(() -> {
            try (FrameGrabber grabber = new OpenCVFrameGrabber(0)) {
                grabber.start();
                Java2DFrameConverter converter = new Java2DFrameConverter();

                while (running) {
                    // 捕获视频帧
                    BufferedImage image = converter.convert(grabber.grab());

                    if (image != null) {
                        // 将图像转换为字节数组
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(image, "jpg", baos);
                        byte[] imageBytes = baos.toByteArray();

                        // 通过 WebSocket 发送视频帧
                        session.sendMessage(new BinaryMessage(imageBytes));
                        baos.close();
                    }
                }
            } catch (Exception e) {
                log.error("Error in video streaming: {}", e.getMessage(), e);
            }
        }).start();
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status){
        log.info("WebSocket connection closed: {}", session.getId());
        running = false;
    }
}
