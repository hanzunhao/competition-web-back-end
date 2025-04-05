package cn.edu.usst.competitionweb.service;

import cn.edu.usst.competitionweb.pojo.Store;

import java.util.List;

public interface StoreService {
    List<Store> getAllStore();
    Store getStoreById(Integer id);
}
