package cn.edu.usst.competitionweb.service;

import cn.edu.usst.competitionweb.pojo.Task;

import java.time.LocalTime;
import java.util.List;

public interface TaskService {
    void insertTask(Task task);
    List<Task> selectAllWeeklyTask();
    void deleteTask(String name, Integer weekDay, LocalTime startTime);

    Integer selectTaskIdByName(String name);
}
