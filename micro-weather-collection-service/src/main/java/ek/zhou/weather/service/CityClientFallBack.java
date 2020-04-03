package ek.zhou.weather.service;

import ek.zhou.weather.pojo.City;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * 城市服务feign客户端的FallBack处理器
 */
@Component//添加到容器中
public class CityClientFallBack implements CityClient {
    @Override
    public List<City> getCityList() {
        return null;
    }
}
