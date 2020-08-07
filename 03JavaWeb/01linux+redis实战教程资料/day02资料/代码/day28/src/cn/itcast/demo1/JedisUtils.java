package cn.itcast.demo1;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {
	//1、定义一个连接池对象
	private final static JedisPool POOL;
	
	static{
		//初始化操作
		//1、设置连接池的配置对象
		JedisPoolConfig config = new JedisPoolConfig();
		//设置池中最大连接数【可选】
		config.setMaxTotal(50);
		//设置空闲时池中保有的最大连接数【可选】
		config.setMaxIdle(10);
		//2、设置连接池对象
		POOL= new JedisPool(config,"192.168.236.137", 6379);
	}
	/**
	 * 从池中获取链接
	 */
	public static Jedis getJedis(){
		return POOL.getResource();
	}
}
