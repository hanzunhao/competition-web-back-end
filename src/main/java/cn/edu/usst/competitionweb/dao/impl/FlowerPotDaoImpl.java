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
    public void deleteFlowerPotByIdList(List<Integer> ids) {
        List<List<FlowerPot>> data = FlowerPotDataUtils.getFlowerPotData();

        for (List<FlowerPot> potList : data) {
            for (FlowerPot flowerPot : potList) {
                if (ids.contains(flowerPot.getId())) {
                    flowerPot.setHaveFlower(false);
                }
            }
        }
    }
}
