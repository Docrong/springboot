package com.work.ggr.feign1.contoller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : gr
 * @date : 2020/3/20 11:34
 */
@Component
@FeignClient(value = "eurekaClient",fallback = FeignFallback.class)
public interface FeignInterface {

    @RequestMapping("/name/lisi")
    public String testlisi();

    @RequestMapping("/name/{name}")
    public String testName(@PathVariable("name") String name);

    @RequestMapping("/age")
    public String testAge(@RequestParam String age);
}
