package com.work.ggr.eureka.client02.controller;

import com.work.ggr.eureka.client02.service.Client02Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author : gr
 * @date : 2020/3/15 10:14
 */
@Controller
public class Client02Controller {

    private Client02Service service;

    @Autowired
    public Client02Controller(Client02Service service) {
        this.service=service;
    }


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
