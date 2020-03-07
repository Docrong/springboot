package com.work.ggr.action;

import com.work.ggr.model.Department;
import com.work.ggr.model.Employee;
import com.work.ggr.service.CacheServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : gr
 * @date : 2020/2/29 13:50
 */
@Controller
@RequestMapping("/department")
public class DepartmentAction {

	private CacheServiceImpl cacheService;

	@Autowired
	public DepartmentAction(@Qualifier("cacheService") CacheServiceImpl cacheService) {
		this.cacheService = cacheService;
	}

	@RequestMapping("/test/{id}")
	@ResponseBody
	public String test(@PathVariable("id") Integer id){
		Department t = new Department();
		t.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		t.setDepartmentName(id.toString());
		cacheService.saveDepartment(t);

		return "test";
	}

	@RequestMapping("/test1")
	@ResponseBody
	public String test1(){
		Employee t2=cacheService.getEmployeeById2("1");

		return t2.toString();
	}

}
