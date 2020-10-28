package com.workggr.nacosconfig.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : gr
 * @date : 2020/10/28 14:35
 */
@RestController
@RequestMapping("/config")
public class NacosConfigController {
    @Value("${spring.redis.port}")
    private String port;
    @NacosValue(value = "${spring.redis.port}", autoRefreshed = true)
    private String port2;

    @RequestMapping("/getMessage")
    public String getMessage() {
        System.out.println(port+"------"+port2);
        return port;
    }

}
