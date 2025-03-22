package cn.edu.usst.competitionweb.controller;

import cn.edu.usst.competitionweb.anno.PrintOperateLog;
import cn.edu.usst.competitionweb.pojo.Result;
import cn.edu.usst.competitionweb.service.GreenHouseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@Tag(name = "温室管理接口", description = "温室管理相关接口")  // 描述该Controller的功能
@Slf4j
public class GreenHouseController {

    @Autowired
    private GreenHouseService greenHouseService;

    @GetMapping()
    @Operation(summary = "获取所有温室信息", description = "返回所有温室的信息")
    @PrintOperateLog
    public Result getAllGreenHouseForm() {
        return Result.success(greenHouseService.getAllGreenHouseForm());
    }
}