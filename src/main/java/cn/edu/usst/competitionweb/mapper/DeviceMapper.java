package cn.edu.usst.competitionweb.mapper;

import cn.edu.usst.competitionweb.pojo.Device;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DeviceMapper {
    @Select("SELECT * FROM device WHERE id = #{id} AND type = 'car'")
    Device getCarStateById(int id);

    @Select("SELECT * FROM device WHERE id = #{id} AND type = 'sensor'")
    Device getSensorStateById(int id);

    @Update("UPDATE device SET state_code=#{stateCode} ,power=#{power} WHERE id = #{id} AND type = 'car'")
    void updateCarStateById(int id, int stateCode, int power);

    @Update("UPDATE device SET state_code=#{stateCode} ,power=#{power} WHERE id = #{id} AND type = 'sensor'")
    void updateSensorStateById(int id, int stateCode, int power);
}
