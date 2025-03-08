package cn.edu.usst.competitionweb.dao.impl;

import cn.edu.usst.competitionweb.dao.GreenHouseDao;
import cn.edu.usst.competitionweb.pojo.GreenHouse;
import org.springframework.stereotype.Repository;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * 生成8张大棚卡片的各项数据（随机生成）
 * */
@Repository
public class GreenHouseDaoImpl implements GreenHouseDao {
    @Override
    public List<GreenHouse> getAllGreenHouseCardForm() {
        // 存有8个卡片信息的list
        List<GreenHouse> list = new ArrayList<>();

        // 定义随机数生成器
        Random random = new Random();

        // 定义DecimalFormat，保留一位小数
        DecimalFormat df = new DecimalFormat("#.0");

        // 定义花卉名称列表
        List<String> flowerNames = new ArrayList<>(List.of("玫瑰", "向日葵", "兰花", "茉莉花", "百合", "菊花", "牡丹", "紫藤"));

        // 定义各项数据的范围
        double minIllumination = 1000.0; // 最低光照强度（Lux）
        double maxIllumination = 10000.0; // 最高光照强度（Lux）
        double minAirTemperature = 20.0; // 最低空气温度（℃）
        double maxAirTemperature = 35.0; // 最高空气温度（℃）
        double minSoilTemperature = 15.0; // 最低土壤温度（℃）
        double maxSoilTemperature = 30.0; // 最高土壤温度（℃）
        double minAirHumidity = 40.0; // 最低空气湿度（%）
        double maxAirHumidity = 80.0; // 最高空气湿度（%）
        double minSoilHumidity = 20.0; // 最低土壤湿度（%）
        double maxSoilHumidity = 60.0; // 最高土壤湿度（%）
        double minSoilOrganicMatter = 1.0; // 最低土壤有机质含量（%）
        double maxSoilOrganicMatter = 10.0; // 最高土壤有机质含量（%）
        double minSoilPorosity = 30.0; // 最低土壤疏松性（%）
        double maxSoilPorosity = 60.0; // 最高土壤疏松性（%）
        double minSoilPH = 5.0; // 最低土壤酸碱度（pH）
        double maxSoilPH = 8.0; // 最高土壤酸碱度（pH）
        double minSoilEC = 0.5; // 最低土壤可溶性盐浓度（mS/cm）
        double maxSoilEC = 2.5; // 最高土壤可溶性盐浓度（mS/cm）

        // 定义病虫害名称列表
        List<String> pestNames = new ArrayList<>(List.of("红蜘蛛", "蚜虫", "白粉病", "叶斑病", "无", "无", "无", "无"));

        for (int i = 0; i < 8; i++) {
            // 大棚ID
            Integer id = i + 1;

            // 从花卉列表中取出一个花卉名称
            String flowerName = flowerNames.get(i);

            // 随机生成各项数据
            Double illumination = Double.valueOf(df.format(minIllumination + (maxIllumination - minIllumination) * random.nextDouble())); // 光照强度
            Double airTemperature = Double.valueOf(df.format(minAirTemperature + (maxAirTemperature - minAirTemperature) * random.nextDouble())); // 空气温度
            Double soilTemperature = Double.valueOf(df.format(minSoilTemperature + (maxSoilTemperature - minSoilTemperature) * random.nextDouble())); // 土壤温度
            Double airHumidity = Double.valueOf(df.format(minAirHumidity + (maxAirHumidity - minAirHumidity) * random.nextDouble())); // 空气湿度
            Double soilHumidity = Double.valueOf(df.format(minSoilHumidity + (maxSoilHumidity - minSoilHumidity) * random.nextDouble())); // 土壤湿度
            Double soilOrganicMatterContent = Double.valueOf(df.format(minSoilOrganicMatter + (maxSoilOrganicMatter - minSoilOrganicMatter) * random.nextDouble())); // 土壤有机质含量
            Double soilPorosity = Double.valueOf(df.format(minSoilPorosity + (maxSoilPorosity - minSoilPorosity) * random.nextDouble())); // 土壤疏松性
            Double soilPH = Double.valueOf(df.format(minSoilPH + (maxSoilPH - minSoilPH) * random.nextDouble())); // 土壤酸碱度
            Double soilEC = Double.valueOf(df.format(minSoilEC + (maxSoilEC - minSoilEC) * random.nextDouble())); // 土壤可溶性盐浓度
            String pestName = pestNames.get(random.nextInt(pestNames.size())); // 随机选择一个病虫害名称

            // 创建一个GreenHouse对象
            GreenHouse greenHouse = new GreenHouse(
                    id, flowerName, illumination, airTemperature, soilTemperature,
                    airHumidity, soilHumidity, soilOrganicMatterContent, soilPorosity,
                    soilPH, soilEC, pestName
            );

            // 将对象加入列表
            list.add(greenHouse);
        }

        // 返回包含8个大棚信息的列表
        return list;
    }
}