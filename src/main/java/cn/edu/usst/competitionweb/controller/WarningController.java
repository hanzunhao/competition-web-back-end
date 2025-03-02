package cn.edu.usst.competitionweb.controller;

import cn.edu.usst.competitionweb.pojo.Result;
import cn.edu.usst.competitionweb.pojo.Warning;
import cn.edu.usst.competitionweb.service.WarningService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/page_2/warning")
public class WarningController {
    @Autowired
    WarningService warningService;

    @GetMapping("/selectAll")
    Result getWarningList() {
        return Result.success(warningService.selectAll());
    }

    @DeleteMapping("/delete")
    Result delete(@RequestParam List<Integer> ids) {
        log.info("delete list:" + ids.toString());
        warningService.delete(ids);
        return Result.success("delete " + ids);
    }

    @PostMapping("/insert")
    Result insert(@RequestBody Warning warning) {
        log.info("insert new warning:" + warning.toString());
        warningService.insert(warning);
        return Result.success("insert " + warning);
    }
}
