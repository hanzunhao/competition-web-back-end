package cn.edu.usst.competitionweb.service;

import cn.edu.usst.competitionweb.pojo.Device;

public interface DeviceService {
    Device getCarStateById(int id);

    Device getSensorStateById(int id);

    void updateCarStateById(int id, int stateCode, int power);

    void updateSensorStateById(int id, int stateCode, int power);
}
