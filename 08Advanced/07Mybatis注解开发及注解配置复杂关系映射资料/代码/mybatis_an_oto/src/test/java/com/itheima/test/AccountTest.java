package com.itheima.test;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AccountTest {

    /**
     * 提供全局SqlSessionFactory工厂私有属性
     */
    private SqlSessionFactory sqlSessionFactory;
    /**
     * 给SqlSessionFactory工厂赋值
     */
    @Before
    public void init() throws Exception{
        //得到主配置文件流信息
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取SqlSessionFactory工厂对象
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    /**
     * 测试查询所有账户以及账户所属用户信息
     */
    @Test
    public  void  findAccountWithUser(){
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //通过SqlSession对象来生成接口代理对象
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        //调用代理对象的方法
        List<Account> list = accountDao.findAccountWithUser();
        //打印结果
        for (Account account : list) {
            System.out.println(account.getMoney());
            //获得到账户所属用户
            User user = account.getUser();
            System.out.println(user.getUsername());
            System.out.println();
        }

    }

}
