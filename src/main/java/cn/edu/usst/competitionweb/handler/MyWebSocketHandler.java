package cn.edu.usst.competitionweb.handler;

import cn.edu.usst.competitionweb.utils.WsSessionManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;


/**
 * ws消息处理类
 */
@Component
@Slf4j
public class MyWebSocketHandler extends AbstractWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        log.info("建立ws连接");
        WsSessionManager.add(session.getId(), session);
    }

    @Override
    @Transactional
    public void handleTextMessage(WebSocketSession session, TextMessage message){
        String payload = message.getPayload();
        log.info("server 接收到消息 " + payload);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) {
        log.error("异常处理");
        WsSessionManager.removeAndClose(session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        log.info("关闭ws连接");
        WsSessionManager.removeAndClose(session.getId());
    }
}
