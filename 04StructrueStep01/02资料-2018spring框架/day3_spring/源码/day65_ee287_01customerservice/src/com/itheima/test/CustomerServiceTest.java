package com.itheima.test;

import java.util.List;

import com.itheima.factory.BeanFactory;
import com.itheima.service.ICustomerService;
import com.itheima.service.impl.CustomerServiceImpl_OLD;

/**
 * 测试客户的业务层
 * @author zhy
 *
 */
public class CustomerServiceTest {

	public static void main(String[] args) {
		ICustomerService cs = BeanFactory.getCustomerService();
		List list = cs.findAllCustomer();
		for(Object o : list){
			System.out.println(o);
		}
	}

}
