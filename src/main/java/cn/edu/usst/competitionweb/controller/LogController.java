package cn.edu.usst.competitionweb.controller;

import cn.edu.usst.competitionweb.pojo.Result;
import cn.edu.usst.competitionweb.pojo.Log;
import cn.edu.usst.competitionweb.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/page_2/warning")
public class LogController {
    @Autowired
    LogService logService;

    @GetMapping("/selectAll")
    @cn.edu.usst.competitionweb.anno.Log
    Result getWarningList() {
        return Result.success(logService.selectAll());
    }

    @DeleteMapping("/delete")
    @cn.edu.usst.competitionweb.anno.Log
    Result delete(@RequestParam List<Integer> ids) {
        logService.delete(ids);
        return Result.success("delete " + ids);
    }

    @PostMapping("/insert")
    @cn.edu.usst.competitionweb.anno.Log
    Result insert(@RequestBody Log log) {
        logService.insert(log);
        return Result.success("insert " + log);
    }
}
