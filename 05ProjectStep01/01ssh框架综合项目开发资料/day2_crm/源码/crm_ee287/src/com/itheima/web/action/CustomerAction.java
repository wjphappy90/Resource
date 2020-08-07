package com.itheima.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.domain.BaseDict;
import com.itheima.domain.Customer;
import com.itheima.service.ICustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 客户的动作类
 * @author zhy
 *
 */
@Controller("customerAction")
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/customer")
@Results({
	@Result(name="addUI",type="dispatcher",location="/jsp/customer/add.jsp"),
	@Result(name="findAll",type="dispatcher",location="/jsp/customer/list.jsp"),
	@Result(name="listCustomer",type="redirectAction",location="findAllCustomer"),
	@Result(name="editUI",type="dispatcher",location="/jsp/customer/edit.jsp")
})
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private Customer customer = new Customer();
	private List<Customer> customers;
	@Resource(name="customerService")
	private ICustomerService customerService;
	
	private List<BaseDict> custSources;
	private List<BaseDict> custLevels;
	
	@Override
	public Customer getModel() {
		//System.out.println("模型驱动调用getModel方法："+customer.hashCode());
		return customer;
	}
	
	
	/**
	 * 编辑客户
	 * @return
	 */
	@Action("editCustomer")
	public String editCustomer(){
		customerService.updateCustomer(customer);
		return "listCustomer";
	}
	
	
	/**
	 * 获取编辑客户页面
	 * @return
	 */
	@Action("editUICustomer")
	public String editUICustomer(){
		//1.查询所有客户来源
		custSources = customerService.findAllCustomerSource();
		//2.查询所有客户级别
		custLevels = customerService.findAllCustomerLevel();
		//3.根据id查询要编辑的客户信息
		Customer c = customerService.findCustomerById(customer.getCustId());
		//4.把查询出来的对象压入栈顶
		ActionContext.getContext().getValueStack().push(c);
		return "editUI";
	}
	
	/**
	 * 删除客户
	 * @return
	 */
	@Action("removeCustomer")
	public String removeCustomer(){
		customerService.removeCustomer(customer.getCustId());
		return "listCustomer";
	}
	
	/**
	 * 新增客户
	 * @return
	 */
	@Action("addCustomer")
	public String addCustomer(){
		//1.保存客户
		customerService.saveCustomer(customer);
		return "listCustomer";
	}
	
	/**
	 * 查询客户列表
	 * @return
	 */
	@Action("findAllCustomer")
	public String findAllCustomer(){
		//1.定义离线对象
		DetachedCriteria dCriteria = DetachedCriteria.forClass(Customer.class);
		//2.拼装查询条件
		//判断是否输入了客户名称
		if(StringUtils.isNotBlank(customer.getCustName())){
			//模糊查询客户名称
			dCriteria.add(Restrictions.like("custName", "%"+customer.getCustName()+"%"));
		}
		//判断是否输入了客户行业
		if(StringUtils.isNotBlank(customer.getCustIndustry())){
			//模糊查询客户行业
			dCriteria.add(Restrictions.like("custIndustry", "%"+customer.getCustIndustry()+"%"));
		}
		//判断是否选择了客户级别
		if(customer.getCustLevel()!= null && StringUtils.isNotBlank(customer.getCustLevel().getDictId())){
			//精确查询客户级别
			dCriteria.add(Restrictions.eq("custLevel.dictId", customer.getCustLevel().getDictId()));
		}
		//判断是否选择了客户来源
		if(customer.getCustSource()!= null && StringUtils.isNotBlank(customer.getCustSource().getDictId())){
			//精确查询客户级别
			dCriteria.add(Restrictions.eq("custSource.dictId", customer.getCustSource().getDictId()));
		}
		
		//3.根据离线对象查询客户信息
		customers = customerService.findAllCustomer(dCriteria);
		//4.查询所有客户来源
		custSources = customerService.findAllCustomerSource();
		//5.查询所有客户级别
		custLevels = customerService.findAllCustomerLevel();
		return "findAll";
	}
	
	/**
	 * 获取添加客户页面
	 * @return
	 */
	@Action("addUICustomer")
	public String addUICustomer(){
		//1.查询所有客户来源
		custSources = customerService.findAllCustomerSource();
		//2.查询所有客户级别
		custLevels = customerService.findAllCustomerLevel();
		return "addUI";
	}

	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	public List<BaseDict> getCustSources() {
		return custSources;
	}
	public void setCustSources(List<BaseDict> custSources) {
		this.custSources = custSources;
	}
	public List<BaseDict> getCustLevels() {
		return custLevels;
	}
	public void setCustLevels(List<BaseDict> custLevels) {
		this.custLevels = custLevels;
	}	
}
