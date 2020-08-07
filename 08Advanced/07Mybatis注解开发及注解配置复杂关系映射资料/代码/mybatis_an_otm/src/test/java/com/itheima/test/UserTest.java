package com.itheima.test;

import com.itheima.dao.UserDao;
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

public class UserTest {

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
     * 测试查询所有用户以及用户下账户集合
     */
    @Test
    public void  findAllUserWithAccount(){
        //先获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //生成接口代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //调用代理对象中的方法
        List<User> list = userDao.findAllUserWithAccounts();
        //打印结果
        for (User user : list) {
            System.out.println(user.getUsername());
            //获取用户下账户集合
            List<Account> accounts = user.getAccounts();
            if(accounts!=null && accounts.size()>0){
                for (Account account : accounts) {
                    System.out.println(account.getMoney());
                }
            }
        }
    }

}
