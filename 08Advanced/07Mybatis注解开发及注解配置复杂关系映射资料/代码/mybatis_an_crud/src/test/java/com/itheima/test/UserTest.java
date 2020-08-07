package com.itheima.test;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
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
     * 查询所有用户测试方法
     */
    @Test
    public void findAll() throws Exception {
        //通过SqlSessionFactory工厂来生产SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //使用SqlSession对象来生成接口代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //调用代理对象中的方法
        List<User> list = userDao.findAll();
        //处理结果集
        for (User user : list) {
            System.out.println(user.getUsername());
        }
        //关闭资源
        sqlSession.close();
    }

    /**
     * 添加用户测试方法
     */
    @Test
    public void saveUser(){
        //通过SqlSessionFactory工厂来生产SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //使用SqlSession对象来生成接口代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //创建要保存的用户对象
        User user = new User();
        user.setUsername("小明");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("黑马程序员");
        //调用代理对象中的方法
        userDao.saveUser(user);
        //提交事务
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }

    /**
     * 修改用户测试方法
     */
    @Test
    public void updateUser(){
        //通过SqlSessionFactory工厂来生产SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //使用SqlSession对象来生成接口代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //创建要修改的用户对象
        User user = new User();
        user.setId(49);
        user.setUsername("小刚");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("黑马程序员");
        //调用代理对象中的方法
        userDao.updateUser(user);
        //提交事务
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }

    /**
     * 删除用户测试方法
     */
    @Test
    public void deleteUser(){
        //通过SqlSessionFactory工厂来生产SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //使用SqlSession对象来生成接口代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //调用代理对象中的方法
        userDao.deleteById(49);
        //提交事务
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }

}
