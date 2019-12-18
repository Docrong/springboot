package eoms.com.cn.controller;

import com.alibaba.fastjson.JSONObject;
import eoms.com.cn.model.Company;
import eoms.com.cn.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : gr
 * @date : 2019/12/13 8:35
 */
@RestController
public class DataController {

	@Autowired
	private CompanyService service;

	@RequestMapping("/data")
	public String data(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getParameter("page"));
		System.out.println(request.getParameter("limit"));//分页

		JSONObject json = new JSONObject();
		Map resultMap= new HashMap();

		Map maptj = new HashMap();
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");

		String name = request.getParameter("name");
		String area = request.getParameter("area");

		maptj.put("page", page);
		maptj.put("limit", limit);
		maptj.put("name", name);
		maptj.put("area", area);

		resultMap=service.getCompanyList(maptj);


		json.put("data", resultMap.get("result"));
		json.put("msg", "");
		json.put("count", ((List)resultMap.get("result")).size());
		json.put("code", 0);

		return json.toString();

	}

	@RequestMapping("/del")
	public String del(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		Company company = service.findById(id);
		String result=service.delCompany(company);
		return result;
	}

	@RequestMapping("/save")
	public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

	}
}
