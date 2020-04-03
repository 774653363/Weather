package ek.zhou.weather.job;

import ek.zhou.weather.pojo.City;
import ek.zhou.weather.service.CityDataService;
import ek.zhou.weather.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 每半小时同步一次城市数据到redis中
 */
@Component
public class WeatherDataSyncJob {
    //注入城市服务
    @Autowired
    private CityDataService cityDataService;
    //注入天气服务
    @Autowired
    private WeatherDataService weatherDataService;
//    cron = "0 */30 * * * *"
    //springboot启动后10s执行一次,每隔半小时再次执行
    //同步数据到redis中
    @Scheduled(fixedDelay = 1800000,initialDelay = 10000)
    public void syncDataJob() {
        System.out.println("同步数据开始----");
        //获取城市集合
        List<City> cities = null;
        try {
            cities = cityDataService.listCity();
        } catch (Exception e) {
            e.printStackTrace();
        }


        //遍历城市集合,同步数据
        for (City city:cities
             ) {
            //同步数据
            weatherDataService.syncDataByCityId(city.getCityId());
        }

        System.out.println("同步数据结束----");
    }
}
