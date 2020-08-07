package com.itheima.web.action;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.itheima.domain.Customer;
import com.itheima.service.ICustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 客户的动作类
 * @author zhy
 *
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private Customer customer = new Customer();
	private List<Customer> customers;
	private ICustomerService customerService;
	

	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}

	@Override
	public Customer getModel() {
		return customer;
	}
//此种方式根本不能用，因为由于动作类是多例的，每次都会创建新的容器，导致容器中的bean也会创建新的。	
//	public CustomerAction(){
//		ApplicationContext ac = new  ClassPathXmlApplicationContext("bean.xml");
//		System.out.println(ac);
//		ICustomerService cs = (ICustomerService) ac.getBean("customerService");
//		this.setCustomerService(cs);
//	}

	//此种方式解决了容器多例的问题，保证了容器一个应用只有一个，但是我们的代码边臃肿了，每个action都需要这么写一下。
//	public CustomerAction(){
//		ServletContext application = ServletActionContext.getServletContext();
//		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(application);
//		System.out.println(ac);
//		ICustomerService cs = (ICustomerService) ac.getBean("customerService");
//		this.setCustomerService(cs);
//	}
	
	/**
	 * 查询所有客户
	 * @return
	 */
	public String findAllCustomer(){
		//调用业务层查询客户列表
		customers = customerService.findAllCustomer();
		return "findAllCustomer";
	}
	
	/**
	 * 获取添加客户页面
	 * @return
	 */
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
