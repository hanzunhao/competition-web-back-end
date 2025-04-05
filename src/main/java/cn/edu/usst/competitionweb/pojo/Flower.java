package cn.edu.usst.competitionweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flower {
    private Integer id;
    private String name;
    private Integer number;
    private Double sellingPrice;
    private Integer storeId;
}
