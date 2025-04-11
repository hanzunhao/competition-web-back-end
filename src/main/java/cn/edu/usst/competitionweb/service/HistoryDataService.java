package cn.edu.usst.competitionweb.service;

import cn.edu.usst.competitionweb.pojo.HistoryData;

import java.time.LocalDateTime;
import java.util.List;

public interface HistoryDataService {
    List<HistoryData> selectByGreenHouseIdAndTimeRange(Integer greenHouseId, LocalDateTime startTime, LocalDateTime endTime);
    void insertHistoryData(HistoryData historyData);
}
