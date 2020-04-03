package ek.zhou.weather.service;

import ek.zhou.weather.pojo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 城市服务feign客户端
 */
//value:指定调用的服务名称
@FeignClient(value = "microservice-config-city-service",fallback = CityClientFallBack.class )
public interface CityClient {
    @GetMapping("/weather/cityList")
    public List<City> getCityList();
}
