package cn.edu.usst.competitionweb.controller;

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
@Tag(name = "日志管理", description = "日志的增删查操作")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/selectAll")
    @Operation(summary = "查询所有日志", description = "获取全部日志列表")
    public Result getWarningList() {
        return Result.success(logService.selectAll());
    }

    @DeleteMapping("/delete")
    @Operation(summary = "批量删除日志", description = "根据ID列表删除日志")
    public Result delete(@Parameter(description = "日志ID列表", required = true) @RequestParam List<Integer> ids) {
        logService.delete(ids);
        return Result.success();
    }

    @PostMapping("/insert")
    @Operation(summary = "新增日志", description = "插入一条日志记录")
    public Result insert(@Parameter(description = "日志信息对象", required = true) @RequestBody Log log) {
        logService.insert(log);
        return Result.success();
    }
}