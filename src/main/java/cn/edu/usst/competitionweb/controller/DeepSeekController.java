package cn.edu.usst.competitionweb.controller;

import cn.edu.usst.competitionweb.pojo.Result;
import cn.edu.usst.competitionweb.service.DeepSeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deepseek")
public class DeepSeekController {
    @Autowired
    DeepSeekService deepSeekService;

    @PostMapping
    public Result queryDeepSeek(@RequestParam String context) {
        return Result.success(deepSeekService.chat(context));
    }
}
