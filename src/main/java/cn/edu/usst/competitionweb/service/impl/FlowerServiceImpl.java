package cn.edu.usst.competitionweb.service.impl;

import cn.edu.usst.competitionweb.mapper.FlowerMapper;
import cn.edu.usst.competitionweb.pojo.Flower;
import cn.edu.usst.competitionweb.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FlowerServiceImpl implements FlowerService {
    @Autowired
    private FlowerMapper flowerMapper;


    @Override
    @Transactional
    public void insertFlower(Flower flower) {
        flowerMapper.insertFlower(flower);
    }
}
