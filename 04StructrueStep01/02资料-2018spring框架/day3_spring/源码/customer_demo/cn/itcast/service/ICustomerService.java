package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Customer;

/**
 * 客户的业务层接口
 * @author zhy
 *
 */
public interface ICustomerService {
	
	/**
	 * 保存客户
	 * @param customer
	 */
	void saveCustomer(Customer customer);
	
	/**
	 * 查询所有客户
	 * @return
	 */
	List<Customer> findAllCustomer();
	
	/**
	 * 删除客户
	 * @param customer
	 */
	void removeCustomer(Customer customer);
	
	/**
	 * 根据id查询客户
	 * @param custId
	 * @return
	 */
	Customer findCustomerById(Long custId);
	
	/**
	 * 修改客户
	 * @param customer
	 */
	void updateCustomer(Customer customer);
	
	//void test();
}
