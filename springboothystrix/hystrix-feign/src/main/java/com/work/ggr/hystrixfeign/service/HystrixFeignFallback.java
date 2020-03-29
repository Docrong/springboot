package com.work.ggr.hystrixfeign.service;

import org.springframework.stereotype.Component;

/**
 * @author : gr
 * @date : 2020/3/29 10:14
 */
@Component
public class HystrixFeignFallback implements HystrixFeignService {
    @Override
    public String testlisi() {
        return "test lisi null";
    }

    @Override
    public String testName(String name) {
        return "test "+name+" null";
    }

    @Override
    public String testAge(String age) {
        return "test "+age+" null";
    }
}
