package com.work.ggr.redis2cache.webapp.action;

import com.work.ggr.redis2cache.util.RedisUtil1;
import com.work.ggr.redis2cache.util.RedisUtil2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : gr
 * @date : 2019/9/29 11:24
 */
@RestController
@RequestMapping("/redis")
public class Redis2CacheAction {

    @RequestMapping("/test")
    public String test(){
        return "test message";
    }

    @Autowired
    private RedisUtil1 util1;
    @Autowired
    private RedisUtil2 util2;

    @RequestMapping("/redis1/set")
    public String redis1set(HttpServletRequest request, HttpServletResponse response){
        String key=String .valueOf(request.getParameter("key"));
        String value=String .valueOf(request.getParameter("value"));
        return util1.set(key,value)+"";
    }

    @RequestMapping("/redis1/get")
    public String redis1get(HttpServletRequest request,HttpServletResponse response){
        String key=String .valueOf(request.getParameter("key"));
        return util1.get(key)+"";
    }

    @RequestMapping("/redis2/set")
    public String redis2set(HttpServletRequest request, HttpServletResponse response){
        String key=String .valueOf(request.getParameter("key"));
        String value=String .valueOf(request.getParameter("value"));
        return util1.set(key,value)+"";
    }

    @RequestMapping("/redis2/get")
    public String redis2get(HttpServletRequest request,HttpServletResponse response){
        String key=String .valueOf(request.getParameter("key"));
        return util1.get(key)+"";
    }
}
