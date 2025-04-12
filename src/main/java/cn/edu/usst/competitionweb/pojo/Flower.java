package cn.edu.usst.competitionweb.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Flower", description = "花卉库存实体")
public class Flower {
    private Integer id;
    private String name;
    private Integer number;
    private Double sellingPrice;
    private Integer storeId;
}
