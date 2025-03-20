package cn.edu.usst.competitionweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlowerPot {
    private Integer id;
    private Double soilTemperature;     // 土壤温度
    private Double soilHumidity;        // 土壤湿度
    private Boolean haveFlower;         // 是否有花
}
