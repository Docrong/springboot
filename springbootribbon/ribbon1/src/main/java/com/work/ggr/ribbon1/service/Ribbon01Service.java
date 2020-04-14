package com.work.ggr.ribbon1.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author : gr
 * @date : 2020/3/15 11:38
 */
@Service
public class Ribbon01Service {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String sendMsg(String msg) {
        return restTemplate.getForObject("http://eurekaClient/name/"+msg,String.class);
    }

    public String hiError(String msg){
        return "HystrixCommand Error";
    }
}
