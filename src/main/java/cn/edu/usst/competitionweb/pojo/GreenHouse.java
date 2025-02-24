package cn.edu.usst.competitionweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GreenHouse {
    // 大棚ID
    private Integer id;
    // 花卉名称
    private String flowerName;
    // 气温
    private Double temperature;
    // 湿度
    private Double wetness;
    // 是否有病虫害
    private Boolean havePest;
    // todo 待补充的属性
}
