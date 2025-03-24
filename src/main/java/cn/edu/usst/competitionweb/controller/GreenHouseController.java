package cn.edu.usst.competitionweb.controller;

import cn.edu.usst.competitionweb.anno.PrintOperateLog;
import cn.edu.usst.competitionweb.pojo.GreenHouse;
import cn.edu.usst.competitionweb.pojo.Result;
import cn.edu.usst.competitionweb.service.GreenHouseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
@Tag(name = "温室管理接口", description = "温室管理相关接口")  // 描述该Controller的功能
@Slf4j
public class GreenHouseController {

    @Autowired
    private GreenHouseService greenHouseService;

    @GetMapping("/get")
    @Operation(summary = "获取所有温室信息", description = "返回所有温室的信息")
    @PrintOperateLog
    public Result getAllGreenHouseForm() {
        try{
            return Result.success(greenHouseService.getAllGreenHouseForm());
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
    }

    @PutMapping("/update")
    @Operation(summary = "更新温室信息", description = "上位机发送最新的温室信息到此接口")
    @PrintOperateLog
    public Result updateGreenHouseForm(
            @Parameter(description = "温室对象列表", required = true) @RequestBody List<GreenHouse> greenHouseList
    ) {
        try{
            greenHouseService.updateGreenHouseForm(greenHouseList);
            return Result.success();
        } catch (Exception e){
            return Result.error(e.getMessage());
        }
    }
}