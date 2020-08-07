package com.itheima.mapper;

import com.itheima.model.Account;
import org.apache.ibatis.annotations.Update;

/***
 *
 *
 ****/
public interface AccountMapper {

    /****
     * 修改账户余额
     * @param account
     * @return
     */
    @Update("update account set money=money-#{money} where usernumber=#{usernumber}")
    int update(Account account);
}
