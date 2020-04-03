package ek.zhou.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 城市服务微服务
 * 用于向其他微服务提供城市列表功能
 */
@EnableEurekaClient
@SpringBootApplication
public class MicroWeatherCityServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWeatherCityServiceApplication.class, args);
    }

}
