package com.work.ggr.eureka.client03.controller;

import com.work.ggr.eureka.client03.service.Client03Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author : gr
 * @date : 2020/3/15 10:14
 */
@Controller
public class Client03Controller {

    @Resource
    private Client03Service service;

    @RequestMapping("/name/{msg}")
    @ResponseBody
    public String name(@PathVariable(name = "msg") String msg){
        return service.sendMsg(msg);
    }

    @RequestMapping(value = "/age",method = RequestMethod.GET)
    @ResponseBody
    public String age(@RequestParam String age) {
        return service.sendAge(age);
    }
}
