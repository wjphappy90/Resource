package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.CstCustomer;
import cn.itcast.domain.CstLinkMan;

/**
 * 客户管理的业务层接口
 * 
 * @author zhy
 *
 */
public interface ICustomerManagementService {

	/**
	 * 查询所有客户信息
	 * @return
	 */
	List<CstCustomer> findAllCustomer();
}
