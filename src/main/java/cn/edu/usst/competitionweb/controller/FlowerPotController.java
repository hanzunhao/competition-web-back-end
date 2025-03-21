package cn.edu.usst.competitionweb.controller;

import cn.edu.usst.competitionweb.anno.PrintOperateLog;
import cn.edu.usst.competitionweb.pojo.Result;
import cn.edu.usst.competitionweb.service.FlowerPotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home/detail/pot")
@Slf4j
public class FlowerPotController {
    @Autowired
    private FlowerPotService flowerPotService;

    @GetMapping("/selectAll")
    @PrintOperateLog
    public Result getAllFlowerPotForm() {
        return Result.success(flowerPotService.getAllFlowerPotForm());
    }

    @DeleteMapping("/delete")
    @PrintOperateLog
    public Result deleteFlowerPotByIdList(@RequestBody List<Integer> ids) {
        flowerPotService.deleteFlowerPotByIdList(ids);
        return Result.success("delete " + ids);
    }
}
