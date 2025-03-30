package cn.edu.usst.competitionweb.config;

import cn.edu.usst.competitionweb.handler.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new VideoStreamHandler(), "/video-stream").setAllowedOrigins("*");
        registry.addHandler(new MyWebSocketHandler(), "/ws").setAllowedOrigins("*");
        registry.addHandler(new GreenHouseSocketHandler(), "/green-house").setAllowedOrigins("*");
        registry.addHandler(new FlowerPotSocketHandler(), "/flower-pot").setAllowedOrigins("*");
        registry.addHandler(new TaskSocketHandler(), "/task").setAllowedOrigins("*");
    }
}
