package cn.edu.usst.competitionweb.mapper;

import cn.edu.usst.competitionweb.pojo.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {
    @Select("SELECT id, date, name, is_completed FROM log")
    List<Log> selectAll();

    void delete(List<Integer> ids);

    @Insert("INSERT INTO competition_web.log (date, name, is_completed) VALUES (#{date}, #{name}, #{isCompleted})")
    void insert(Log log);
}
