package com.work.ggr.redis2cache.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author : gr
 * @date : 2019/9/29 11:24
 */
@Component
public class RedisUtil2 {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate2;

    public RedisUtil2(RedisTemplate<String, Object> redisTemplate2) {
        this.redisTemplate2 = redisTemplate2;
    }

    /**
     * 普通缓存获取
     * @param key 键
     * @return 值
     */
    public Object get(String key){
        return key==null?null:redisTemplate2.opsForValue().get(key);
    }

    /**
     * 普通缓存放入
     * @param key 键
     * @param value 值
     * @return true成功 false失败
     */
    public boolean set(String key,Object value) {
        try {
            redisTemplate2.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
