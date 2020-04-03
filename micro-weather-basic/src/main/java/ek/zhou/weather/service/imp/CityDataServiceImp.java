package ek.zhou.weather.service.imp;


import ek.zhou.weather.pojo.City;
import ek.zhou.weather.pojo.CityList;
import ek.zhou.weather.service.CityDataService;
import ek.zhou.weather.utils.XStreamUtil;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
@Service
public class CityDataServiceImp implements CityDataService {
    @Override
    public List<City> listCity() throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        Resource resource = new ClassPathResource("citylist.xml");
        try (
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));) {
                while (true){
                    String line = bufferedReader.readLine();
                    if(null==line){
                        break;
                    }
                    stringBuffer.append(line);
                    
                }
        }
        CityList cityList = (CityList)XStreamUtil.toBean(CityList.class, stringBuffer.toString());
        return cityList.getCityList();
    }
}
