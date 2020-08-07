package com.itheima.service;

/**
 * 账户的业务层接口
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public interface AccountService {

    /**
     * 转账
     * @param sourceName
     * @param targetName
     * @param money
     */
    void transfer(String sourceName,String targetName,Double money);
}
