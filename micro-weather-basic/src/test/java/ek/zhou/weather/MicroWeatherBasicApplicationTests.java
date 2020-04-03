package ek.zhou.weather;

import ek.zhou.weather.pojo.City;
import ek.zhou.weather.service.CityDataService;
import ek.zhou.weather.service.imp.CityDataServiceImp;
import ek.zhou.weather.utils.XStreamUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MicroWeatherBasicApplicationTests {
    @Autowired
    private CityDataService cityDataService;
    @Test
    public void contextLoads() throws  Exception{
        List<City> cities = cityDataService.listCity();
        System.out.println(cities);
    }

}
