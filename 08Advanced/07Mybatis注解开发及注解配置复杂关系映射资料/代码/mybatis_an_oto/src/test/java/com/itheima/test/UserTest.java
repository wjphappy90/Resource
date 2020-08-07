package com.itheima.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.InputStream;

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

}
