package cn.edu.usst.competitionweb.service;

import cn.edu.usst.competitionweb.pojo.GreenHouse;

import java.util.List;


public interface GreenHouseService {
    List<GreenHouse> getAllGreenHouse();
    void updateGreenHouse(GreenHouse greenHouse);
    GreenHouse getGreenHouseById(Integer id);
}
