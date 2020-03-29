package com.work.ggr.thystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author : gr
 * @date : 2020/3/20 22:35
 */
@Service
//@DefaultProperties(defaultFallback = "test_fail_error")//默认全局断路器
public class HystrixService {
    @Value("${server.port}")
    private String port;

    public String test_ok() {
        return Thread.currentThread().getName() + " test_OK";
    }

    @HystrixCommand(fallbackMethod = "test_fail_timeout",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")//超时服务降级
    })
    public String test_timeout() {
        int sleep = 5;
        try {
            TimeUnit.SECONDS.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName() + " test_OK";
    }

    public String test_fail_timeout(){
        return "业务超时test_fail_error";
    }

    /**
     * see it at public abstract class HystrixCommandProperties
     * circuitBreaker.enabled 是否开启断路器
     * circuitBreaker.requestVolumeThreshold 请求次数
     * circuitBreaker.sleepWindowInMilliseconds 窗口期
     * circuitBreaker.errorThresholdPercentage 错误率
     */
    @HystrixCommand(fallbackMethod = "circuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    }
    )
    public String circuitBreaker (String msg) throws Exception {
        if (msg.equalsIgnoreCase("error")) {
            throw new RuntimeException("出现错误"+new Date());
        }

        return "circuitBreaker 业务完成";
    }


    public String circuitBreaker_fallback(String msg)throws Exception {
        return "circuitBreaker_fallback 断路器开始工作!!!";
    }
}
