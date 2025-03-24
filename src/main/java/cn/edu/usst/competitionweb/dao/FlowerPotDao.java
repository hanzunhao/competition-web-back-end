package cn.edu.usst.competitionweb.dao;

import cn.edu.usst.competitionweb.pojo.FlowerPot;

import java.util.List;

public interface FlowerPotDao {
    List<List<FlowerPot>> getAllFlowerPotForm();
    void deleteFlowerPotByIdList(Integer greenHouseId,List<Integer> potIdList);

    void updateFlowerPotForm(List<List<FlowerPot>> flowerPotData);
}
