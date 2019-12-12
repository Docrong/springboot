package eoms.com.cn.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author : gr
 * @date : 2019/12/12 8:38
 */
@Entity
@Table(name = "company")
@GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
public class Company {
	@Id
	@GeneratedValue(generator = "system-uuid")//JPA通用策略生成器
	@Column(name = "id", unique = true)
	private String id;
	@Column(name = "Name")
	private String name;//企业名称
	@Column(name = "Area")
	private String area;//企业归属地
	@Column(name = "registerMoney")
	private String registerMoney;//注册资本
	@Column(name = "size")
	private String size;//公司规模
	@Column(name = "listedSituation")
	private String listedSituation;//上市情况
	@Column(name = "FinancingSituation")
	private String FinancingSituation;//融资情况
	@Column(name = "businessScope")
	private String businessScope;//经营范围
	@Column(name = "businessStatus")
	private String businessStatus;//经营状态
	@Column(name = "bossName")
	private String bossName;//法人名称
	@Column(name = "creditScore")
	private String creditScore;//信用评分

	public Company(String id, String name, String area, String registerMoney, String size, String listedSituation, String financingSituation, String businessScope, String businessStatus, String bossName, String creditScore) {
		this.id = id;
		this.name = name;
		this.area = area;
		this.registerMoney = registerMoney;
		this.size = size;
		this.listedSituation = listedSituation;
		FinancingSituation = financingSituation;
		this.businessScope = businessScope;
		this.businessStatus = businessStatus;
		this.bossName = bossName;
		this.creditScore = creditScore;
	}

	public Company() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getRegisterMoney() {
		return registerMoney;
	}

	public void setRegisterMoney(String registerMoney) {
		this.registerMoney = registerMoney;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getListedSituation() {
		return listedSituation;
	}

	public void setListedSituation(String listedSituation) {
		this.listedSituation = listedSituation;
	}

	public String getFinancingSituation() {
		return FinancingSituation;
	}

	public void setFinancingSituation(String financingSituation) {
		FinancingSituation = financingSituation;
	}

	public String getBusinessScope() {
		return businessScope;
	}

	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	public String getBusinessStatus() {
		return businessStatus;
	}

	public void setBusinessStatus(String businessStatus) {
		this.businessStatus = businessStatus;
	}

	public String getBossName() {
		return bossName;
	}

	public void setBossName(String bossName) {
		this.bossName = bossName;
	}

	public String getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(String creditScore) {
		this.creditScore = creditScore;
	}
}
