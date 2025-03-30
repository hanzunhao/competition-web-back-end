package cn.edu.usst.competitionweb.service.impl;

import cn.edu.usst.competitionweb.service.WsService;
import cn.edu.usst.competitionweb.utils.WsSessionManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@Service
@Slf4j
public class WsServiceImpl implements WsService {
    @Override
    public void send(String sessionType, String text) throws IOException {
        WebSocketSession targetSession = null;
        for (WebSocketSession session : WsSessionManager.SESSION_POOL.values()) {
            String uri = session.getUri().getPath();
            String type = uri.substring(uri.lastIndexOf('/') + 1);
            if (sessionType.equals(type)) {
                targetSession = session;
                break;
            }
        }
        if (targetSession != null) {
            targetSession.sendMessage(new TextMessage(text));
        } else {
            throw new IOException("找不到匹配的WebSocket会话");
        }
    }

    @Override
    public void broadcast(String text) throws IOException {
        for (WebSocketSession session : WsSessionManager.SESSION_POOL.values()) {
            log.info("session: " + session.getId());
            session.sendMessage(new TextMessage(text));
        }
    }
}
