package cn.edu.usst.competitionweb.controller;

import cn.edu.usst.competitionweb.pojo.Result;
import cn.edu.usst.competitionweb.service.WsService;
import cn.edu.usst.competitionweb.utils.WsSessionManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/RaspberryPi")
@Slf4j
public class RaspberryPiController {
    @Autowired
    private WsService wsService;

    @PostMapping("/send")
    public Result testSend(@RequestBody Map<String, String> request) {
        try {
            String sessionType = request.get("session-type");
            String message = request.get("message");
            wsService.send(sessionType, message);
            log.info("send:" + message + " to:" + sessionType);
            log.info("SESSION POLL: " + WsSessionManager.SESSION_POOL);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @PostMapping("/broadcast")
    public Result testBroadcast(@RequestBody String message) {
        try {
            log.info("broadcast:" + message);
            wsService.broadcast(message);
            log.info("SESSION POLL: " + WsSessionManager.SESSION_POOL);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
}
