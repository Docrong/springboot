package com.work.ggr.action;

import com.work.ggr.model.Department;
import com.work.ggr.service.CacheServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : gr
 * @date : 2020/2/29 13:50
 */
@Controller("/department")
public class DepartmentAction {

	private CacheServiceImpl cacheService;

	@Autowired
	public DepartmentAction(@Qualifier("cacheService") CacheServiceImpl cacheService) {
		this.cacheService = cacheService;
	}

	@RequestMapping("/test1")
	@ResponseBody
	public String test1(){
		Department t = cacheService.getDepartmentById("1");
		System.out.println("result is :"+t);
		return "test1";
	}
}
