package com.work.ggr.eureka.server3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author : gr
 * @date : 2020/3/15 8:49
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer3Application {
    public static void main(String[] args){
        SpringApplication.run(EurekaServer3Application.class,args);
    }
}
