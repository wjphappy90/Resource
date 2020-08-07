package com.itheima.dao;

import com.itheima.domain.Account;

/**
 * 账户的持久层接口
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public interface AccountDao {

    /**
     * 更新账户
     * @param account
     */
    void update(Account account);

    /**
     * 根据名称查询账户
     * @param name
     * @return
     */
    Account findByName(String name);
}
