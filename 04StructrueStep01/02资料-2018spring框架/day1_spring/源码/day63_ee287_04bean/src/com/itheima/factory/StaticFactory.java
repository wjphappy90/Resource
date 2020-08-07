package com.itheima.factory;

import com.itheima.service.ICustomerService;
import com.itheima.service.impl.CustomerServiceImpl;

/**
 * 模拟一个静态工厂
 * @author zhy
 *
 */
public class StaticFactory {

	public static ICustomerService getCustomerService(){
		return new CustomerServiceImpl();
	}
}
