package cn.edu.usst.competitionweb.service;

import cn.edu.usst.competitionweb.pojo.FlowerPot;

import java.util.List;

public interface FlowerPotService {
    List<FlowerPot> getFlowerPotByGreenHouseId(Integer greenHouseId);

    void deleteFlowerPotByPotIdList(Integer greenHouseId, List<Integer> potIdList);

    void updateFlowerPotByGreenHouseId(Integer greenHouseId,List<FlowerPot> flowerPotList);

    void updateFlowerPotPests(List<FlowerPot> flowerPotList);
}

