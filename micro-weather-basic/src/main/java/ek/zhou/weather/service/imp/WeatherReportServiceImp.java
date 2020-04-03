package ek.zhou.weather.service.imp;

import ek.zhou.weather.pojo.Weather;
import ek.zhou.weather.pojo.WeatherResponse;
import ek.zhou.weather.service.WeatherDataService;
import ek.zhou.weather.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 天气响应服务实现类
 */
@Service
public class WeatherReportServiceImp implements WeatherReportService {
    //注入天气数据服务
    @Autowired
    private WeatherDataService weatherDataService;

    /**
     * 返回天气数据
     * @param cityId
     * @return
     */
    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse data = weatherDataService.getDataByCityId(cityId);
        if(null!=data){
            return data.getData();
        }
       return null;
    }
}
