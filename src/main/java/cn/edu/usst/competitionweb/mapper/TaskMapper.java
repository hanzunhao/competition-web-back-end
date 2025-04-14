package cn.edu.usst.competitionweb.mapper;

import cn.edu.usst.competitionweb.pojo.Task;
import org.apache.ibatis.annotations.*;

import java.time.LocalTime;
import java.util.List;

@Mapper
public interface TaskMapper {
    @Insert("INSERT INTO competition_web.task (name, week_day, start_time) VALUES (#{name}, #{weekDay}, #{startTime})")
    void insertTask(Task task);

    @Select("SELECT id, name, week_day, start_time FROM competition_web.task WHERE task.week_day > 0")
    List<Task> selectAllWeeklyTask();

    @Select("SELECT id FROM competition_web.task WHERE task.name = #{name}")
    Integer selectTaskIdByName(String name);

    @Delete("DELETE FROM competition_web.task WHERE task.name = #{name} AND task.week_day=#{weekDay} AND task.start_time=#{startTime}")
    void deleteTask(String name, Integer weekDay, LocalTime startTime);
}
