package ek.zhou.weather.controller;

import ek.zhou.weather.pojo.City;
import ek.zhou.weather.pojo.Weather;
import ek.zhou.weather.service.CityDataService;
import ek.zhou.weather.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 天气响应控制层
 */
@Controller

public class WeatherReportController {
    //注入天气响应服务
    @Autowired
    private WeatherReportService weatherReportService;
    //注入城市数据服务
    @Autowired
    private CityDataService cityDataService;
    @GetMapping("/report/cityId/{cityId}")
    public String getWeatherByCityId(@PathVariable String cityId, Map<String,Object> map){
        //获取城市列表
        List<City> cities = null;
        try {
            cities = cityDataService.listCity();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //获取当前城市id对应的天气响应
        Weather data = weatherReportService.getDataByCityId(cityId);
        map.put("title","困困的天气预报");
        map.put("cityId",cityId);
        map.put("cityList",cities);
        map.put("report",data);
        return "weather/report";
    }
}
