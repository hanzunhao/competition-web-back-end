package cn.edu.usst.competitionweb.mapper;

import cn.edu.usst.competitionweb.pojo.GreenHouse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface GreenHouseMapper {
    GreenHouse getGreenHouseById(@Param("id") Integer id);

    List<GreenHouse> getAllGreenHouse();

    void updateGreenHouse(GreenHouse greenHouse);
}
