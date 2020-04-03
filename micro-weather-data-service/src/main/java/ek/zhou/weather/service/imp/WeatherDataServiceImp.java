package ek.zhou.weather.service.imp;

import com.fasterxml.jackson.databind.ObjectMapper;
import ek.zhou.weather.pojo.WeatherResponse;
import ek.zhou.weather.service.WeatherDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 天气数据服务实现类
 */
@Service
public class WeatherDataServiceImp implements WeatherDataService {
    //请求路径前缀
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    //设置超时时间
    private static final long TIME_OUT = 1800;
    //注入restTemplate
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;



    private static final Logger logger = LoggerFactory.getLogger(WeatherDataServiceImp.class);

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String url = WEATHER_URI + "citykey=" + cityId;
        return getDataAndSaveDataToRedis(url);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String url = WEATHER_URI + "city=" + cityName;
        return getDataAndSaveDataToRedis(url);
    }

    @Override
    public void syncDataByCityId(String cityId) {
        String url = WEATHER_URI + "citykey=" + cityId;
        saveDataByCityId(url);
    }

    /**
     * 查询数据后存入redis
     * @param url
     */
    private void saveDataByCityId(String url){
        ObjectMapper objectMapper = new ObjectMapper();
        //先从redis中取数据
        String dataJson = null;
        //发送请求获取数据
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);

        if (entity.getStatusCodeValue() == 200) {
            dataJson = entity.getBody();
        }
        //将数据存入redis中
        stringRedisTemplate.opsForValue().set(url, dataJson, TIME_OUT, TimeUnit.SECONDS);


    }

    private WeatherResponse getDataAndSaveDataToRedis(String url){
        ObjectMapper objectMapper = new ObjectMapper();
        //先从redis中取数据
        String dataJson = null;
        //缓存中存在数据
        if (stringRedisTemplate.hasKey(url)) {
            dataJson = stringRedisTemplate.opsForValue().get(url);
            logger.info("redis中有数据");
        } else {
            //缓存中没有数据
            logger.info("redis中没有数据");
            //发送请求获取数据
            ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
            System.out.println(entity.getBody());
            System.out.println(entity.getStatusCodeValue());
            if (entity.getStatusCodeValue() == 200) {
                dataJson = entity.getBody();
            }
            //将数据存入redis中
            stringRedisTemplate.opsForValue().set(url, dataJson, TIME_OUT, TimeUnit.SECONDS);
        }
        //将json转换成pojo返回
        WeatherResponse response = null;
        try {
            response = objectMapper.readValue(dataJson, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
