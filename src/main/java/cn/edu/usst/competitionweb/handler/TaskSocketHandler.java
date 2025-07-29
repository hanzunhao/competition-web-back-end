package cn.edu.usst.competitionweb.handler;

import cn.edu.usst.competitionweb.pojo.FlowerPot;
import cn.edu.usst.competitionweb.pojo.Log;
import cn.edu.usst.competitionweb.service.DeviceService;
import cn.edu.usst.competitionweb.service.FlowerPotService;
import cn.edu.usst.competitionweb.service.LogService;
import cn.edu.usst.competitionweb.service.TaskService;
import cn.edu.usst.competitionweb.utils.WsSessionManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
@Slf4j
public class TaskSocketHandler extends AbstractWebSocketHandler {

    @Autowired
    private LogService logService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private FlowerPotService flowerPotService;

    @Autowired
    private DeviceService deviceService;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        log.info("建立ws连接");
        WsSessionManager.add(session.getId(), session);
    }

    //todo 添加有关设备状态信息的交互
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        String payload = message.getPayload();
        log.info("server 接收到消息 " + payload);

        // 是否是心跳信息
        boolean isHeartBeat = payload.equals("-");

        // 如果不是心跳
        if (!isHeartBeat && payload.split(":").length > 1) {
            String head = payload.split(":")[0];
            String body = payload.split(":")[1];

            log.info("head: " + head + " body: " + body);

            if (body.equals("over")) {
                log.info("enter over!!!!!!!!!!!!");

                // 插入任务完成日志
                Log completeLog = new Log();
                completeLog.setDate(LocalDateTime.now());
                completeLog.setName(payload.split(":")[0]);
                completeLog.setIsCompleted(true);
                completeLog.setTaskId(taskService.selectTaskIdByName(completeLog.getName()));
                log.info("" + completeLog);
                logService.insert(completeLog);
            } else if (head.equals("move")) {
                log.info("enter move!!!!!!!!!!!!");

                // 根据传入的id列表删除花盆
                Integer greenHouseId = 1;
                String[] idStrList = body.split(",");
                log.info("idStrList" + Arrays.toString(idStrList));
                List<Integer> idList = new ArrayList<>();
                for (String id : idStrList) {
                    idList.add(Integer.parseInt(id.trim()));
                }
                log.info("" + idList);
                flowerPotService.deleteFlowerPotByPotIdList(greenHouseId, idList);
            } else if (head.equals("update")) {
                log.info("enter update!!!!!!!!!!!!");

                // 更新花盆信息
                Integer greenHouseId = 1;
                String[] data = body.split(",");
                log.info("data" + Arrays.toString(data));
                List<FlowerPot> flowerPotList = new ArrayList<>();
                for (int i = 0; i < data.length; i += 2) {
                    FlowerPot flowerPot = new FlowerPot();
                    flowerPot.setId(Integer.parseInt(data[i].trim()));
                    flowerPot.setSoilTemperature(26.0 + new Random().nextDouble() * 2 - 1);
                    flowerPot.setSoilHumidity(Double.parseDouble(data[i + 1].trim()));
                    flowerPotList.add(flowerPot);
                }
                log.info("" + flowerPotList);
                flowerPotService.updateFlowerPotByGreenHouseId(greenHouseId, flowerPotList);
            } else if (head.equals("detect")) {
                log.info("enter detect!!!!!!!!!!!!");

                // 更新花盆信息
                Integer greenHouseId = 1;
                String[] data = body.split(",");
                List<FlowerPot> flowerPotList = new ArrayList<>();
                for (int i = 0; i < data.length; i += 2) {
                    FlowerPot flowerPot = new FlowerPot();
                    flowerPot.setId(Integer.parseInt(data[i].trim()));
                    flowerPot.setPestName(data[i + 1].trim());
                    flowerPotList.add(flowerPot);
                }
                log.info("" + flowerPotList);
                flowerPotService.updateFlowerPotPests(flowerPotList);
            } else if (head.equals("car")) {
                log.info("enter car!!!!!!!!!!!!");

                // 信息格式为 car:id,stateCode,power

                // 更新花盆信息
                String[] data = body.split(",");
                int id = Integer.parseInt(data[0]);
                int stateCode = Integer.parseInt(data[1]);
                int power = Integer.parseInt(data[2]);

                log.info("update car:" + id + "," + stateCode + "," + power);
                deviceService.updateCarStateById(id, stateCode, power);
            }
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
