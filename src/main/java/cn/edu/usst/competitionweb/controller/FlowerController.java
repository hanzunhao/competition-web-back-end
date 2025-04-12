package cn.edu.usst.competitionweb.controller;

import cn.edu.usst.competitionweb.pojo.Flower;
import cn.edu.usst.competitionweb.pojo.Result;
import cn.edu.usst.competitionweb.service.FlowerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Tag(name = "仓库存放花卉管理", description = "仓库存放花卉管理相关接口")
@RequestMapping("/flower")
public class FlowerController {
    @Autowired
    private FlowerService flowerService;

    @PutMapping("/insert")
    @Operation(summary = "花卉入库登记", description = "将新采摘或采购的花卉信息录入库存系统")
    public Result insertFlower(
            @Parameter(description = "花卉实体信息", required = true)
            @RequestBody Flower flower) {
        try {
            flowerService.insertFlower(flower);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
}
