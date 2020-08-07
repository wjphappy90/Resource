package com.itheima.test;

import com.itheima.domain.Account;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 测试JdbcTemplate的使用
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class SpringJdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testSave(){
        jdbcTemplate.update("insert into account(money,name)values(?,?)",6789d,"userTest");
    }

    @Test
    public void testUpdate(){
        jdbcTemplate.update("update account set name=?,money=? where id=?","testZZZ",23456d,3);
    }

    @Test
    public void testDelete(){
        jdbcTemplate.update("delete from account where id = ? ",4);
    }

    @Test
    public void testFindOne(){
//        List<Account> accounts =  jdbcTemplate.query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),1);
//        System.out.println(accounts.isEmpty()?"empty":accounts.get(0));

//        Account account = jdbcTemplate.queryForObject("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),1);
//        System.out.println(account);

        Account account = jdbcTemplate.query("select * from account where id = ?", new ResultSetExtractor<Account>() {
            @Override
            public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
                Account account1 = null;
                //1.判断结果集能往下走
                if(rs.next()){
                    account1 = new Account();
                    account1.setId(rs.getInt("id"));
                    account1.setName(rs.getString("name"));
                    account1.setMoney(rs.getDouble("money"));
                }
                return account1;
        }
        }, 1);
        System.out.println(account);
    }

    @Test
    public void testFindAll(){
        List<Account> accountList = jdbcTemplate.query("select * from account where money > ?",new BeanPropertyRowMapper<Account>(Account.class),999d);
        for(Account account : accountList){
            System.out.println(account);
        }
    }

    @Test
    public void testFindCount(){
       Integer count =  jdbcTemplate.queryForObject("select count(*) from account where money > ?",Integer.class,999d);
        System.out.println(count);
    }


    @Test
    public void testQueryForList(){
        /**
         * 得到某个特定类型的集合。类型是方法的第二个参数指定的
         */
        List<Double> list = jdbcTemplate.queryForList("select money from account where money > ?",Double.class,999d);
        for(Double money : list){
            System.out.println(money);
        }

//        List<Map<String,Object>> list = jdbcTemplate.queryForList("select * from account where money > ? ",999d);
//        for(Map<String,Object> map : list){
//            for(Map.Entry<String,Object> me : map.entrySet())
//            System.out.println(me.getKey()+","+me.getValue());
//        }
    }

    @Test
    public void testQueryForMap(){
        Map<String,Object> map = jdbcTemplate.queryForMap("select * from account where id = ?",1);
        for(Map.Entry<String,Object> me : map.entrySet()) {
            System.out.println(me.getKey()+","+me.getValue());
        }
    }


    @Test
    public void testQueryForRowSet(){
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet("select * from account where money > ?",999d);
        System.out.println(rowSet);
        while(rowSet.next()){
            String name = rowSet.getString("name");
            System.out.println(name);
        }
    }



















//    @Test
//    public void testJdbcTemplate(){
//        System.out.println(jdbcTemplate);
//    }
}
