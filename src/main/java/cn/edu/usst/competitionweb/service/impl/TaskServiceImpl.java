package cn.edu.usst.competitionweb.service.impl;

import cn.edu.usst.competitionweb.mapper.TaskMapper;
import cn.edu.usst.competitionweb.pojo.Task;
import cn.edu.usst.competitionweb.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;

    @Override
    @Transactional
    public void insertTask(Task task) {
        taskMapper.insertTask(task);
    }

    @Override
    public List<Task> selectAllWeeklyTask() {
        return taskMapper.selectAllWeeklyTask();
    }

    @Override
    @Transactional
    public void deleteTask(String name, Integer weekDay, LocalTime startTime) {
        taskMapper.deleteTask(name,weekDay,startTime);
    }

    @Override
    public Integer selectTaskIdByName(String name) {
        return taskMapper.selectTaskIdByName(name);
    }
}
