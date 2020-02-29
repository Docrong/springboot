package com.work.ggr.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author : gr
 * @date : 2020/2/29 12:49
 */
@Entity
@Table(name = "Employee")
@GenericGenerator(name = "system-uuid", strategy = "uuid.hex")//自定义主键生成策略
public class Employee {
	@Id
	@GeneratedValue(generator = "system-uuid")//JPA通用策略生成器
	@Column(name = "id", unique = true)
	private String id;

	@Column(name = "lastName",columnDefinition ="varchar(2000)" )
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "gender",columnDefinition = "int")
	private Integer gender;

	@Column(name = "dId")
	private Integer dId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getdId() {
		return dId;
	}

	public void setdId(Integer dId) {
		this.dId = dId;
	}
}
