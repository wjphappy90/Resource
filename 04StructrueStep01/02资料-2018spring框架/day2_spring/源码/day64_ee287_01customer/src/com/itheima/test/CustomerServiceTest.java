package com.itheima.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.itheima.domain.Customer;
import com.itheima.service.ICustomerService;
import com.itheima.service.impl.CustomerServiceImpl;
/**
 * 测试客户的业务层
 * @author zhy
 *
 */
public class CustomerServiceTest {

	@Test
	public void testFindAllCustomer() {
		ICustomerService cs = new CustomerServiceImpl();
		List<Customer> list = cs.findAllCustomer();
		for(Customer c : list){
			System.out.println(c);
		}
	}

	@Test
	public void testSaveCustomer() {
		ICustomerService cs = new CustomerServiceImpl();
		Customer c = new Customer();
		c.setCust_name("dbutils customer");
		cs.saveCustomer(c);
	}

	@Test
	public void testUpdateCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindCustomerById() {
		fail("Not yet implemented");
	}

}
