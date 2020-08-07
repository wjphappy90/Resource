package com.itheima.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.domain.Customer;
import com.itheima.service.ICustomerService;
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
	@Result(name="listCustomer",type="redirectAction",location="findAllCustomer")
})
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private Customer customer = new Customer();
	private List<Customer> customers;
	@Resource(name="customerService")
	private ICustomerService customerService;
	
	@Override
	public Customer getModel() {
		return customer;
	}
	
	
	/**
	 * 新增客户
	 * @return
	 */
	@Action("addCustomer")
	public String addCustomer(){
		customerService.saveCustomer(customer);
		return "listCustomer";
	}
	
	/**
	 * 查询客户列表
	 * @return
	 */
	@Action("findAllCustomer")
	public String findAllCustomer(){
		DetachedCriteria dCriteria = DetachedCriteria.forClass(Customer.class);
		customers = customerService.findAllCustomer(dCriteria);
		return "findAll";
	}
	
	/**
	 * 获取添加客户页面
	 * @return
	 */
	@Action("addUICustomer")
	public String addUICustomer(){
		return "addUI";
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	
}
