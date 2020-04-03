package ek.zhou.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 天气数据采集微服务
 * 用于定时采集天气数据并同步到redis中
 */
@EnableCircuitBreaker //开启feign自带的hystrix监控
@EnableScheduling //开启定时服务
@EnableEurekaClient //开启eureka服务
@EnableFeignClients(basePackages = "ek.zhou.weather.service")//开启feign客户端,扫描ek.zhou.weather.service包下的注解
@SpringBootApplication
public class MicroWeatherCollectionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWeatherCollectionServiceApplication.class, args);
    }

}
