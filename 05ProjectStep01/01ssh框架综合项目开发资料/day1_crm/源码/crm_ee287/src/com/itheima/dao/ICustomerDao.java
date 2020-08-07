package com.itheima.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.domain.Customer;

/**
 * 客户的持久层接口
 * @author zhy
 *
 */
public interface ICustomerDao {
	
	/**
	 * 查询客户列表
	 * @param dCriteria
	 * @return
	 */
	List<Customer> findAll(DetachedCriteria dCriteria);

	/**
	 * 保存客户
	 * @param customer
	 */
	void save(Customer customer);

}
