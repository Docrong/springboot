package com.work.ggr.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : guoguirong
 * @date : 2020/11/16 15:06
 */
@Controller
public class IndexController {
    @RequestMapping("/loginPage")
    public String login() {
        return "login_page";
    }
}
