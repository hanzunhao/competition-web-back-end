package cn.edu.usst.competitionweb.service.impl;

import cn.edu.usst.competitionweb.mapper.WarningMapper;
import cn.edu.usst.competitionweb.pojo.Warning;
import cn.edu.usst.competitionweb.service.WarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarningServiceImpl implements WarningService {
    @Autowired
    WarningMapper warningMapper;


    @Override
    public void delete(List<Integer> ids) {
        warningMapper.delete(ids);
    }

    @Override
    public List<Warning> selectAll() {
        return warningMapper.selectAll();
    }

    @Override
    public void insert(Warning warning) {
        warningMapper.insert(warning);
    }
}
