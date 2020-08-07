package com.itheima.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-redis.xml")
public class RedisListTest {

    @Autowired
    private RedisTemplate redisTemplate;

    ListOperations<String, String> operations = null;

    @Before
    public void init() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        operations = redisTemplate.opsForList();
    }

    //增加
    @Test
    public void testAdd() {
        //从左边添加一个元素
        operations.leftPush("students", "zhangsan");
        //从左边添加多个元素
        operations.leftPushAll("students", "lisi", "wangwu", "zhaoliu");


        //从右边添加一个元素
        operations.rightPush("students", "zhangsan1");
        //从右边添加多个元素
        operations.rightPushAll("students", "lisi", "wangwu", "zhaoliu");
    }

    //查询
    @Test
    public void testFind() {
        //根据key和索引进行查询
        //0和正数代表从左边开始    0  1  2
        //负数代表从右边开始       -1   -2  -3
        String student = operations.index("students", 1);
        System.out.println(student);

        String student1 = operations.index("students", -2);
        System.out.println(student1);

        //范围查询
        //根据key  [start,end]  包括首尾
        List<String> students = operations.range("students", 0, 2);
        for (String s : students) {
            System.out.println(s);
        }
    }

    //删除
    @Test
    public void testRemove(){
        //从左边删除第一个元素
        //String s = operations.leftPop("students");

        //从右边删除第一个元素
        //operations.rightPop("students");


        // count > 0：删除左边起第几个等于指定值的元素
        // count < 0：删除右边起第几个等于指定值的元素
        // count = 0：删除所有等于value的元素。
        //删除左边起第二个wangwu
        operations.remove("students",2,"wangwu");
    }


}
