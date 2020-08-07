package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.CstCustomer;

/**
 * 客户持久层的接口
 * @author zhy
 *
 */
public interface ICustomerDao {
		
	/**
	 * 查询所有客户
	 * @return
	 */
	List<CstCustomer> findAllCustomer();
}
