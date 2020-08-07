package com.ithiema.test;

import config.SpringConfiguration;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 测试案例的执行
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class SpringBasicAnnoTest {

    @Autowired
    @Qualifier("proxyAccountService")
    private AccountService accountService;

    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("spring annotation");
        account.setMoney(11111d);
        accountService.save(account);
    }

    @Test
    public void testUpdate(){
        Account account = accountService.findById(2);
        account.setMoney(22222d);
        accountService.update(account);
    }

    @Test
    public void testDelete(){
        accountService.delete(1);
    }

    @Test
    public void testFindOne(){
        Account account = accountService.findById(2);
        System.out.println(account);
    }

    @Test
    public void testFindAll(){
        List<Account> accounts = accountService.findAll();
        for(Account account : accounts){
            System.out.println(account);
        }
    }


    @Test
    public void testTransfer(){
        accountService.transfer("aaa","bbb",100d);
    }

}
