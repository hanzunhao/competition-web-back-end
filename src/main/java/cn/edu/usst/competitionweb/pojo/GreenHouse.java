package cn.edu.usst.competitionweb.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 温室（大棚）信息类
 * 用于表示温室的环境参数和状态
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "GreenHouse", description = "温室实时监控数据")
public class GreenHouse {
    private Integer greenHouseId;
    private Integer storeId;
    private String flowerName;
    private Integer totalPots;
    private Integer potsWithFlowers;
    private Double illumination;
    private Double airTemperature;
    private Double meanSoilTemperature;
    private Double airHumidity;
    private Double meanSoilHumidity;
    private String pestNames;
}
