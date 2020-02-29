package com.work.ggr.dao;

import com.work.ggr.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : gr
 * @date : 2020/2/29 13:44
 */
@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	Employee findById(String id);

}
