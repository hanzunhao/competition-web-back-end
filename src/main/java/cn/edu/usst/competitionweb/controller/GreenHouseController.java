package cn.edu.usst.competitionweb.controller;

import cn.edu.usst.competitionweb.anno.PrintOperateLog;
import cn.edu.usst.competitionweb.pojo.Result;
import cn.edu.usst.competitionweb.service.GreenHouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@Slf4j
public class GreenHouseController {
    @Autowired
    GreenHouseService greenHouseService;

    @GetMapping()
    @PrintOperateLog
    Result getAllGreenHouseCardForm() {
        return Result.success(greenHouseService.getAllGreenHouseCardForm());
    }
}
