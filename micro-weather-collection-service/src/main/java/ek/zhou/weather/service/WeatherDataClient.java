package ek.zhou.weather.service;

import ek.zhou.weather.pojo.WeatherResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 天气服务feign客户端
 */

@FeignClient(value = "microservice-config-data-service",fallback = WeatherDataClientFallBack.class)
public interface WeatherDataClient {


    @GetMapping("/weather/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable String cityId);

    @GetMapping("/weather/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable String cityName);
    @GetMapping("/weather/syncDataByCityId/{cityId}")
    public String syncDataByCityId(@PathVariable String cityId) ;



}
