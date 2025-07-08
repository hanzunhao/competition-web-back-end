package cn.edu.usst.competitionweb.mapper;

import cn.edu.usst.competitionweb.pojo.FlowerPot;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FlowerPotMapper {
    List<FlowerPot> getFlowerPotByGreenHouseId(Integer greenHouseId);
    void deletePestsByPotIds(List<Integer> potIdList);
    void deleteFlowerPotByPotIdList(Integer greenHouseId,List<Integer> potIdList);
    void updateFlowerPotByGreenHouseId(Integer greenHouseId,List<FlowerPot> flowerPotList);
    void deletePestsByPotId(Integer potId);
    void insertPestForPot(Integer potId,String pestName);
}
