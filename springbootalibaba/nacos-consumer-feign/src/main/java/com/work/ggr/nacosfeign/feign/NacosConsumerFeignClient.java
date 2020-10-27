package com.work.ggr.nacosfeign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : gr
 * @date : 2020/10/27 16:53
 */
@FeignClient("nacos-server")
public interface NacosConsumerFeignClient {

    @RequestMapping("/message")
    String getMessage(@RequestParam(required = false, value = "msg") String msg);
}
