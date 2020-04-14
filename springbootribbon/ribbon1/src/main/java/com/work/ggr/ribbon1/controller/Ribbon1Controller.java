package com.work.ggr.ribbon1.controller;

import com.work.ggr.ribbon1.config.MyLb;
import com.work.ggr.ribbon1.service.Ribbon01Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author : gr
 * @date : 2020/3/15 11:43
 */
@Controller
public class Ribbon1Controller {

    @Autowired
    private Ribbon01Service service;


    @RequestMapping("/ribbon1/{msg}")
    @ResponseBody
    public String ribbon1(@PathVariable(name = "msg") String msg) {
        return service.sendMsg(msg);
    }

//    重写负载均衡
    @Resource
    private MyLb loader;
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;
    @RequestMapping("/ribbon2/{msg}")
    @ResponseBody
    public String ribbon2(@PathVariable(name = "msg") String msg) {
        List instanceList = discoveryClient.getInstances("eurekaClient");
        if (instanceList == null || instanceList.isEmpty()) {
            return null;
        }
        ServiceInstance serviceInstance = loader.instances(instanceList);
        URI uri=serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/name/"+msg,String .class);
    }

}
