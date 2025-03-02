package cn.edu.usst.competitionweb.service;

import cn.edu.usst.competitionweb.pojo.Warning;

import java.util.List;

public interface WarningService {
    void delete(List<Integer> ids);

    List<Warning> selectAll();

    void insert(Warning warning);
}
