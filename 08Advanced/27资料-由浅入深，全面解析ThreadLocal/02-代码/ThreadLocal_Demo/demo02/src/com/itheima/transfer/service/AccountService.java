package com.itheima.transfer.service;

import com.itheima.transfer.dao.AccountDao;
import com.itheima.transfer.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
/*
*
*   事务的使用注意点:
*       1. service层和dao层的连接对象保持一致
*       2. 每个线程的connection对象必须前后一致, 线程隔离
*
*   常规的解决方案
*       1. 传参 : 将service层的connection对象直接传递到dao层
*       2. 加锁
*
*   常规解决方案的弊端:
*       1. 提高代码耦合度
*       2. 降低程序性能
* */
public class AccountService {
    //转账
    public boolean transfer(String outUser, String inUser, int money) {
        AccountDao ad = new AccountDao();

        Connection conn = null;
        try {
//            synchronized (AccountService.class){
                //1. 开启事务
                conn = JdbcUtils.getConnection();
                conn.setAutoCommit(false);

                // 转出
                ad.out(outUser, money);
                //算术异常: 模拟转出成功,转入失败
                int i = 1/0;
                // 转入
                ad.in(inUser, money);

                //2. 成功提交
                JdbcUtils.commitAndClose(conn);
//            }

        } catch (Exception e) {
            e.printStackTrace();
            //2. 或者失败回滚
            JdbcUtils.rollbackAndClose(conn);

            return false;
        }

        return true;
    }

}
