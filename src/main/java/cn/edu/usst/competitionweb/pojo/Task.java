package cn.edu.usst.competitionweb.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Task", description = "任务信息实体")
public class Task {
    private Integer id;
    private String name;
    private Integer weekDay;
    private LocalTime startTime;
}
