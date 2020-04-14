package com.work.ggr.zookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 整合zookeeper作为springcloud的注册中心
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SpringbootzookeeperApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootzookeeperApplication.class, args);
    }

}
