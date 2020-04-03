package ek.zhou.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 天气服务网管
 * 用于提供一个统一入口来访问天气服务
 */
@EnableZuulProxy //开启zuul网关服务
@SpringBootApplication
public class MicroWeatherZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWeatherZuulGatewayApplication.class, args);
    }

}
