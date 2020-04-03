package ek.zhou.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 天气数据微服务
 * 用于向其他微服务提供根据城市信息查询天气和同步天气数据到redis中的功能
 */
@EnableEurekaClient
@SpringBootApplication
public class MicroWeatherDataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWeatherDataServiceApplication.class, args);
    }

}
