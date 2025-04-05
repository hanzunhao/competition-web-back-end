package cn.edu.usst.competitionweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    private Integer id;
    private Integer capacity;
    private Integer totalFlowerNumber;
    private Double totalSellingPrice;
    private List<String> flowerNames;
    private List<Integer> flowerNumbers;
    private List<Double> flowerSellingPrices;
}
