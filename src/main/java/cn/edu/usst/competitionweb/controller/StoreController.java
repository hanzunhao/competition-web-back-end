package cn.edu.usst.competitionweb.controller;

import cn.edu.usst.competitionweb.pojo.Result;
import cn.edu.usst.competitionweb.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/page_4/store")
@Slf4j
@Tag(name = "仓库管理", description = "仓库库存信息管理相关接口")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping("/get")
    @Operation(summary = "获取所有仓库信息", description = "返回系统中所有的仓库库存数据列表，包括容量、花卉总数、总售价等信息")
    public Result getAllStore() {
        try {
            return Result.success(storeService.getAllStore());
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @GetMapping("/{id}/get")
    @Operation(summary = "根据ID获取仓库信息", description = "根据仓库ID获取对应的仓库详细信息，包括库存花卉种类、数量及售价")
    public Result getStoreById(
            @Parameter(description = "仓库ID", required = true, example = "1")
            @PathVariable Integer id) {
        try {
            return Result.success(storeService.getStoreById(id));
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
}