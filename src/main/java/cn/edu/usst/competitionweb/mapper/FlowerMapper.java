package cn.edu.usst.competitionweb.mapper;

import cn.edu.usst.competitionweb.pojo.Flower;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface FlowerMapper {
    @Insert("INSERT INTO flower(flower_type_id, number, store_id) " +
            "VALUES((SELECT id FROM flowertype WHERE flower_name = #{name}), #{number}, #{storeId}) " +
            "ON DUPLICATE KEY UPDATE number = number + VALUES(number)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertFlower(Flower flower);
}
