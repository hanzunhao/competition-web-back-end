package cn.edu.usst.competitionweb.service.impl;

import cn.edu.usst.competitionweb.mapper.DeviceMapper;
import cn.edu.usst.competitionweb.pojo.Device;
import cn.edu.usst.competitionweb.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceMapper deviceMapper;

    @Transactional
    public Device getCarStateById(int id) {
        return deviceMapper.getCarStateById(id);
    }

    @Transactional
    public Device getSensorStateById(int id) {
        return deviceMapper.getSensorStateById(id);
    }

    @Transactional
    public void updateCarStateById(int id, int stateCode, int power) {
        deviceMapper.updateCarStateById(id, stateCode, power);
    }

    @Transactional
    public void updateSensorStateById(int id, int stateCode, int power) {
        deviceMapper.updateSensorStateById(id, stateCode, power);
    }
}
