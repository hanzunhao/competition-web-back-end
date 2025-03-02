package cn.edu.usst.competitionweb.pojo;

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
public class GreenHouse {
    /**
     * 大棚ID，唯一标识符
     */
    private Integer id;

    /**
     * 花卉名称
     */
    private String flowerName;

    /**
     * 光照强度，单位：勒克斯（Lux）
     */
    private Double illumination;

    /**
     * 空气温度，单位：摄氏度（℃）
     */
    private Double airTemperature;

    /**
     * 土壤温度，单位：摄氏度（℃）
     */
    private Double soilTemperature;

    /**
     * 空气湿度，单位：百分比（%）
     */
    private Double airHumidity;

    /**
     * 土壤湿度，单位：百分比（%）
     */
    private Double soilHumidity;

    /**
     * 土壤有机质含量，单位：百分比（%）
     */
    private Double soilOrganicMatterContent;

    /**
     * 土壤疏松性（孔隙度），单位：百分比（%）
     */
    private Double soilPorosity;

    /**
     * 土壤酸碱度（pH值），单位：无（pH范围为0-14）
     */
    private Double soilPH;

    /**
     * 土壤可溶性盐浓度（电导率），单位：毫西门子/厘米（mS/cm）
     */
    private Double soilEC;

    /**
     * 病虫害名称
     */
    private String pestName;
}