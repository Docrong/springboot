package com.work.ggr.nacosserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : gr
 * @date : 2020/10/27 15:14
 */
@RestController
@RequestMapping("/")
public class NacosController {
    @Value("${server.port}")
    private String serverPort;
    @Value("${spring.application.name}")
    private String applicationName;

    @RequestMapping("/message")
    public String message() {
        return applicationName + serverPort;
    }
}
