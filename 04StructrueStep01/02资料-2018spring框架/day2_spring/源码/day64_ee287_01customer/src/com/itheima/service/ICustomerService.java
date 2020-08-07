package com.itheima.service;

import java.util.List;

import com.itheima.domain.Customer;

/**
 * 客户的业务层接口
 * @author zhy
 *
 */
public interface ICustomerService {
	
	/**
	 * 查询所有客户
	 * @return
	 */
	List<Customer> findAllCustomer();
	
	/**
	 * 保存客户
	 * @param customer
	 */
	void saveCustomer(Customer customer);
	
	/**
	 * 更新客户
	 * @param customer
	 */
	void updateCustomer(Customer customer);
	
	/**
	 * 根据id删除客户
	 * @param custId
	 */
	void deleteCustomer(Long custId);
	
	/**
	 * 根据id查询客户
	 * @param custId
	 * @return
	 */
	Customer findCustomerById(Long custId);
}
