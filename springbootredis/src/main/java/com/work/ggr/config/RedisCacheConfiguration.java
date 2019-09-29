package com.work.ggr.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author : gr
 * @date : 2019/9/29 9:47
 */
@Configuration
public class RedisCacheConfiguration {
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private String port;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.jedis.pool.max-active}")
    private String max_active;
    @Value("${spring.redis.jedis.pool.max-wait}")
    private String max_wait;
    @Value("${spring.redis.jedis.pool.max-idle}")
    private String max_idle;
    @Value("${spring.redis.jedis.pool.min-idle}")
    private String min_idle;

}
