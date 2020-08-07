package com.itheima.test;

import com.itheima.domain.Article;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-redis.xml")
public class RedisHashTest {

    @Autowired
    private RedisTemplate redisTemplate;

    HashOperations<String, String, Article> operations = null;

    @Before
    public void init() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());

        operations = redisTemplate.opsForHash();
    }

    //保存
    @Test
    public void testPut() {
        Article article = new Article();
        article.setTitle("黑马");
        article.setAuthor("黑马程序员");
        article.setCreateTime(new Date());

        operations.put("article", "3", article);
    }


    //获取
    @Test
    public void testGet() {
        //判断hashkey是否存在
        Boolean flag = operations.hasKey("article", "3");
        System.out.println(flag);

        //根据key和hashkay获取操作
        Article article = operations.get("article", "2");
        System.out.println(article);


        //根据key获取所有的hashkey
        Set<String> set = operations.keys("article");
        for (String s : set) {
            System.out.println(s);
        }

        List<Article> articles = operations.values("article");
        for (Article art : articles) {
            System.out.println(art);
        }

        Map<String, Article> map = operations.entries("article");
        for (Map.Entry<String, Article> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    //删除
    @Test
    public void testDelete() {
        //当hash中的数据全部被删除后,整个hash就没了
        operations.delete("article", "2", "3");
    }
}
