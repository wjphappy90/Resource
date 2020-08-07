package com.itheima;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

public class JedisTest {
    @Test
    public void testJedis(){
        //1.连接redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //2.操作redis
//        jedis.set("name","itheima");
        String name = jedis.get("name");
        System.out.println(name);
        //3.关闭连接
        jedis.close();
    }

    @Test
    public void testList(){
        //1.连接redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //2.操作redis
        jedis.lpush("list1","a","b","c");
        jedis.rpush("list1","x");

        List<String> list1 = jedis.lrange("list1", 0, -1);
        for(String s : list1){
            System.out.println(s);
        }

        System.out.println(jedis.llen("list1"));

        System.out.println();
        //3.关闭连接
        jedis.close();
    }

    @Test
    public void testHash(){
        //1.连接redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //2.操作redis

        jedis.hset("hash1","a1","b1");
        jedis.hset("hash1","a2","a2");
        jedis.hset("hash1","a3","b3");

        Map<String, String> hash1 = jedis.hgetAll("hash1");

        System.out.println(hash1);

        System.out.println(jedis.hlen("hash1"));

        System.out.println();
        //3.关闭连接
        jedis.close();
    }

}
