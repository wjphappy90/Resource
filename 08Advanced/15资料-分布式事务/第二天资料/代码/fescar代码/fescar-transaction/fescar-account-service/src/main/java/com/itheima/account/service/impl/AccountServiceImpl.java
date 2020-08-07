package com.itheima.account.service.impl;

import com.itheima.mapper.AccountMapper;
import com.itheima.model.Account;
import com.itheima.service.AccountService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/***
 *
 *
 ****/
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    /***
     * 修改账户余额
     * @param account
     * @return
     */
    @Override
    public int update(Account account){
        return accountMapper.update(account);
    }

}
