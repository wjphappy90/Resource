package com.itheima.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-redis.xml")
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    //测试:向redis保存一条数据
    @Test
    public void testSave() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        //获取操作简单字符串类型数据的数据句柄
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.append("name11", " very good");
    }

    @Test
    public void testSave2() {
        //获取操作简单字符串类型数据的数据句柄
        ValueOperations operations = redisTemplate.opsForValue();
        operations.set("name3", "heima3");
    }
}
