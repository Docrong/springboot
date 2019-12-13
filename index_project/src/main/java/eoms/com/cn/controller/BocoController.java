package eoms.com.cn.controller;

import eoms.com.cn.model.Company;
import eoms.com.cn.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author : gr
 * @date : 2019/12/11 16:34
 */
@Controller
public class BocoController {
	@Autowired
	private CompanyService service;

	@RequestMapping("/test")
	public String test(HttpServletRequest request, HttpServletResponse response) {
		return "test";
	}

	@RequestMapping("/list")
	public String list(HttpServletRequest request, HttpServletResponse response) {
		Map result = service.findAll();
		System.out.println(result);

		return "list";
	}


	@RequestMapping("/add")
	public String add(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String id = String.valueOf(request.getParameter("id"));
		if (!"null".equals(id)&&!"".equals(id)) {
			Company company = service.findById(id);
			request.setAttribute("object",company);
		}else{
			Company company = new Company();
			request.setAttribute("object",company);

		}
		return "add";
	}

	@RequestMapping("/save")
	public String save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = String.valueOf(request.getParameter("id"));
		System.out.println(id);
		Company company = new Company();
		if (!"null".equals(id)) {
			company.setId(id);
		}
		company.setName(request.getParameter("name"));
		company.setRegisterMoney(request.getParameter("registerMoney"));
		company.setArea(request.getParameter("area"));
		company.setBossName(request.getParameter("bossName"));
		company.setBusinessScope(request.getParameter("businessScope"));
		company.setBusinessStatus(request.getParameter("businessStatus"));
		company.setCreditScore(request.getParameter("creditScore"));
		company.setFinancingSituation(request.getParameter("financingSituation"));
		company.setListedSituation(request.getParameter("listedSituation"));
		company.setSize(request.getParameter("size"));
		Map map = service.saveCompany(company);
		return this.add(request, response);
	}
}
