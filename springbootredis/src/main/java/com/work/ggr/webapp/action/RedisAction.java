package com.work.ggr.webapp.action;

import com.work.ggr.model.UserEntity;
import com.work.ggr.util.RedisUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author : gr
 * @date : 2019/9/20 15:38
 */
@RequestMapping("/redis")
@RestController
public class RedisAction {


    @RequestMapping("/test")
    public String test(){
        System.out.println("test");
        return "Enter Test";
    }

    private static int ExpireTime = 60;   // redis中存储的过期时间60s

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("set")
    public boolean redisset(String key, String value){
        UserEntity userEntity =new UserEntity();
        userEntity.setId(String .valueOf(1));
        userEntity.setGuid(String.valueOf(1));
        userEntity.setName("zhangsan");
        userEntity.setAge(String.valueOf(20));
        userEntity.setCreateTime(new Date());

//        return redisUtil.set(key,userEntity,ExpireTime);//添加设置时间为60s
        return redisUtil.set(key,userEntity);
//        return redisUtil.set(key,value);
    }

    @RequestMapping("get")
    public Object redisget(String key){
        System.out.println(redisUtil.get(key));
        return redisUtil.get(key);
    }

    @RequestMapping("expire")
    public boolean expire(String key){
        return redisUtil.expire(key,ExpireTime);
    }

}
