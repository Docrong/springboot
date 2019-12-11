package eoms.com.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : gr
 * @date : 2019/12/11 16:34
 */
@Controller
public class BocoController {

	@RequestMapping("/test")
	public String test(HttpServletRequest request, HttpServletResponse response) {
		return "test";
	}

	@RequestMapping("/list")
	public String list(HttpServletRequest request, HttpServletResponse response) {
		return "list";
	}

	@RequestMapping("/add")
	public String add(HttpServletRequest request, HttpServletResponse response) {
		return "list";
	}

}
