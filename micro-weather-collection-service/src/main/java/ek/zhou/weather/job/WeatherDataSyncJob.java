package ek.zhou.weather.job;

import ek.zhou.weather.pojo.City;
import ek.zhou.weather.service.CityClient;
import ek.zhou.weather.service.WeatherDataClient;

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
    private CityClient cityClient;
    //注入天气服务
    @Autowired
    private WeatherDataClient weatherDataClient;
//    cron = "0 */30 * * * *"
    //springboot启动后10s执行一次,每隔半小时再次执行
    //同步数据到redis中
    @Scheduled(fixedDelay = 1800000,initialDelay = 10000)
    public void syncDataJob() {
        System.out.println("同步数据开始----");
        //获取城市集合
        List<City> cities = null;
        cities = cityClient.getCityList();
        //遍历城市集合,同步数据
        for (City city:cities
             ) {
            //同步数据
            weatherDataClient.syncDataByCityId(city.getCityId());
        }

        System.out.println("同步数据结束----");
    }


}
