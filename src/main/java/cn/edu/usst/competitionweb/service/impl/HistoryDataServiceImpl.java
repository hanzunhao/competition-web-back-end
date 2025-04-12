package cn.edu.usst.competitionweb.service.impl;

import cn.edu.usst.competitionweb.mapper.HistoryDataMapper;
import cn.edu.usst.competitionweb.pojo.HistoryData;
import cn.edu.usst.competitionweb.service.HistoryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HistoryDataServiceImpl implements HistoryDataService {

    @Autowired
    private HistoryDataMapper historyDataMapper;

    @Override
    public List<HistoryData> selectByGreenHouseIdAndTimeRange(Integer greenHouseId, LocalDateTime startTime, LocalDateTime endTime) {
        return historyDataMapper.selectByGreenHouseIdAndTimeRange(greenHouseId, startTime, endTime);
    }

    @Override
    @Transactional
    public void insertHistoryData(HistoryData historyData) {
        historyDataMapper.insertHistoryData(historyData);
    }
}
