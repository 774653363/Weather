package ek.zhou.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 天气系统配置中心
 * 管理全部微服务的配置文件
 * github url:https://github.com/774653363/micro-weather-config.git
 */
@EnableConfigServer//开启配置中心服务
@SpringBootApplication
public class MicroWeatherConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWeatherConfigApplication.class, args);
    }

}
