package com.work.ggr.hystrixfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : gr
 * @date : 2020/3/29 10:08
 */
@Service
@FeignClient(name = "EUREKACLIENT",fallback = HystrixFeignFallback.class)
public interface HystrixFeignService {

    @RequestMapping("/name/lisi")
    public String testlisi();

    @RequestMapping("/name/{name}")
    public String testName(@PathVariable("name") String name);

    @RequestMapping("/age")
    public String testAge(@RequestParam String age);
}
