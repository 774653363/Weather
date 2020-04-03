package ek.zhou.weather.service;

import ek.zhou.weather.pojo.WeatherResponse;

/**
 * 天气数据服务
 */
public interface WeatherDataService {
    /**
     * 根据城市ID查询天气数据
     *
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市名称查询天气数据
     *
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);

    /**
     * 根据城市id同步数据到redis
     */
    void syncDataByCityId(String cityId);


}
