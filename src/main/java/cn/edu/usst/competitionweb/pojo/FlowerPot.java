package cn.edu.usst.competitionweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlowerPot {
    private Integer id;
    private Double soilTemperature;
    private Double soilHumidity;
    private Boolean haveFlower;
    private String pestName;
}
