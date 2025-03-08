package cn.edu.usst.competitionweb.service.impl;

import cn.edu.usst.competitionweb.dao.GreenHouseDao;
import cn.edu.usst.competitionweb.pojo.GreenHouse;
import cn.edu.usst.competitionweb.service.GreenHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreenHouseServiceImpl implements GreenHouseService {
    @Autowired
    private GreenHouseDao greenHouseDao;

    @Override
    public List<GreenHouse> getAllGreenHouseCardForm() {
        return greenHouseDao.getAllGreenHouseCardForm();
    }
}
