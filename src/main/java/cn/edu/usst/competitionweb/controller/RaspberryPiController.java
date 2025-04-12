package cn.edu.usst.competitionweb.controller;

import cn.edu.usst.competitionweb.pojo.Result;
import cn.edu.usst.competitionweb.service.WsService;
import cn.edu.usst.competitionweb.utils.WsSessionManager;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "树莓派通信接口", description = "物联网设备WebSocket通信管理")
public class RaspberryPiController {
    @Autowired
    private WsService wsService;

    @Operation(summary = "定向消息推送", description = "向特定会话类型的设备发送控制指令")
    @PostMapping("/send")
    public Result send(@RequestBody Map<String, String> request) {
        try {
            String sessionType = request.get("session-type");
            String message = request.get("message");
            wsService.send(sessionType,  message);
            log.info("send:"  + message + " to:" + sessionType);
            log.info("SESSION  POLL: " + WsSessionManager.SESSION_POOL);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @Operation(summary = "全局广播消息", description = "向所有连接的树莓派设备发送广播指令")
    @PostMapping("/broadcast")
    public Result broadcast(@RequestBody  String message) {
        try {
            log.info("broadcast:"  + message);
            wsService.broadcast(message);
            log.info("SESSION  POLL: " + WsSessionManager.SESSION_POOL);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
}