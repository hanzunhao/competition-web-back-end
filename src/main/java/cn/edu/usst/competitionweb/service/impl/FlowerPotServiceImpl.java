package cn.edu.usst.competitionweb.service.impl;

import cn.edu.usst.competitionweb.mapper.FlowerPotMapper;
import cn.edu.usst.competitionweb.pojo.FlowerPot;
import cn.edu.usst.competitionweb.service.FlowerPotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FlowerPotServiceImpl implements FlowerPotService {
    @Autowired
    private FlowerPotMapper flowerPotMapper;

    @Override
    public List<FlowerPot> getFlowerPotByGreenHouseId(Integer greenHouseId) {
        return flowerPotMapper.getFlowerPotByGreenHouseId(greenHouseId);
    }

    @Override
    @Transactional
    public void deleteFlowerPotByPotIdList(Integer greenHouseId, List<Integer> potIdList) {
        // 1. 先删除关联的害虫记录
        flowerPotMapper.deletePestsByPotIds(potIdList);

        // 2. 再删除花盆记录
        flowerPotMapper.deleteFlowerPotByPotIdList(greenHouseId, potIdList);
    }

    @Override
    @Transactional
    public void updateFlowerPotByGreenHouseId(Integer greenHouseId, List<FlowerPot> flowerPotList) {
        flowerPotMapper.updateFlowerPotByGreenHouseId(greenHouseId, flowerPotList);
    }

    @Override
    @Transactional
    public void updateFlowerPotPests(List<FlowerPot> flowerPotList) {
        for (FlowerPot pot : flowerPotList) {
            flowerPotMapper.deletePestsByPotId(pot.getId());
            if (!pot.getPestName().equals("正常花")) flowerPotMapper.insertPestForPot(pot.getId(), pot.getPestName());
        }
    }
}

