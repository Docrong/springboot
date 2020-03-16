package com.work.ggt.feign1.controller;

import com.work.ggt.feign1.service.Feign1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : gr
 * @date : 2020/3/15 19:36
 */
@Controller
public class Feign1Controller {

    @Autowired
    private Feign1Service service;

    @RequestMapping(value = "/hi/{msg}",method = RequestMethod.GET)
    public String sayHi(@PathVariable(value = "msg") String msg) {
        return service.feignTest(msg);
    }

    @RequestMapping(value = "/age",method = RequestMethod.GET)
    public String feiAge(@RequestParam String age) {
        System.out.println("feign01 age:"+age);
        return service.feignAge(age);
    }
}
