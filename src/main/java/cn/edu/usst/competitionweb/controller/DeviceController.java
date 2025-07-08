package cn.edu.usst.competitionweb.controller;


import cn.edu.usst.competitionweb.pojo.Result;
import cn.edu.usst.competitionweb.service.DeviceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Slf4j
@Tag(name = "设备管理", description = "设备信息管理相关接口")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping("/device/car/{id}")
    @Operation(summary = "根据ID获取机器人状态")
    public Result getCarStateById(
            @Parameter(description = "机器人ID", required = true)
            @PathVariable int id) {
        try {
            return Result.success(deviceService.getCarStateById(id));
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @GetMapping("/device/sensor/{id}")
    @Operation(summary = "根据ID获取传感器状态")
    public Result getSensorStateById(
            @Parameter(description = "传感器ID", required = true)
            @PathVariable int id) {
        try {
            return Result.success(deviceService.getSensorStateById(id));
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
}
