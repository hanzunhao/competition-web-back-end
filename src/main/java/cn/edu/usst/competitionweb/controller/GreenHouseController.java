package cn.edu.usst.competitionweb.controller;

import cn.edu.usst.competitionweb.pojo.GreenHouse;
import cn.edu.usst.competitionweb.pojo.Result;
import cn.edu.usst.competitionweb.service.GreenHouseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Slf4j
@Tag(name = "温室管理", description = "温室信息管理相关接口")
public class GreenHouseController {

    @Autowired
    private GreenHouseService greenHouseService;

//    @Autowired
//    private HistoryDataService historyDataService;

    @GetMapping("/page_1")
    @Operation(summary = "获取所有温室信息", description = "返回系统中所有的温室数据列表")
    public Result getAllGreenHouse() {
        try {
            return Result.success(greenHouseService.getAllGreenHouse());
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @GetMapping("/page_1/{id}")
    @Operation(summary = "根据ID获取温室信息", description = "根据温室ID获取对应的温室详细信息")
    public Result getGreenHouseById(
            @Parameter(description = "温室ID", required = true)
            @PathVariable int id) {
        try {
            return Result.success(greenHouseService.getGreenHouseById(id));
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @PutMapping("/update/greenhouse")
    @Operation(summary = "更新温室信息", description = "根据提供的温室信息更新系统中的温室数据")
    public Result updateGreenHouse(
            @Parameter(description = "温室信息对象", required = true)
            @RequestBody GreenHouse greenHouse) {
        try {
            greenHouseService.updateGreenHouse(greenHouse);
//            HistoryData historyData=new HistoryData();
//            historyData.setGreenHouseId(greenHouse.getGreenHouseId());
//            historyData.setTime(LocalDateTime.now());
//            historyData.setIllumination(greenHouse.getIllumination());
//            historyData.setAirHumidity(greenHouse.getAirHumidity());
//            historyData.setAirTemperature(historyData.getAirTemperature());
//            historyData.setMeanSoilHumidity(historyData.getMeanSoilHumidity());
//            historyData.setMeanSoilTemperature(historyData.getMeanSoilTemperature());
//            historyDataService.insertHistoryData(historyData);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
}