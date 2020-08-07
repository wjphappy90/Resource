package com.itheima.service;

/**
 * 模拟一个客户的业务层接口
 * @author zhy
 *
 */
public interface ICustomerService {
	
	/**
	 * 保存客户
	 */
	void saveCustomer();
		
	/**
	 * 更新客户
	 * @param i
	 */
	void updateCustomer(int i);
	
	/**
	 * 删除客户
	 * @return
	 */
	int deleteCustomer();
}
