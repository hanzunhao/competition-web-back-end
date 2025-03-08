package cn.edu.usst.competitionweb.dao.impl;

import cn.edu.usst.competitionweb.dao.FlowerPotDao;
import cn.edu.usst.competitionweb.pojo.FlowerPot;
import org.springframework.stereotype.Repository;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class FlowerPotDaoImpl implements FlowerPotDao {
    private static final int POT_NUM = 6;

    @Override
    public List<List<FlowerPot>> getAllFlowerPotForm() {
        // 存有每个大棚8个花盆（共64个）信息的list
        List<List<FlowerPot>> list = new ArrayList<>();

        // 定义随机数生成器
        Random random = new Random();

        // 定义DecimalFormat，保留一位小数
        DecimalFormat df = new DecimalFormat("#.0");

        // 定义各项数据的范围
        double minSoilTemperature = 15.0; // 最低土壤温度（℃）
        double maxSoilTemperature = 30.0; // 最高土壤温度（℃）
        double minSoilHumidity = 20.0; // 最低土壤湿度（%）
        double maxSoilHumidity = 60.0; // 最高土壤湿度（%）

        for (int i = 0; i < 8; i++) {
            List<FlowerPot> potList = new ArrayList<>();

            for (int j = 0; j < POT_NUM; j++) {

                // 花盆id
                Integer id = j + 1;

                // 随机生成各项数据
                Double soilTemperature = Double.valueOf(df.format(minSoilTemperature + (maxSoilTemperature - minSoilTemperature) * random.nextDouble())); // 土壤温度
                Double soilHumidity = Double.valueOf(df.format(minSoilHumidity + (maxSoilHumidity - minSoilHumidity) * random.nextDouble())); // 土壤湿度

                // 创建一个FlowerPot对象
                FlowerPot flowerPot = new FlowerPot(id, soilTemperature, soilHumidity);

                // 将对象加入列表
                potList.add(flowerPot);
            }

            list.add(potList);
        }

        return list;
    }
}
