package com.itheima.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 客户的实体类
 * @author zhy
 * 使用的注解都是JPA规范，所以导包，都需要导入javax.persistence包下的
 */
@Entity//表明该类是一个实体类
@Table(name="cst_customer")//建立当前类和数据库表的对应关系
public class Customer implements Serializable {
	
	@Id//表明当前字段是主键
	@Column(name="cust_id")//表明对应数据库的主键字段是cust_id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//指定主键生成策略。strategy:使用JPA中提供的主键生成策略。此属性用不了。generator属性可以使用hibernate中的主键生成策略
	private Long custId;
	
	@Column(name="cust_name")
	private String custName;
	
	@Column(name="cust_source")
	private String custSource;
	
	@Column(name="cust_industry")
	private String custIndustry;
	
	@Column(name="cust_level")
	private String custLevel;
	
	@Column(name="cust_address")
	private String custAddress;
	
	@Column(name="cust_phone")
	private String custPhone;
	
	
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustIndustry() {
		return custIndustry;
	}
	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custSource=" + custSource
				+ ", custIndustry=" + custIndustry + ", custLevel=" + custLevel + ", custAddress=" + custAddress
				+ ", custPhone=" + custPhone + "]";
	}
	
	
}
