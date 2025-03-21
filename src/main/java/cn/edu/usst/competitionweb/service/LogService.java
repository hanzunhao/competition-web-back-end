package cn.edu.usst.competitionweb.service;

import cn.edu.usst.competitionweb.pojo.Log;

import java.util.List;

public interface LogService {
    void delete(List<Integer> ids);

    List<Log> selectAll();

    void insert(Log log);
}
