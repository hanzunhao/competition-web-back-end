package cn.edu.usst.competitionweb.service;

import cn.edu.usst.competitionweb.pojo.FlowerPot;

import java.util.List;

public interface FlowerPotService {
    List<List<FlowerPot>> getAllFlowerPotForm();

    void deleteFlowerPotByIdList(Integer greenHouseId, List<Integer> potIdList);

    void updateFlowerPotForm(List<List<FlowerPot>> flowerPotData);
}

