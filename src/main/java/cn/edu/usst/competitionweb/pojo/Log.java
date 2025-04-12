package cn.edu.usst.competitionweb.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Log", description = "操作日志记录")
public class Log {
    private Integer id;
    private LocalDateTime date;
    private String name;
    private Boolean isCompleted;
}
