package cn.edu.usst.competitionweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryData {
    private LocalDateTime time;
    private Integer greenHouseId;
    private Double illumination;
    private Double airTemperature;
    private Double airHumidity;
    private Double meanSoilTemperature;
    private Double meanSoilHumidity;
}