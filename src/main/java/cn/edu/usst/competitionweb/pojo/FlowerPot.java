package cn.edu.usst.competitionweb.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "FlowerPot", description = "花盆实时监测数据")
public class FlowerPot {
    private Integer id;
    private Double soilTemperature;
    private Double soilHumidity;
    private Boolean haveFlower;
    private String pestName;
}
