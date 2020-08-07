package com.itheima.factory;

import com.itheima.service.ICustomerService;
import com.itheima.service.impl.CustomerServiceImpl;

/**
 * 模拟一个实例工厂
 * @author zhy
 *
 */
public class InstanceFactory {

	public ICustomerService getCustomerService(){
		return new CustomerServiceImpl();
	}
}
