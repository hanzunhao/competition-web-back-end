package cn.edu.usst.competitionweb.dao.impl;

import cn.edu.usst.competitionweb.dao.GreenHouseDao;
import cn.edu.usst.competitionweb.pojo.GreenHouse;
import org.springframework.stereotype.Repository;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * 8张大棚卡片的各项数据写死（随机生成）
 * */
@Repository
public class GreenHouseDaoImpl implements GreenHouseDao {
    @Override
    public List<GreenHouse> getAllGreenHouseCardForm() {
        // 存有8个卡片信息的list
        List<GreenHouse> list = new ArrayList<>();

        // 定义大棚温度湿度范围
        Random random = new Random();
        double minTemperature = 20.0; // 最低温度
        double maxTemperature = 35.0; // 最高温度
        double minWetness = 40.0; // 最低湿度
        double maxWetness = 80.0; // 最高湿度

        // 定义花卉名称列表
        List<String> flowerNames = new ArrayList<>(List.of("玫瑰", "向日葵", "兰花", "茉莉花", "百合", "菊花", "牡丹", "紫藤"));

        // 定义DecimalFormat，保留一位小数
        DecimalFormat df = new DecimalFormat("#.0");

        for (int i = 0; i < 8; i++) {
            // 大棚ID
            Integer id = i + 1;

            // 从花卉列表中取出一个花卉名称
            String flowerName = flowerNames.get(i);

            // 气温，保留一位小数
            Double temperature = Double.valueOf(df.format(minTemperature + (maxTemperature - minTemperature) * random.nextDouble()));

            // 湿度，保留一位小数
            Double wetness = Double.valueOf(df.format(minWetness + (maxWetness - minWetness) * random.nextDouble()));

            // 是否有病虫害
            Boolean havePest = random.nextBoolean();

            // 创建一个GreenHouseCard对象
            GreenHouse card = new GreenHouse(id, flowerName, temperature, wetness, havePest);

            // 将卡片加入列表
            list.add(card);
        }

        // 返回包含8个卡片的列表
        return list;
    }
}
