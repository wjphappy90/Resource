package com.itheima.test;

import com.itheima.domain.Account;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试NamedParameterJdbcTemplate的使用
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class SpringNamedParameterJdbcTemplateTest {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Test
    public void testFind(){
        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        Account account = jdbcTemplate.queryForObject("select * from account where id = :id",map,new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(account);
    }


    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("NamedParameterJdbcTemplate");
        account.setMoney(12345d);
        BeanMap beanMap = BeanMap.create(account);
        jdbcTemplate.update("insert into account(name,money)values(:name,:money)",beanMap);
    }
}
