package com.work.ggr.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author : gr
 * @date : 2020/2/29 12:48
 */
@Entity
@Table(name = "department")
@GenericGenerator(name = "system-uuid", strategy = "uuid.hex")//自定义主键生成策略
public class Department {
	@Id
	@GeneratedValue(generator = "system-uuid")//JPA通用策略生成器
	@Column(name = "id", unique = true)
	private String id;
	@Column(name = "departmentName",columnDefinition = "varchar(2000)")
	private String departmentName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
