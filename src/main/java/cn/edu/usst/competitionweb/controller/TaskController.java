package cn.edu.usst.competitionweb.controller;

import cn.edu.usst.competitionweb.pojo.Result;
import cn.edu.usst.competitionweb.pojo.Task;
import cn.edu.usst.competitionweb.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "任务管理", description = "任务调度与跟踪接口")
@RequestMapping("/task")
@RestController
@Slf4j
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Operation(summary = "创建新任务", description = "添加任务")
    @PutMapping("/insert")
    public Result insertTask(
            @Parameter(description = "任务实体类", required = true)
            @RequestBody Task task) {
        try {
            taskService.insertTask(task);
            log.info(" 创建任务成功 @ {}", new java.util.Date());
            return Result.success();
        } catch (Exception e) {
            log.error(" 任务创建异常：{}", e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    @Operation(summary = "获取任务ID", description = "根据任务名称返回任务ID")
    @GetMapping("/select/{name}")
    public Result deleteTaskById(
            @Parameter(description = "任务名称", required = true)
            @PathVariable String name) {
        try {
            return Result.success(taskService.selectTaskIdByName(name));
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @Operation(summary = "查询全部任务", description = "获取当前所有任务")
    @GetMapping("/select")
    public Result selectAllTask() {
        try {
            return Result.success(taskService.selectAllTask());
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @Operation(summary = "删除任务", description = "根据ID移除任务")
    @DeleteMapping("/delete/{id}")
    public Result deleteTaskById(
            @Parameter(description = "任务ID", required = true)
            @PathVariable Integer id) {
        try {
            taskService.deleteTaskById(id);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
}