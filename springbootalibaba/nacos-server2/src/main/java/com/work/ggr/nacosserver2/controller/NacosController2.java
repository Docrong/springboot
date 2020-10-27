package com.work.ggr.nacosserver2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : gr
 * @date : 2020/10/27 15:24
 */
@Controller
public class NacosController2 {
    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.application.name}")
    private String applicationName;

    @ResponseBody
    @RequestMapping("/message")
    public String message() {
        return applicationName + serverPort;
    }
}
