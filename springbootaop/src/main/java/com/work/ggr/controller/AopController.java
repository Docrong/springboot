package com.work.ggr.controller;

import com.work.ggr.service.AopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : gr
 * @date : 2019/12/6 16:07
 */
@RestController
public class AopController {

	@Autowired
	private AopService service;

	@RequestMapping("/test")
	public String test(){
		service.getPersonInfo("LiHao");
		return "test";
	}
}
