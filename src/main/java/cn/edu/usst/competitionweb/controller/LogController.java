package cn.edu.usst.competitionweb.controller;

import cn.edu.usst.competitionweb.anno.PrintOperateLog;
import cn.edu.usst.competitionweb.pojo.Result;
import cn.edu.usst.competitionweb.pojo.Log;
import cn.edu.usst.competitionweb.service.LogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/page_2/log")
@Tag(name = "日志管理接口", description = "日志管理相关接口")  // 描述该Controller的功能
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/selectAll")
    @Operation(summary = "获取所有日志", description = "返回所有日志的列表")
    @PrintOperateLog
    public Result getWarningList() {
        return Result.success(logService.selectAll());
    }

    @DeleteMapping("/delete")
    @Operation(summary = "批量删除日志", description = "根据传入的日志ID列表批量删除日志")
    @PrintOperateLog
    public Result delete(
            @Parameter(description = "日志ID列表", required = true) @RequestParam List<Integer> ids) {
        logService.delete(ids);
        return Result.success("delete " + ids);
    }

    @PostMapping("/insert")
    @Operation(summary = "插入日志", description = "插入一条新的日志记录")
    @PrintOperateLog
    public Result insert(
            @Parameter(description = "日志对象", required = true) @RequestBody Log log) {
        logService.insert(log);
        return Result.success("insert " + log);
    }
}