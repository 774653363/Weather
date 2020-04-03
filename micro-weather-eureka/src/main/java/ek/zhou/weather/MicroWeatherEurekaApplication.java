package ek.zhou.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 天气系统eureka服务注册中心
 * 用于管理治理微服务
 */
@EnableEurekaServer
@SpringBootApplication
public class MicroWeatherEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWeatherEurekaApplication.class, args);
    }

}
