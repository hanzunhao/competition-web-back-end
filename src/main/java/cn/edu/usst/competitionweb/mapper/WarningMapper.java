package cn.edu.usst.competitionweb.mapper;

import cn.edu.usst.competitionweb.pojo.Warning;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WarningMapper {
    @Select("SELECT id, date, name, reason FROM competition_web.warning")
    List<Warning> selectAll();

    void delete(List<Integer> ids);

    @Insert("INSERT INTO competition_web.warning (date, name, reason) VALUES (#{date}, #{name}, #{reason})")
    void insert(Warning warning);
}
