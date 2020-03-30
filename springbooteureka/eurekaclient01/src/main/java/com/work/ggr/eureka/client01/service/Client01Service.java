package com.work.ggr.eureka.client01.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author : gr
 * @date : 2020/3/15 10:21
 */
@Service
public class Client01Service {

    @Value(value = "${server.port}")
    private String port;

    public String sendMsg(String msg) {
        return "来自client01 msg:" + msg + "---port:" + port;
    }

    public String sendAge(String age) {
        return "来自client01 age:" + age + "---port:" + port;

    }
}
