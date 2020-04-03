package ek.zhou.weather.controller;

import ek.zhou.weather.pojo.City;
import ek.zhou.weather.pojo.CityList;
import ek.zhou.weather.service.CityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 城市服务控制层对外提供城市列表服务
 */
@RestController
public class CityController {
    //注入城市服务
    @Autowired
    private CityDataService cityDataService;
    @GetMapping("/weather/cityList")
    public List<City> getCityList(){
        List<City> cities = null;
        try {
            cities = cityDataService.listCity();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }
}
