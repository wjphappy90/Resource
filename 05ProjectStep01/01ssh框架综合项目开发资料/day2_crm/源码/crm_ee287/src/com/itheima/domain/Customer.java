package com.itheima.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 客户的实体类
 * @author zhy
 *
 */
@Entity
@Table(name="cst_customer")
public class Customer implements Serializable {

	@Id
	@Column(name="cust_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long custId;
	
	@Column(name="cust_name")
	private String custName;
	
	@Column(name="cust_industry")
	private String custIndustry;

	@Column(name="cust_address")
	private String custAddress;
	
	@Column(name="cust_phone")
	private String custPhone;
	
	//多对一关系映射：多个客户可以是一个来源
	@ManyToOne(targetEntity=BaseDict.class)
	@JoinColumn(name="cust_source",referencedColumnName="dict_id")
	private BaseDict custSource;
	
	//多对一关系映射：多个客户可以是同一个级别
	@ManyToOne(targetEntity=BaseDict.class)
	@JoinColumn(name="cust_level",referencedColumnName="dict_id")
	private BaseDict custLevel;
	
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
	public String getCustIndustry() {
		return custIndustry;
	}
	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
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
	public BaseDict getCustSource() {
		return custSource;
	}
	public void setCustSource(BaseDict custSource) {
		this.custSource = custSource;
	}
	public BaseDict getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(BaseDict custLevel) {
		this.custLevel = custLevel;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custIndustry=" + custIndustry
				+ ", custAddress=" + custAddress + ", custPhone=" + custPhone + "]";
	}
}
