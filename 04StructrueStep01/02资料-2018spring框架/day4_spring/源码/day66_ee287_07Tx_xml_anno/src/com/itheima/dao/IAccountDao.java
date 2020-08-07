package com.itheima.dao;

import com.itheima.domain.Account;

/**
 * 账户的持久层接口
 * @author zhy
 *
 */
public interface IAccountDao {

	/**
	 * 根据id查询账户信息
	 * @param accountId
	 * @return
	 */
	Account findAccountById(Integer accountId);
	
	/**
	 * 根据名称查询账户信息
	 * @param name
	 * @return	要求：账户名称必须唯一，如果不唯一，应该抛异常
	 */
	Account findAccountByName(String name);
	
	/**
	 * 更新账户信息
	 * @param account
	 */
	void updateAccount(Account account);
}
