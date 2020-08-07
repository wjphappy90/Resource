package com.itheima.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.itheima.domain.Customer;
import com.itheima.service.ICustomerService;
import com.itheima.service.impl.CustomerServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 客户的动作类
 * @author zhy
 *
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	
	private ICustomerService customerService = new CustomerServiceImpl();
	
	private Customer customer = new Customer();
	
	private List<Customer> customers;
	@Override
	public Customer getModel() {
		return customer;
	}
	
	/**
	 * 删除客户
	 * @return
	 */
	public String deleteCustomer(){
//		System.out.println(customer);
		customerService.deleteCustomer(customer);
		return "deleteCustomer";
	}
	
	/**
	 * 添加客户
	 * @return
	 */
	public String addCustomer(){
		customerService.saveCustomer(customer);
		return "addCustomer";
	}
	
	/**
	 * 获取添加客户页面
	 * @return
	 */
	public String addUICustomer(){
		return "addUICustomer";
	}
	
	/**
	 * 查询所有客户
	 * @return
	 */
	public String findAllCustomer(){
		//1.调用service查询客户
		customers = customerService.findAllCustomer();
		//2.返回
		return "findAllCustomer";
	}


	
	//------getters and setters--------------
	
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

}
