package cn.edu.usst.competitionweb.handler;

import cn.edu.usst.competitionweb.pojo.GreenHouse;
import cn.edu.usst.competitionweb.utils.WsSessionManager;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;


@Component
@Slf4j
public class GreenHouseSocketHandler extends AbstractWebSocketHandler {
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        log.info("建立ws连接");
        WsSessionManager.add(session.getId(), session);
    }

    @Override
    @Transactional
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("server 接收到消息 " + payload);

        //反序列化
        try{
            ObjectMapper mapper = new ObjectMapper();
            GreenHouse greenHouse = mapper.readValue(payload, GreenHouse.class);
            log.info("反序列化：" + greenHouse);
        }catch (JsonMappingException e){
            log.error("JSON 解析失败", e);
        }
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
