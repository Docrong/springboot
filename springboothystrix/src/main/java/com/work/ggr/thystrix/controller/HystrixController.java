package com.work.ggr.thystrix.controller;

import com.work.ggr.thystrix.service.HystrixService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author : gr
 * @date : 2020/3/20 22:35
 */
@Controller
public class HystrixController {

    @Resource
    private HystrixService service;

    @RequestMapping("/hystrix/ok")
    @ResponseBody
    public String test_ok(){
        return service.test_ok();
    }
    @RequestMapping("/hystrix/timeout")
    @ResponseBody
    public String test_timeout(){
        return service.test_timeout();
    }

    @RequestMapping("/circuitBreaker/{msg}")
    @ResponseBody
    public String circuitBreaker(@PathVariable("msg")String msg) throws Exception {
        return service.circuitBreaker(msg);
    }

}
