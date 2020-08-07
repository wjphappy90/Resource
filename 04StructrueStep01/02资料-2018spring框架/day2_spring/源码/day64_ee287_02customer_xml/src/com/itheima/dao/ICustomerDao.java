package com.itheima.dao;

import java.util.List;

import com.itheima.domain.Customer;
/**
 * 客户的持久层接口
 * @author zhy
 *
 */
public interface ICustomerDao {
	
	/**
	 * 查询所有客户
	 * @return
	 */
	List<Customer> findAllCustomer();
	
	/**
	 *  保存客户
	 * @param customer
	 */
	void saveCustomer(Customer customer);

	/**
	 * 更新客户
	 * @param customer
	 */
	void updateCustomer(Customer customer);
	
	/**
	 * 删除客户
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
