package ek.zhou.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 天气服务单体架构
 *
 */
@EnableScheduling
@SpringBootApplication
public class MicroWeatherBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWeatherBasicApplication.class, args);
    }

}
