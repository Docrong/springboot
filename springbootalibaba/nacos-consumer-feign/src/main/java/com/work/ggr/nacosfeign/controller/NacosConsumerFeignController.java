package com.work.ggr.nacosfeign.controller;

import com.work.ggr.nacosfeign.feign.NacosConsumerFeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : gr
 * @date : 2020/10/27 16:53
 */
@RestController
public class NacosConsumerFeignController {
    @Resource(type = NacosConsumerFeignClient.class)
    private NacosConsumerFeignClient client;

    @RequestMapping("/getMessage")
    public String getMessSage() {
        return client.getMessage();
    }
}
