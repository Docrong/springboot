package com.work.ggr.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : gr
 * @date : 2020/4/21 15:20
 */
@RestController
@RefreshScope
public class ClientController {

    @Value("${word}")
    private String word;
    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {

        return name+" "+ word;
    }
}
