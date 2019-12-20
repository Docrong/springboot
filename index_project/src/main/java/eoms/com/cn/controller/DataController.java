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

		Map requestMap=request.getParameterMap();

		String[] name = (String[]) requestMap.get("name");
		String[] area = (String[]) requestMap.get("area");


		Map maptj = new HashMap();
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");


		maptj.put("page", page);
		maptj.put("limit", limit);
		maptj.put("name", name!=null&&name.length>0?name[0]:"");
		maptj.put("area", area!=null&&area.length>0?area[0]:"");

		Map resultMap=service.getCompanyList(maptj);


		JSONObject json = new JSONObject();
		json.put("data", resultMap.get("result"));
		json.put("msg", "");
		json.put("count", ((Integer) resultMap.get("total")));
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
