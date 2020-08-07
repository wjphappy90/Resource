package com.itheima.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-redis.xml")
public class RedisStringTest {

    @Autowired
    private RedisTemplate redisTemplate;

    ValueOperations<String, String> operations = null;

    @Before
    public void init() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        operations = redisTemplate.opsForValue();
    }


    @Test
    public void testSet() {
        //向数据库中保存name--heima
        //operations.set("name","heima");

        //相关数据库保存name1--heima1  有效时间为10s
        //operations.set("name1", "heima1", 10, TimeUnit.SECONDS);

        //替换 heima    --->   heXXa   offset 索引位置是从0开始
        //operations.set("name", "XX", 2);

        //当key不存在的时候,执行保存操作;当key存在的时候,什么都不做
        //operations.setIfAbsent("name1","heima");

        //批量保存
//        Map map = new HashMap();
//        map.put("name2", "heima2");
//        map.put("name3", "heima3");
//        map.put("name4", "heima4");
//
//        operations.multiSet(map);


        //追加 当key存在时,会执行追加操作;当key不存在时,会执行保存操作
        operations.append("name5", "Heima");

    }

    @Test
    public void testGet() {
        //根据key获取value
/*        String value = operations.get("name");
        System.out.println(value);//heXXaHeima*/

        //首先根据key获取value,然后再根据value进行截取,从start位置截取到end位置[包含start和end]
/*        String value2 = operations.get("name", 5, 7);
        System.out.println(value2);//heXXaHeima-->Hei*/

        //批量获取
//        List<String> keys = new ArrayList<>();
//        keys.add("name2");
//        keys.add("name3");
//        keys.add("name4");
//        List<String> values = operations.multiGet(keys);
//        for (String s : values) {
//            System.out.println(s);
//        }

        //根据key获取value的长度
        Long size = operations.size("name");
        System.out.println(size);

    }

    //自增
    @Test
    public void testIncrement() {
        operations.set("age", "18");
        operations.increment("age");//自增1--->19
        System.out.println(operations.get("age"));
        operations.increment("age", 5);//自增5
        System.out.println(operations.get("age"));//---->24

        //自减
        //operations.decrement("age")

    }

    //删除
    @Test
    public void testDelete() {
        //单个删除
        redisTemplate.delete("name");

        List<String> keys = new ArrayList<>();
        keys.add("name2");
        keys.add("name3");
        keys.add("name4");

        //批量删除
        redisTemplate.delete(keys);
    }


}
