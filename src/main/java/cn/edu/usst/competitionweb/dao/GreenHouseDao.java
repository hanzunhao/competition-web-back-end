package cn.edu.usst.competitionweb.dao;

import cn.edu.usst.competitionweb.pojo.GreenHouse;

import java.util.List;

public interface GreenHouseDao {
    List<GreenHouse> getAllGreenHouseForm();
    void updateGreenHouseForm(List<GreenHouse> greenHouseList);
}
