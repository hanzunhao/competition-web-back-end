package cn.edu.usst.competitionweb.service.impl;

import cn.edu.usst.competitionweb.mapper.GreenHouseMapper;
import cn.edu.usst.competitionweb.pojo.GreenHouse;
import cn.edu.usst.competitionweb.service.GreenHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GreenHouseServiceImpl implements GreenHouseService {
    @Autowired
    private GreenHouseMapper greenHouseMapper;

    @Override
    public List<GreenHouse> getAllGreenHouse() {
        return greenHouseMapper.getAllGreenHouse();
    }

    @Override
    @Transactional
    public void updateGreenHouse(GreenHouse greenHouse) {
        greenHouseMapper.updateGreenHouse(greenHouse);
    }

    @Override
    public GreenHouse getGreenHouseById(Integer id) {
        return greenHouseMapper.getGreenHouseById(id);
    }
}
