package cn.edu.usst.competitionweb.service.impl;

import cn.edu.usst.competitionweb.mapper.TaskMapper;
import cn.edu.usst.competitionweb.pojo.Task;
import cn.edu.usst.competitionweb.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<Task> selectAllTask() {
        return taskMapper.selectAllTask();
    }

    @Override
    @Transactional
    public void deleteTaskById(Integer id) {
        taskMapper.deleteTaskById(id);
    }

    @Override
    public Integer selectTaskIdByName(String name) {
        return taskMapper.selectTaskIdByName(name);
    }
}
