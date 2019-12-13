package eoms.com.cn.service;

import eoms.com.cn.model.Company;
import eoms.com.cn.repository.CompanyDao;
import eoms.com.cn.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : gr
 * @date : 2019/12/12 8:54
 */
@Service
public class CompanyService {
	@Autowired
	CompanyRepository repository;
	public Map findAll(){
		Map map = new HashMap<>();
		List list=repository.findAll();
		map.put("result", list);
		return map;
	}

	public Map saveCompany(Company company) {
		Map map = new HashMap();

		repository.save(company);
		return map;
	}

	public Company findById(String id) {
		Company company=repository.findById(id);
		return company;
	}

	@Autowired
	private CompanyDao companyDao;
	public Map getCompanyList(Map maptj){
		return companyDao.getCompanyList(maptj);
	}
}
