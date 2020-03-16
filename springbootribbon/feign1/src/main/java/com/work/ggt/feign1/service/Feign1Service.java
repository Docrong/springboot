package com.work.ggt.feign1.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * @author : gr
 * @date : 2020/3/15 19:36
 */
@FeignClient(value = "EUREKACLIENT" )
public interface Feign1Service {
    /**
     * 123
     * @param msg
     * @return
     */
    @RequestMapping(value = "/name/{msg}", method = RequestMethod.GET,consumes = "application/json")
    String feignTest(@PathVariable(name = "msg") String msg);

    @RequestMapping(value = "/age",method = RequestMethod.GET)
    String feignAge(@RequestParam(name = "age") String age);


}
