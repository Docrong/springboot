package com.work.ggr.eureka.client02.service;

import org.springframework.stereotype.Service;

/**
 * @author : gr
 * @date : 2020/3/15 10:21
 */
@Service
public class Client02Service {

    public String testFeign(String msg){
        return "来自client02 msg:"+msg;
    }
}
