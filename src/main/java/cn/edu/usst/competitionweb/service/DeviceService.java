package cn.edu.usst.competitionweb.service;

import cn.edu.usst.competitionweb.pojo.Device;

public interface DeviceService {
    Device getCarStateById(int id);
    Device getSensorStateById(int id);
}
