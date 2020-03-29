package com.work.ggr.eureka.client03.service;

import org.springframework.stereotype.Service;

/**
 * @author : gr
 * @date : 2020/3/15 10:21
 */
@Service
public class Client03Service {

    public String testFeign(String msg){
        return "来自client01 msg:"+msg;
    }
}
