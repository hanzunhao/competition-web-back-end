package cn.edu.usst.competitionweb.service.impl;

import cn.edu.usst.competitionweb.dao.FlowerPotDao;
import cn.edu.usst.competitionweb.pojo.FlowerPot;
import cn.edu.usst.competitionweb.service.FlowerPotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerPotServiceImpl implements FlowerPotService {
    @Autowired
    private FlowerPotDao flowerPotDao;

    @Override
    public List<List<FlowerPot>> getAllFlowerPotForm() {
        return flowerPotDao.getAllFlowerPotForm();
    }

    @Override
    public void deleteFlowerPotByIdList(List<Integer> ids) {
        flowerPotDao.deleteFlowerPotByIdList(ids);
    }
}
