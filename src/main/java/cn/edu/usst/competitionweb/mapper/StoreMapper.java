package cn.edu.usst.competitionweb.mapper;

import cn.edu.usst.competitionweb.pojo.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreMapper {
    List<Store> getAllStore();
    Store getStoreById(Integer id);
}
