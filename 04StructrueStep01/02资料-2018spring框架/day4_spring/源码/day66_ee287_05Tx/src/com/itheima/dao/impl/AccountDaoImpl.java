package com.itheima.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
/**
 * 账户的业务层实现类
 * @author zhy
 *
 */
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

	@Override
	public Account findAccountById(Integer accountId) {
		List<Account> list = getJdbcTemplate().query("select * from account where id = ? ", new BeanPropertyRowMapper<Account>(Account.class),accountId);
		return list.isEmpty()?null:list.get(0);
	}

	@Override
	public Account findAccountByName(String name) {
		List<Account> list = getJdbcTemplate().query("select * from account where name = ? ", new BeanPropertyRowMapper<Account>(Account.class),name);
		if(list.isEmpty()){
			return null;//没有这个名称的账户
		}
		if(list.size()>1){
			//结果集不唯一，不符合我们的约定
			throw new RuntimeException("结果集不唯一，请检查数据");
		}
		return list.get(0);
	}

	@Override
	public void updateAccount(Account account) {
		getJdbcTemplate().update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
	}

}
