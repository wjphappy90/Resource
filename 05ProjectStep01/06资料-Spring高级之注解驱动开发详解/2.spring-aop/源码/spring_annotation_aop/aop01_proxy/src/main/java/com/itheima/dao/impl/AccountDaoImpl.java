package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户的持久层实现
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired(required = true)
    @Qualifier("jdbcTemplate1")
    private JdbcTemplate jdbcTemplate;


    @Override
    public void save(Account account) {
        jdbcTemplate.update("insert into account(name,money)values(?,?)",account.getName(),account.getMoney());
    }

    @Override
    public void update(Account account) {
        jdbcTemplate.update("update account set name=?,money=? where id =?",account.getName(),account.getMoney(),account.getId());
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("delete from account where id = ? ",id);
    }

    @Override
    public Account findById(Integer id) {
        List<Account> accounts = jdbcTemplate.query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),id);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    @Override
    public List<Account> findAll() {
        return jdbcTemplate.query("select * from account ",new BeanPropertyRowMapper<Account>(Account.class));
    }

    @Override
    public Account findByName(String name) {
        List<Account> accounts = jdbcTemplate.query("select * from account where name = ?",new BeanPropertyRowMapper<Account>(Account.class),name);
        if(accounts.isEmpty()){
            return null;
        }
        if(accounts.size() > 1){
            throw new IllegalArgumentException("账户名不唯一");
        }
        return accounts.get(0);
    }
}
