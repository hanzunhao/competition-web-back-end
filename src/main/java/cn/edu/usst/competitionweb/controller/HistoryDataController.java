package cn.edu.usst.competitionweb.controller;

import cn.edu.usst.competitionweb.pojo.HistoryData;
import cn.edu.usst.competitionweb.pojo.Result;
import cn.edu.usst.competitionweb.service.HistoryDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/history_data")
@Tag(name = "温室历史数据管理", description = "提供温室历史数据的查询和新增功能")
public class HistoryDataController {
    // TODO 实现温室历史数据随传感器传输数据新增的功能

    @Autowired
    private HistoryDataService historyDataService;

    @Operation(summary = "按温室ID和时间范围查询历史数据", description = "根据指定的温室ID和时间范围查询历史环境数据记录")
    @GetMapping("/select")
    public Result selectByGreenHouseIdAndTimeRange(
            @Parameter(
                    name = "greenHouseId",
                    description = "温室ID（正整数）",
                    required = true,
                    example = "1"
            )
            @RequestParam Integer greenHouseId,

            @Parameter(
                    name = "startTime",
                    description = "开始时间（格式：yyyy-MM-dd HH:mm:ss）",
                    required = true,
                    example = "2025-01-01 00:00:00"
            )
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startTime,

            @Parameter(
                    name = "endTime",
                    description = "结束时间（格式：yyyy-MM-dd HH:mm:ss）",
                    required = true,
                    example = "2025-01-02 23:59:59"
            )
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime endTime) {

        // 参数校验
        if (greenHouseId == null || greenHouseId <= 0) {
            log.warn("非法温室ID参数: {}", greenHouseId);
            return Result.error("温室ID必须为正整数");
        }

        if (startTime == null || endTime == null || startTime.isAfter(endTime)) {
            log.warn("非法时间范围参数: startTime={}, endTime={}", startTime, endTime);
            return Result.error("时间范围不合法");
        }

        try {
            List<HistoryData> dataList = historyDataService.selectByGreenHouseIdAndTimeRange(greenHouseId, startTime, endTime);
            return Result.success(dataList);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @Operation(summary = "新增温室历史数据", description = "添加一条新的温室环境数据记录")
    @PostMapping("/insert")
    public Result insertAHistoryData(
            @Parameter(
                    description = "温室历史数据对象",
                    required = true
            )
            @RequestBody HistoryData historyData) {
        // 参数校验
        if (historyData == null) {
            return Result.error("请求体不能为空");
        }

        if (historyData.getGreenHouseId() == null || historyData.getGreenHouseId() <= 0) {
            return Result.error("温室ID必须为正整数");
        }

        if (historyData.getTime() == null) {
            return Result.error("记录时间不能为空");
        }

        try {
            historyDataService.insertHistoryData(historyData);
            return Result.success("新增温室历史数据成功");
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
}
