package com.work.ggr.service;

import com.work.ggr.dao.DepartmentRepository;
import com.work.ggr.dao.EmployeeRepository;
import com.work.ggr.model.Department;
import com.work.ggr.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : gr
 * @date : 2020/2/29 15:50
 */
@Transactional
@Service("cacheService")
public class CacheServiceImpl {

	private EmployeeRepository employeeRepository;
	private DepartmentRepository departmentRepository;

	@Autowired
	public CacheServiceImpl(@Qualifier("employeeRepository")EmployeeRepository employeeRepository,@Qualifier("departmentRepository")DepartmentRepository departmentRepository) {
		this.departmentRepository=departmentRepository;
		this.employeeRepository=employeeRepository;
	}

	public Employee getEmployeeById(String id){
		return employeeRepository.findById(id);
	}
	@Cacheable(cacheNames = "emp",key ="#id")
	public Employee getEmployeeById2(String id){
		return employeeRepository.findById(id);
	}

	@CachePut(cacheNames = "emp",key="#t.id")
	public void saveEmployee(Employee t) {
		employeeRepository.save(t);
	}

	@CacheEvict(cacheNames = "emp",key = "#t.id")
	public void deleteEmployee(Employee t) {
		employeeRepository.delete(t);
	}

	public Department getDepartmentById(String id) {
		return departmentRepository.findById(id);
	}

	public void deleteDepartment(Department department) {
		departmentRepository.delete(department);
	}

	public void saveDepartment(Department department) {
		departmentRepository.save(department);
	}
}
