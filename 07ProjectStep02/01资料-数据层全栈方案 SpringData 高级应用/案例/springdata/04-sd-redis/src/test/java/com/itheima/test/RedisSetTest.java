package com.itheima.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-redis.xml")
public class RedisSetTest {

    @Autowired
    private RedisTemplate redisTemplate;

    SetOperations<String, String> operations = null;

    @Before
    public void init() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        operations = redisTemplate.opsForSet();
    }

    //增加
    @Test
    public void testAdd() {
        operations.add("students","zhangsan","lisi","wangwu","zhangsan");
    }

    //查询
    @Test
    public void testFind() {
        //查询所有元素
/*        Set<String> students = operations.members("students");
        for (String student : students) {
            System.out.println(student);
        }*/

        //随机获取一个元素
/*        String student = operations.randomMember("students");
        System.out.println(student);*/

        //随机多个元素[可能会重复]
        List<String> stus = operations.randomMembers("students", 2);
        for (String stu : stus) {
            System.out.println(stu);
        }

    }

    //删除
    @Test
    public void testRemove() {
        //移除元素,并返回移除成功个数
        Long count = operations.remove("students", "zhangsan", "wangwu","sunliu");
        System.out.println(count);

        //随机移除指定集合中的多少个元素
        List<String> students = operations.pop("students", 2);
        for (String student : students) {
            System.out.println(student);
        }
    }

    //多集合操作
    @Test
    public void testMoreSet(){
        operations.add("names1", "zhangsan", "li", "wangwu");
        operations.add("names2", "zhangsan", "li", "zhaoliu");

        //取交集
/*        Set<String> sets1 = operations.intersect("names1", "names2");
        for (String s : sets1) {
            System.out.println(s);
        }*/

        //取并集
/*        Set<String> sets2 = operations.union("names1", "names2");
        for (String s : sets2) {
            System.out.println(s);
        }*/

        //取差集[第一个集合中存在,但是在第二个集合中不存在的元素]
        Set<String> sets3 = operations.difference("names2", "names1");
        for (String s : sets3) {
            System.out.println(s);
        }
    }



}
