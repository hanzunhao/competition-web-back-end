package cn.edu.usst.competitionweb.controller;

import cn.edu.usst.competitionweb.service.impl.WsServiceImpl;
import cn.edu.usst.competitionweb.utils.WsSessionManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
@Slf4j
public class TestController {
    @Autowired
    WsServiceImpl wsService;

    @PostMapping("/send")
    public Boolean testSend(@RequestBody Map<String, String> request) throws IOException {
        log.info("send");
        String sessionType=request.get("session-type");
        String message=request.get("message");
        wsService.send(sessionType,message);
        log.info("SESSION POLL: " + WsSessionManager.SESSION_POOL);
        return true;
    }

    @PostMapping("/broadcast")
    public Boolean testBroadcast(@RequestBody String message) throws IOException {
        log.info("broadcast");
        wsService.broadcast(message);
        log.info("SESSION POLL: " + WsSessionManager.SESSION_POOL);
        return true;
    }
}
