package ek.zhou.weather.controller;

import ek.zhou.weather.pojo.WeatherResponse;
import ek.zhou.weather.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 天气服务控制层
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {
    //注入天气数据服务
    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable  String cityId){
        return weatherDataService.getDataByCityId(cityId);
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable  String cityName){
        return weatherDataService.getDataByCityName(cityName);
    }

    @GetMapping("/syncDataByCityId/{cityId}")
    public String syncDataByCityId(@PathVariable String cityId) {
        weatherDataService.syncDataByCityId(cityId);
        return "ok";
    }


}
