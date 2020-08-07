package jedisTest;

import redis.clients.jedis.Jedis;

//快速入门
public class JedisDemo1 {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.19.128");
		//设置密码
		jedis.auth("admin");
		jedis.set("foo", "bar");
		String value = jedis.get("foo");
		System.out.println(value);
	}
}
