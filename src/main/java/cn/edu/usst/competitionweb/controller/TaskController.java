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

import java.time.LocalTime;

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

    @Operation(summary = "获取突发任务ID", description = "根据任务名称返回突发任务ID")
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

    @Operation(summary = "查询全部周任务", description = "获取当前所有周任务")
    @GetMapping("/select")
    public Result selectAllWeeklyTask() {
        try {
            return Result.success(taskService.selectAllWeeklyTask());
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }

    @Operation(summary = "删除任务", description = "根据名称、日期和开始时间移除任务")
    @DeleteMapping("/delete/{name}/{weekDay}/{startTime}")
    public Result deleteTask(
            @Parameter(description = "任务名称", required = true)
            @PathVariable String name,
            @Parameter(description = "任务执行日期", required = true)
            @PathVariable Integer weekDay,
            @Parameter(description = "任务开始时间", required = true)
            @PathVariable LocalTime startTime
    ) {
        try {
            taskService.deleteTask(name, weekDay, startTime);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
}