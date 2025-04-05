package cn.edu.usst.competitionweb.controller;

import cn.edu.usst.competitionweb.pojo.FlowerPot;
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
@RequestMapping
@Slf4j
@Tag(name = "花盆管理接口", description = "花盆管理相关操作")
public class FlowerPotController {

    @Autowired
    private FlowerPotService flowerPotService;

    @Operation(summary = "根据温室ID获取花盆", description = "获取指定温室中的所有花盆信息")
    @GetMapping("/page_1/{greenHouseId}/pot")
    public Result getFlowerPotByGreenHouseId(
            @Parameter(description = "温室ID", required = true)
            @PathVariable Integer greenHouseId) {
        try {
            return Result.success(flowerPotService.getFlowerPotByGreenHouseId(greenHouseId));
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @Operation(summary = "删除花盆", description = "根据花盆ID列表从指定温室中删除多个花盆")
    @DeleteMapping("/page_1/{greenHouseId}/pot")
    public Result deleteFlowerPotByPotIdList(
            @Parameter(description = "温室ID", required = true)
            @PathVariable Integer greenHouseId,
            @Parameter(description = "花盆ID列表", required = true)
            @RequestBody List<Integer> potIdList) {
        try {
            flowerPotService.deleteFlowerPotByPotIdList(greenHouseId, potIdList);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @Operation(summary = "更新花盆信息", description = "更新指定温室中的花盆信息列表")
    @PutMapping("/page_1/{greenHouseId}/update")
    public Result updateFlowerPotByGreenHouseId(
            @Parameter(description = "温室ID", required = true)
            @PathVariable Integer greenHouseId,
            @Parameter(description = "花盆信息对象列表", required = true)
            @RequestBody List<FlowerPot> flowerPotList) {
        try {
            flowerPotService.updateFlowerPotByGreenHouseId(greenHouseId, flowerPotList);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
}