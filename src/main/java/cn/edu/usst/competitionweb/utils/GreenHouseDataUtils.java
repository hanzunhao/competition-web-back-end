package cn.edu.usst.competitionweb.utils;

import cn.edu.usst.competitionweb.pojo.GreenHouse;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GreenHouseDataUtils {
    private static final int GREEN_HOUSE_NUM = 8;

    // 定义随机数生成器
    private static final Random random = new Random();

    // 定义DecimalFormat，保留一位小数
    private static final DecimalFormat df = new DecimalFormat("#.0");

    // 定义花卉名称列表
    private static final List<String> flowerNames = List.of("玫瑰", "向日葵", "兰花", "茉莉花", "百合", "菊花", "牡丹", "紫藤");

    // 定义病虫害名称列表
    private static final List<String> pestNames = List.of("红蜘蛛", "蚜虫", "白粉病", "叶斑病", "无", "无", "无", "无");

    // 定义各项数据的范围
    private static final double minIllumination = 1000.0; // 最低光照强度（Lux）
    private static final double maxIllumination = 10000.0; // 最高光照强度（Lux）
    private static final double minAirTemperature = 20.0; // 最低空气温度（℃）
    private static final double maxAirTemperature = 35.0; // 最高空气温度（℃）
    private static final double minSoilTemperature = 15.0; // 最低土壤温度（℃）
    private static final double maxSoilTemperature = 30.0; // 最高土壤温度（℃）
    private static final double minAirHumidity = 40.0; // 最低空气湿度（%）
    private static final double maxAirHumidity = 80.0; // 最高空气湿度（%）
    private static final double minSoilHumidity = 20.0; // 最低土壤湿度（%）
    private static final double maxSoilHumidity = 60.0; // 最高土壤湿度（%）
    private static final double minSoilOrganicMatter = 1.0; // 最低土壤有机质含量（%）
    private static final double maxSoilOrganicMatter = 10.0; // 最高土壤有机质含量（%）
    private static final double minSoilPorosity = 30.0; // 最低土壤疏松性（%）
    private static final double maxSoilPorosity = 60.0; // 最高土壤疏松性（%）
    private static final double minSoilPH = 5.0; // 最低土壤酸碱度（pH）
    private static final double maxSoilPH = 8.0; // 最高土壤酸碱度（pH）
    private static final double minSoilEC = 0.5; // 最低土壤可溶性盐浓度（mS/cm）
    private static final double maxSoilEC = 2.5; // 最高土壤可溶性盐浓度（mS/cm）

    private static List<GreenHouse> list;

    static {
        generateGreenHouseDataList();
    }

    // 生成单个大棚数据
    private static GreenHouse generateGreenHouseData(int id) {
        // 从花卉列表中取出一个花卉名称
        String flowerName = flowerNames.get(id - 1);

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

        // 创建并返回GreenHouse对象
        return new GreenHouse(
                id, flowerName, illumination, airTemperature, soilTemperature,
                airHumidity, soilHumidity, soilOrganicMatterContent, soilPorosity,
                soilPH, soilEC, pestName
        );
    }

    // 生成多个大棚数据
    private static void generateGreenHouseDataList() {
        list = new ArrayList<>();
        for (int i = 0; i < GreenHouseDataUtils.GREEN_HOUSE_NUM; i++) {
            list.add(generateGreenHouseData(i + 1));
        }
    }

    public static List<GreenHouse> getList() {
        return list;
    }

    public static void updateList(List<GreenHouse> greenHouseList) {
        // 遍历传入的 greenHouseList
        for (GreenHouse newGreenHouse : greenHouseList) {
            // 遍历当前的 list
            for (int i = 0; i < list.size(); i++) {
                GreenHouse oldGreenHouse = list.get(i);
                // 如果 id 相同，则替换旧的 GreenHouse 对象
                if (oldGreenHouse.getId().equals(newGreenHouse.getId())) {
                    list.set(i, newGreenHouse);
                    break;
                }
            }
        }
    }
}
