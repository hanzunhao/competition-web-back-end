package cn.edu.usst.competitionweb.utils;

import cn.edu.usst.competitionweb.pojo.FlowerPot;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlowerPotDataUtils {
    private static final int POT_NUM = 18;
    private static final int GREEN_HOUSE_NUM = 8;
    private static List<List<FlowerPot>> flowerPotData;

    static {
        generateData();
    }

    private static void generateData() {
        flowerPotData = new ArrayList<>();

        Random random = new Random();
        DecimalFormat df = new DecimalFormat("#.0");

        double minSoilTemperature = 15.0; // 最低土壤温度（℃）
        double maxSoilTemperature = 30.0; // 最高土壤温度（℃）
        double minSoilHumidity = 20.0; // 最低土壤湿度（%）
        double maxSoilHumidity = 60.0; // 最高土壤湿度（%）

        for (int i = 0; i < GREEN_HOUSE_NUM; i++) {
            List<FlowerPot> potList = new ArrayList<>();

            for (int j = 0; j < POT_NUM; j++) {
                Integer id = j + 1;
                Double soilTemperature = Double.valueOf(df.format(minSoilTemperature + (maxSoilTemperature - minSoilTemperature) * random.nextDouble()));
                Double soilHumidity = Double.valueOf(df.format(minSoilHumidity + (maxSoilHumidity - minSoilHumidity) * random.nextDouble()));
                Boolean haveFlower = true;

                FlowerPot flowerPot = new FlowerPot(id, soilTemperature, soilHumidity, haveFlower);
                potList.add(flowerPot);
            }

            flowerPotData.add(potList);
        }
    }

    public static List<List<FlowerPot>> getFlowerPotData() {
        return flowerPotData;
    }
}
