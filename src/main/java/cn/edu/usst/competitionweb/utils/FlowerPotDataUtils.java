package cn.edu.usst.competitionweb.utils;

import cn.edu.usst.competitionweb.pojo.FlowerPot;
import cn.edu.usst.competitionweb.pojo.GreenHouse;

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

    public static void updateFlowerPotData(List<List<FlowerPot>> newFlowerPotData) {
        if (newFlowerPotData != null && newFlowerPotData.size() == GREEN_HOUSE_NUM) {
            for (List<FlowerPot> newFlowerPotDatum : newFlowerPotData) {
                if (newFlowerPotDatum.size() != POT_NUM) {
                    throw new IllegalArgumentException("每个温室的花盆数量必须为 " + POT_NUM);
                }
            }
            for (int i = 0; i < flowerPotData.size() && i < newFlowerPotData.size(); i++) {
                List<FlowerPot> flowerPotList = flowerPotData.get(i);
                List<FlowerPot> newFlowerPotList = newFlowerPotData.get(i);

                for (int j = 0; j < flowerPotList.size() && j < newFlowerPotList.size(); j++) {
                    FlowerPot flowerPot = flowerPotList.get(j);
                    FlowerPot newFlowerPot = newFlowerPotList.get(j);

                    newFlowerPot.setHaveFlower(flowerPot.getHaveFlower());
                }
            }
            flowerPotData = newFlowerPotData;
        } else {
            throw new IllegalArgumentException("温室数量必须为 " + GREEN_HOUSE_NUM);
        }
    }
}
