package cn.edu.usst.competitionweb.mapper;

import cn.edu.usst.competitionweb.pojo.Device;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DeviceMapper {
    @Select("SELECT * FROM device WHERE id = #{id} AND type = 'car'")
    Device getCarStateById(int id);

    @Select("SELECT * FROM device WHERE id = #{id} AND type = 'sensor'")
    Device getSensorStateById(int id);
}
