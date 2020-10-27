package com.work.ggr.nacosserver2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosServer2Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosServer2Application.class, args);
    }

}
