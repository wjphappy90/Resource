package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.jdbc.JdbcTemplate;
import com.itheima.jdbc.handler.impl.BeanHandler;
import com.itheima.jdbc.handler.impl.BeanListHandler;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testJdbcTemplate(){
        System.out.println(jdbcTemplate);
    }

    @Test
    public void testSave(){
        jdbcTemplate.update("insert into account(name,money)values(?,?)","MyJdbcTemplate",6789d);
    }

    @Test
    public void testUpdate(){
        jdbcTemplate.update("update account set name=?,money=? where id=?","MyJdbcTemplate",23456d,5);
    }

    @Test
    public void testDelete(){
        jdbcTemplate.update("delete from account where id = ? ",5);
    }

    @Test
    public void testFindOne(){
        Account account =  (Account)jdbcTemplate.query("select * from account where id = ?",new BeanHandler<Account>(Account.class),1);
        System.out.println(account);
    }

    @Test
    public void testFindAll(){
        List<Account> accountList = (List<Account>)jdbcTemplate.query("select * from account where money > ?",new BeanListHandler<Account>(Account.class),999d);
        for(Account account : accountList){
            System.out.println(account);
        }
    }
}
