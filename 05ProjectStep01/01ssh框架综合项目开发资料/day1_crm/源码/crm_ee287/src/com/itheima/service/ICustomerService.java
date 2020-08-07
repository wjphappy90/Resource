package com.itheima.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.domain.Customer;

/**
 * 客户的业务层接口
 * @author zhy
 *
 */
public interface ICustomerService {
	
	/**
	 * 查询客户列表
	 * @param dCriteria
	 * @return
	 */
	List<Customer> findAllCustomer(DetachedCriteria dCriteria);
	
	/**
	 * 保存客户
	 * @param customer
	 */
	void saveCustomer(Customer customer);
}
