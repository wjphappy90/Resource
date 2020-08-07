package com.itheima.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.domain.BaseDict;
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
	
	/**
	 * 查询所有客户来源
	 * @return
	 */
	List<BaseDict> findAllCustomerSource();
	
	/**
	 * 查询所有客户级别
	 * @return
	 */
	List<BaseDict> findAllCustomerLevel();
	
	/**
	 * 根据id删除客户
	 * @param custId
	 */
	void removeCustomer(Long custId);

	/**
	 * 根据id查询客户信息
	 * @param custId
	 * @return
	 */
	Customer findCustomerById(Long custId);
	
	/**
	 * 更新客户信息
	 * @param customer
	 */
	void updateCustomer(Customer customer);
	
	
}
