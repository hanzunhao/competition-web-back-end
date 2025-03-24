package cn.edu.usst.competitionweb.dao.impl;

import cn.edu.usst.competitionweb.dao.GreenHouseDao;
import cn.edu.usst.competitionweb.pojo.GreenHouse;
import cn.edu.usst.competitionweb.utils.GreenHouseDataUtils;
import org.springframework.stereotype.Repository;

import java.util.List;


/*
 * 生成8张大棚卡片的各项数据（随机生成）
 * */
@Repository
public class GreenHouseDaoImpl implements GreenHouseDao {
    @Override
    public List<GreenHouse> getAllGreenHouseForm() {
        return GreenHouseDataUtils.getList();
    }

    @Override
    public void updateGreenHouseForm(List<GreenHouse> greenHouseList) {
        GreenHouseDataUtils.updateList(greenHouseList);
    }
}

// TODO 增加删除温室
// TODO 插入新任务打断日常任务
// TODO 价格表格下加上仓库显示和计算价格
// TODO 自动根据字符串list或者文件夹使用ds接口
// TODO 首页
// TODO 拖拽花盆下发搬运任务