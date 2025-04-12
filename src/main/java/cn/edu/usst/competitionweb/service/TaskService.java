package cn.edu.usst.competitionweb.service;

import cn.edu.usst.competitionweb.pojo.Task;

import java.util.List;

public interface TaskService {
    void insertTask(Task task);
    List<Task> selectAllTask();
    void deleteTaskById(Integer id);

    Integer selectTaskIdByName(String name);
}
