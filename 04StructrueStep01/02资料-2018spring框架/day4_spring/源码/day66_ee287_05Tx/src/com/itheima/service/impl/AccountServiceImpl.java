package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;

/**
 * 账户的业务层实现类
 * @author zhy
 *
 */
public class AccountServiceImpl implements IAccountService {

	private IAccountDao accountDao;
	
	public void setAccountDao(IAccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public Account findAccountById(Integer accountId) {
		return accountDao.findAccountById(accountId);
	}

	@Override
	public void transfer(String sourceName, String targetName, Float money) {
		//1.根据名称查询账户信息
		Account source = accountDao.findAccountByName(sourceName);
		Account target = accountDao.findAccountByName(targetName);
		//2.转出账户减钱，转入账户加钱
		source.setMoney(source.getMoney()-money);
		target.setMoney(target.getMoney()+money);
		//3.更新账户信息
		accountDao.updateAccount(source);
		int i=1/0;
		accountDao.updateAccount(target);
	}

}
