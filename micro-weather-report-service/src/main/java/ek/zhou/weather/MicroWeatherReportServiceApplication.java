package ek.zhou.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 天气响应微服务
 * 显示界面给用户使用天气服务
 */
@EnableCircuitBreaker//开启Feign项目的Hystrix监控
@EnableEurekaClient
@EnableFeignClients(basePackages = "ek.zhou.weather.service")
@SpringBootApplication
public class MicroWeatherReportServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWeatherReportServiceApplication.class, args);
    }

}
