package com.itheima.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;

/**
 * 账户的业务层实现类
 * @author zhy
 *
 */
@Service("accountService")
//@Transactional(propagation=Propagation.REQUIRED,readOnly=false)//读写型
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)//只读型
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private IAccountDao accountDao;
	

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
