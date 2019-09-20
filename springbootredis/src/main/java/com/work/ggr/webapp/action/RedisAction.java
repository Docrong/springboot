package com.work.ggr.webapp.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : gr
 * @date : 2019/9/20 15:38
 */
@RequestMapping("/redis")
@RestController
public class RedisAction {

    @RequestMapping("/test")
    public String test(){
        return "*.jsp";
    }
}
