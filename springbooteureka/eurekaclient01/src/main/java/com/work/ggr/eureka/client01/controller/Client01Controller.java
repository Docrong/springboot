package com.work.ggr.eureka.client01.controller;

import com.work.ggr.eureka.client01.service.Client01Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author : gr
 * @date : 2020/3/15 10:14
 */
@Controller
public class Client01Controller {

    private Client01Service service;

    public Client01Controller() {
    }

    @Autowired
    public Client01Controller(Client01Service service) {
        this.service = service;
    }


    @RequestMapping("/name/{msg}")
    @ResponseBody
    public String name(@PathVariable(name = "msg") String msg) {
        return service.sendMsg(msg);
    }

    @RequestMapping(value = "/age", method = RequestMethod.GET)
    @ResponseBody
    public String age(@RequestParam String age) {
        return service.sendAge(age);
    }
}
