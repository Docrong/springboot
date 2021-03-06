package eoms.com.cn.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : gr
 * @date : 2019/12/13 11:00
 */
@Repository("jpaDao")
@Transactional(value = "transactionManagermain")
public class CompanyDao {
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	public Map getCompanyList(Map maptj){
		String name = (String) maptj.get("name");
		String area = (String) maptj.get("area");
		String page = String.valueOf(maptj.get("page"));
		String limit = String.valueOf(maptj.get("limit"));
		String sql = "from Company where 1=1";
		if (name!=null&&!"".equals(name)) {
			sql += " and name like '%" + name + "%'";
		}
		if (area != null && !"".equals(area)) {
			sql += " and area like '%" + area + "%'";
		}
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery(sql);

		if (!limit.equals("" )&& !"null".equals(limit)) {
			query.setFirstResult(Integer.valueOf(limit) * (Integer.valueOf(page)-1));
			query.setMaxResults(Integer.valueOf(limit));
		}
		Integer total=entityManager.createQuery(sql).getResultList().size();

		List list = query.getResultList();
		Map result = new HashMap<>();
		result.put("total", total);
		result.put("result", list);
		entityManager.close();

		return result;
	}
}
