package com.itheima.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
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
@ParentPackage("struts-default")
@Namespace("/customer")
@Results({
	@Result(name="addUICustomer",type="dispatcher",location="/jsp/customer/add.jsp"),
	@Result(name="findAllCustomer",type="dispatcher",location="/jsp/customer/list.jsp"),
	@Result(name="listCustomer",type="redirectAction",location="findAllCustomer")
})
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private Customer customer = new Customer();
	private List<Customer> customers;
	
	@Resource(name="customerService")
	private ICustomerService customerService;
	
	public CustomerAction(){
		System.out.println(this);
	}

	
	@Override
	public Customer getModel() {
		return customer;
	}

	
	@Action("addCustomer")
	public String addCustomer(){
		customerService.saveCustomer(customer);
		return "listCustomer";
	}
	
	/**
	 * 查询所有客户
	 * @return
	 */
	@Action("findAllCustomer")
	public String findAllCustomer(){
		//调用业务层查询客户列表
		customers = customerService.findAllCustomer();
		return "findAllCustomer";
	}
	
	/**
	 * 获取添加客户页面
	 * @return
	 */
	@Action("addUICustomer")
	public String addUICustomer(){
		return "addUICustomer";
	}


	
	//------getters and setters-----------------
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
}
