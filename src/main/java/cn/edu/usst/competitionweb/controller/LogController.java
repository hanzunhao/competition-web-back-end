package cn.edu.usst.competitionweb.controller;

import cn.edu.usst.competitionweb.anno.PrintOperateLog;
import cn.edu.usst.competitionweb.pojo.Result;
import cn.edu.usst.competitionweb.pojo.Log;
import cn.edu.usst.competitionweb.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/page_2/log")
public class LogController {
    @Autowired
    LogService logService;

    @GetMapping("/selectAll")
    @PrintOperateLog
    Result getWarningList() {
        return Result.success(logService.selectAll());
    }

    @DeleteMapping("/delete")
    @PrintOperateLog
    Result delete(@RequestParam List<Integer> ids) {
        logService.delete(ids);
        return Result.success("delete " + ids);
    }

    @PostMapping("/insert")
    @PrintOperateLog
    Result insert(@RequestBody Log log) {
        logService.insert(log);
        return Result.success("insert " + log);
    }
}
