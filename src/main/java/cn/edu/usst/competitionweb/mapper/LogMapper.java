package cn.edu.usst.competitionweb.mapper;

import cn.edu.usst.competitionweb.pojo.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {
    @Select("SELECT id, date, name, isCompleted FROM competition_web.logs")
    List<Log> selectAll();

    void delete(List<Integer> ids);

    @Insert("INSERT INTO competition_web.logs (date, name, isCompleted) VALUES (#{date}, #{name}, #{isCompleted})")
    void insert(Log log);
}
