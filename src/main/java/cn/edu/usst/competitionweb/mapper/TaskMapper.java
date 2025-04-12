package cn.edu.usst.competitionweb.mapper;

import cn.edu.usst.competitionweb.pojo.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskMapper {
    @Insert("INSERT INTO competition_web.task (name, week_day, start_time) VALUES (#{name}, #{weekDay}, #{startTime})")
    void insertTask(Task task);

    @Select("SELECT id, name, week_day, start_time FROM competition_web.task")
    List<Task> selectAllTask();

    @Select("SELECT id FROM competition_web.task WHERE task.name = #{name}")
    Integer selectTaskIdByName(String name);

    @Delete("DELETE FROM competition_web.task WHERE task.id = #{id}")
    void deleteTaskById(Integer id);
}
