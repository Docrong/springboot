package com.work.ggr.eureka.client02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Eurekaclient02Application {

    public static void main(String[] args) {
        SpringApplication.run(Eurekaclient02Application.class, args);
    }

}
