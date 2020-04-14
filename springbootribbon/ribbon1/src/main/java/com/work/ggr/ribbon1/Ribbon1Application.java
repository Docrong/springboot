package com.work.ggr.ribbon1;

import com.work.ggr.rule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableDiscoveryClient
@RibbonClient(name = "eurekaClient",configuration = MyRule.class)//注册ribbon负载策略
public class Ribbon1Application {

    public static void main(String[] args) {
        SpringApplication.run(Ribbon1Application.class, args);
    }

//    @LoadBalanced//重写load规则
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
