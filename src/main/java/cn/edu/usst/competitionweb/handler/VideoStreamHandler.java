package cn.edu.usst.competitionweb.handler;

import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class VideoStreamHandler extends BinaryWebSocketHandler {

    private volatile boolean running = false;
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    private static final Object CAMERA_LOCK = new Object(); // 摄像头资源锁

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        log.info("WebSocket connection established: {}", session.getId());
        running = true;
        executorService.submit(() -> startVideoStream(session));
    }

    private void startVideoStream(WebSocketSession session) {
        synchronized (CAMERA_LOCK) {
            try (FrameGrabber grabber = new OpenCVFrameGrabber(0);
                 ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                grabber.start();

                Java2DFrameConverter converter = new Java2DFrameConverter();

                while (running && session.isOpen()) {
                    // 捕获视频帧
                    BufferedImage image = converter.convert(grabber.grab());

                    if (image != null) {
                        // 将图像转换为字节数组
                        baos.reset(); // 重置输出流
                        ImageIO.write(image, "jpg", baos);
                        byte[] imageBytes = baos.toByteArray();

                        // 通过 WebSocket 发送视频帧
                        synchronized (session) {
                            if (session.isOpen()) {
                                session.sendMessage(new BinaryMessage(imageBytes));
                            }
                        }
                    }
                }
            } catch (Exception e) {
                log.error("Error in video streaming: {}", e.getMessage(), e);
            } finally {
                running = false;
                log.info("Video streaming stopped for session: {}", session.getId());
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        log.info("WebSocket connection closed: {}", session.getId());
        running = false; // 停止视频流线程
        try {
            if (session.isOpen()) {
                session.close(); // 关闭 WebSocket 会话
            }
        } catch (IOException e) {
            log.error("Error closing WebSocket session: {}", e.getMessage(), e);
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) {
        log.error("WebSocket transport error: {}", exception.getMessage(), exception);
        running = false;
    }

    @PreDestroy
    public void cleanup() {
        executorService.shutdown(); // 关闭线程池
        log.info("ExecutorService shutdown.");
    }
}