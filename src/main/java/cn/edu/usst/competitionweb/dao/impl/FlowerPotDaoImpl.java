package cn.edu.usst.competitionweb.dao.impl;

import cn.edu.usst.competitionweb.dao.FlowerPotDao;
import cn.edu.usst.competitionweb.pojo.FlowerPot;
import cn.edu.usst.competitionweb.utils.FlowerPotDataUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlowerPotDaoImpl implements FlowerPotDao {
    @Override
    public List<List<FlowerPot>> getAllFlowerPotForm() {
        return FlowerPotDataUtils.getFlowerPotData();
    }

    @Override
    public void deleteFlowerPotByIdList(Integer greenHouseId, List<Integer> potIdList) {
        List<List<FlowerPot>> data = FlowerPotDataUtils.getFlowerPotData();

        for (FlowerPot flowerPot : data.get(greenHouseId)) {
            if (potIdList.contains(flowerPot.getId())) {
                flowerPot.setHaveFlower(false);
            }
        }
    }

    @Override
    public void updateFlowerPotForm(List<List<FlowerPot>> flowerPotData) {
        FlowerPotDataUtils.updateFlowerPotData(flowerPotData);
    }
}
