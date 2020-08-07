package jedisTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

//hash操作
public class JedisDemo4 {
	Jedis jedis;

	@Before
	public void createJedis() {
		jedis = new Jedis("192.168.19.128");
		// 设置密码
		jedis.auth("admin");
	}

	// 演示hset hget
	@Test
	public void test1() {
		jedis.hset("user", "username", "tom");

		String value = jedis.hget("user", "username");
		System.out.println(value);
	}

	// 演示hmset hmget
	@Test
	public void test2() {
		Map<String, String> hash = new HashMap<String, String>();
		hash.put("password", "123");
		hash.put("sex", "male");
		jedis.hmset("user", hash);

		List<String> values = jedis.hmget("user", "username", "password", "sex");
		System.out.println(values);
	}
	
	//演示  hgetall hkeys  kvals
	@Test
	public void test3(){
		Map<String, String> map = jedis.hgetAll("user");
		for(String key:map.keySet()){
			System.out.println(key+"  "+map.get(key));
		}
		
		Set<String> keys = jedis.hkeys("user");
		System.out.println(keys);
		
		List<String> values = jedis.hvals("user");
		System.out.println(values);
	}
	
//	演示hdel
	@Test
	public void test4(){
		jedis.hdel("user", "username","password");
		Map<String, String> map = jedis.hgetAll("user");
		for(String key:map.keySet()){
			System.out.println(key+"  "+map.get(key));
		}
	}
}
