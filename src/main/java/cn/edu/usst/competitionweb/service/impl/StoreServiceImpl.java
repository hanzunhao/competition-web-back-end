package cn.edu.usst.competitionweb.service.impl;

import cn.edu.usst.competitionweb.mapper.StoreMapper;
import cn.edu.usst.competitionweb.pojo.Store;
import cn.edu.usst.competitionweb.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreMapper storeMapper;

    @Override
    public List<Store> getAllStore() {
        return storeMapper.getAllStore();
    }

    @Override
    public Store getStoreById(Integer id) {
        return storeMapper.getStoreById(id);
    }
}
