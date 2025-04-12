package cn.edu.usst.competitionweb.controller;

import cn.edu.usst.competitionweb.pojo.GreenHouse;
import cn.edu.usst.competitionweb.pojo.Result;
import cn.edu.usst.competitionweb.service.impl.WsServiceImpl;
import cn.edu.usst.competitionweb.utils.WsSessionManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping ("/test")
    public Result testESP8266(@RequestBody GreenHouse greenHouse){
        try{
            log.info(String.format("ESP8266发送的数据：%s", greenHouse));
            return Result.success("成功接收温室数据");
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
    }
}
