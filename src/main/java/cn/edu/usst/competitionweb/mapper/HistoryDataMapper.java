package cn.edu.usst.competitionweb.mapper;

import cn.edu.usst.competitionweb.pojo.HistoryData;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface HistoryDataMapper {
    @Select("SELECT * FROM greenhouseenvhistorydata " +
            "WHERE green_house_id = #{greenHouseId} " +
            "AND time BETWEEN #{startTime} AND #{endTime} " +
            "ORDER BY time")
    List<HistoryData> selectByGreenHouseIdAndTimeRange(
            @Param("greenHouseId") Integer greenHouseId,
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime);

    @Insert("INSERT INTO greenhouseenvhistorydata " +
            "(time, green_house_id, illumination, air_temperature, " +
            "air_humidity, mean_soil_temperature, mean_soil_humidity) " +
            "VALUES " +
            "(#{time}, #{greenHouseId}, #{illumination}, #{airTemperature}, " +
            "#{airHumidity}, #{meanSoilTemperature}, #{meanSoilHumidity})")
    @Options(keyProperty = "time") // 复合主键不自动生成
    void insertHistoryData(HistoryData historyData);
}