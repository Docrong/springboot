package com.work.ggr.nacosconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author : gr
 * @date : 2020/10/27 15:34
 */
@Controller
public class NacosConsumerController {
    @Resource
    private RestTemplate restTemplate;

    @ResponseBody
    @RequestMapping("/getMessage")
    public String getMessage(){
        return restTemplate.getForObject("http://nacos-server/message", String.class);
    }
}
