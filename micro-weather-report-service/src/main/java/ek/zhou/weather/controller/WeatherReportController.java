package ek.zhou.weather.controller;

import ek.zhou.weather.pojo.City;
import ek.zhou.weather.pojo.Weather;
import ek.zhou.weather.pojo.WeatherResponse;
import ek.zhou.weather.service.CityClient;
import ek.zhou.weather.service.WeatherDataClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/**
 * 天气响应控制层
 */
@Controller

public class WeatherReportController {
    //注入天气响应服务
    @Autowired
    private WeatherDataClient weatherDataClient;
    //注入城市数据服务
    @Autowired
    private CityClient cityClient;
    @GetMapping("/report/cityId/{cityId}")
    public String getWeatherByCityId(@PathVariable String cityId, Map<String,Object> map){
        //获取城市列表
        List<City> cities = cityClient.getCityList();

        //获取当前城市id对应的天气响应
        WeatherResponse data = weatherDataClient.getWeatherByCityId(cityId);
        map.put("title","困困的天气预报");
        map.put("cityId",cityId);
        map.put("cityList",cities);
        map.put("report",data.getData());
        return "weather/report";
    }
}
