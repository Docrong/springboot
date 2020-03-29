package com.work.ggr.hystrixfeign.controller;

import com.work.ggr.hystrixfeign.service.HystrixFeignService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author : gr
 * @date : 2020/3/29 10:08
 */
@Controller
public class HystrixFeignController {

    @Resource
    private HystrixFeignService service;
    @RequestMapping("/feign/testlisi")
    @ResponseBody
    public String feignTestLisi(){
        return service.testlisi();
    }

    @RequestMapping("/feign/testName/{name}")
    @ResponseBody
    public String feignTestName(@PathVariable(value = "name" )String name  ) {
        return service.testName(name);
    }

    @RequestMapping("/feign/testAge/{age}")
    @ResponseBody
    public String feignTestAge(@PathVariable("age") String age){
        return service.testAge(age);
    }
}
