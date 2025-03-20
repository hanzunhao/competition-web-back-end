package cn.edu.usst.competitionweb.controller;

import cn.edu.usst.competitionweb.anno.Log;
import cn.edu.usst.competitionweb.pojo.Result;
import cn.edu.usst.competitionweb.service.FlowerPotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home/detail/pot")
public class FlowerPotController {
    @Autowired
    private FlowerPotService flowerPotService;

    @GetMapping
    @Log
    public Result getAllFlowerPotForm(){
        return Result.success(flowerPotService.getAllFlowerPotForm());
    }
}
