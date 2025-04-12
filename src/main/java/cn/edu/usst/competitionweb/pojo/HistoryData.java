package cn.edu.usst.competitionweb.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "HistoryData", description = "温室历史监测数据")
public class HistoryData {
    private LocalDateTime time;
    private Integer greenHouseId;
    private Double illumination;
    private Double airTemperature;
    private Double airHumidity;
    private Double meanSoilTemperature;
    private Double meanSoilHumidity;
}