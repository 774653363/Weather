package ek.zhou.weather.service;

import ek.zhou.weather.pojo.WeatherResponse;
import org.springframework.stereotype.Component;

/**
 * 天气服务feign客户端的FallBack处理器
 */
@Component//添加到容器中
public class WeatherDataClientFallBack implements WeatherDataClient {
    @Override
    public WeatherResponse getWeatherByCityId(String cityId) {
        return null;
    }

    @Override
    public WeatherResponse getWeatherByCityName(String cityName) {
        return null;
    }

    @Override
    public String syncDataByCityId(String cityId) {
        return null;
    }
}
