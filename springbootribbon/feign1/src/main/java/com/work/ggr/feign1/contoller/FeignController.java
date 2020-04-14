package com.work.ggr.feign1.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author : gr
 * @date : 2020/3/20 11:33
 */
@Controller
public class FeignController {

    @Resource
    private FeignInterface feignInterface;

    @RequestMapping("/feign/test1")
    @ResponseBody
    public String feignTest1(){
        return feignInterface.testlisi();
    }

    @RequestMapping("/feign/{name}")
    @ResponseBody
    public String feignName(@PathVariable("name") String name){
        return feignInterface.testName(name);
    }

    @RequestMapping("/feign/age")
    @ResponseBody
    public String feignAge(@RequestParam String age) {
        return feignInterface.testAge(age);
    }

}
