package cn.edu.usst.competitionweb.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Store", description = "仓库库存及销售数据")
public class Store {
    private Integer id;
    private Integer capacity;
    private Integer totalFlowerNumber;
    private Double totalSellingPrice;
    private List<String> flowerNames;
    private List<Integer> flowerNumbers;
    private List<Double> flowerSellingPrices;
}
