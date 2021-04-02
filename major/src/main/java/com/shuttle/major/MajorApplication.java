package com.shuttle.major;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("com.shuttle.major.mapper")
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class MajorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MajorApplication.class, args);
    }

}
