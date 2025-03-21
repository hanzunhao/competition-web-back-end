package cn.edu.usst.competitionweb.controller;

import cn.edu.usst.competitionweb.anno.PrintOperateLog;
import cn.edu.usst.competitionweb.pojo.Result;
import cn.edu.usst.competitionweb.service.FlowerPotService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home/detail/pot")
@Tag(name = "花盆管理接口", description = "花盆管理相关接口")  // 描述该Controller的功能
@Slf4j
public class FlowerPotController {

    @Autowired
    private FlowerPotService flowerPotService;

    @GetMapping("/selectAll")
    @Operation(summary = "获取所有花盆信息", description = "返回所有花盆的详细信息")
    @PrintOperateLog
    public Result getAllFlowerPotForm() {
        return Result.success(flowerPotService.getAllFlowerPotForm());
    }

    @DeleteMapping("/delete/{greenHouseId}")
    @Operation(summary = "批量删除花盆", description = "根据传入的花盆ID列表批量删除花盆")
    @PrintOperateLog
    public Result deleteFlowerPotByIdList(
            @Parameter(description = "温室ID", required = true) @PathVariable Integer greenHouseId,
            @Parameter(description = "花盆ID列表", required = true) @RequestBody List<Integer> potIdList
    ) {
        flowerPotService.deleteFlowerPotByIdList(greenHouseId, potIdList);
        return Result.success("删除成功: greenhouseId=" + greenHouseId + ", potIdList=" + potIdList);
    }
}