package com.work.ggr.dao;

import com.work.ggr.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : gr
 * @date : 2020/2/29 13:47
 */
@Repository("departmentRepository")
public interface DepartmentRepository extends JpaRepository<Department,Integer> {

	Department findById(String id);

}
