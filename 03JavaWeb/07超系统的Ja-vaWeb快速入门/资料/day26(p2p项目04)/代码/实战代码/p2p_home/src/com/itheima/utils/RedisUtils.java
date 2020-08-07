package com.itheima.utils;

import redis.clients.jedis.Jedis;

public class RedisUtils {
	private static Jedis jedis;
	static {
		jedis = new Jedis("192.168.19.128");
		jedis.auth("admin");
	}

	// 存储
	public static void set(String key, String value) {
		jedis.set(key, value);
	}

	// 存储 并设置保存时间
	public static void set(String key, String value, int seconds) {
		jedis.setex(key, seconds, value);
	}

	// 获取
	public static String get(String key) {
		return jedis.get(key);
	}
}
