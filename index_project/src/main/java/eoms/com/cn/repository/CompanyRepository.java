package eoms.com.cn.repository;

import eoms.com.cn.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : gr
 * @date : 2019/12/12 8:55
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {

	Company findById(String id);
}
