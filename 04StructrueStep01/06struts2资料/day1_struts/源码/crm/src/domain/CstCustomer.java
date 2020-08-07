package cn.itcast.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * 客户的数据模型
 * @author zhy
 *
 */
public class CstCustomer implements Serializable {

	private Long custId;
	private String custName;
	private String custSource;
	private String custIndustry;
	private String custLevel;
	private String custAddress;
	private String custPhone;
	
	//一对多关系映射：实体类中的映射
	//一的一端应该包含多的一端的一个集合对象
	private Set<CstLinkMan> linkmans = new HashSet<CstLinkMan>(0);
	
	public CstCustomer(){
		
	}
	
	
	public CstCustomer(Long custId, String custName) {
		this.custId = custId;
		this.custName = custName;
	}
	
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
	public Set<CstLinkMan> getLinkmans() {
		return linkmans;
	}
	public void setLinkmans(Set<CstLinkMan> linkmans) {
		this.linkmans = linkmans;
	}
	@Override
	public String toString() {
		return "CstCustomer [custId=" + custId + ", custName=" + custName + ", custSource=" + custSource
				+ ", custIndustry=" + custIndustry + ", custLevel=" + custLevel + ", custAddress=" + custAddress
				+ ", custPhone=" + custPhone + "]";
	}	
}
