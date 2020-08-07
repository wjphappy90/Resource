package cn.itcast.demo1;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Demo1 {

	/**
	 * 单实例链接redis数据库
	 */
	@Test
	public void run1(){
		Jedis jedis = new Jedis("192.168.236.137", 6379);
//		jedis.set("name", "张三");
		System.out.println(jedis.get("name"));
	}
	
	
	/**
	 * Jedis连接池
	 */
	@Test
	public void run2(){
		//1、设置连接池的配置对象
		JedisPoolConfig config = new JedisPoolConfig();
		//设置池中最大连接数【可选】
		config.setMaxTotal(50);
		//设置空闲时池中保有的最大连接数【可选】
		config.setMaxIdle(10);
		//2、设置连接池对象
		JedisPool pool = new JedisPool(config,"192.168.236.137", 6379);
		//3、从池中获取链接对象
		Jedis jedis = pool.getResource();
		System.out.println(jedis.get("name"));
		//4、连接归还池中
		jedis.close();
	}
}
