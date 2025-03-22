package cn.edu.usst.competitionweb.service.impl;

import cn.edu.usst.competitionweb.mapper.LogMapper;
import cn.edu.usst.competitionweb.pojo.Log;
import cn.edu.usst.competitionweb.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;


    @Override
    public void delete(List<Integer> ids) {
        logMapper.delete(ids);
    }

    @Override
    public List<Log> selectAll() {
        return logMapper.selectAll();
    }

    @Override
    public void insert(Log log) {
        LocalDateTime now = LocalDateTime.now();
        log.setDate(now);
        logMapper.insert(log);
    }
}
