package cn.edu.usst.competitionweb.config;

import cn.edu.usst.competitionweb.handler.TaskSocketHandler;
import cn.edu.usst.competitionweb.handler.VideoStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Autowired
    private VideoStreamHandler videoStreamHandler;

    @Autowired
    private TaskSocketHandler taskSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(videoStreamHandler, "/video-stream").setAllowedOrigins("*");
        registry.addHandler(taskSocketHandler, "/task").setAllowedOrigins("*");
    }
}
