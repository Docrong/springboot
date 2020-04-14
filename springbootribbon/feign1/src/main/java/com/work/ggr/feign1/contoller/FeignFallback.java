package com.work.ggr.feign1.contoller;

import org.springframework.stereotype.Component;

/**
 * @author : gr
 * @date : 2020/3/20 13:58
 */
@Component
public class FeignFallback implements FeignInterface {

    @Override
    public String testlisi() {
        return "error";
    }

    @Override
    public String testName(String name) {
        return "error";
    }

    @Override
    public String testAge(String age) {
        return "error";
    }
}
