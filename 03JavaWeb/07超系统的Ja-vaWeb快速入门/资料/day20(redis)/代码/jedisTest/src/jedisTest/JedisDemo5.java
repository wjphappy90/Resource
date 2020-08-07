package jedisTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

//set操作
public class JedisDemo5 {
	Jedis jedis;

	@Before
	public void createJedis() {
		jedis = new Jedis("192.168.19.128");
		// 设置密码
		jedis.auth("admin");		
	}
	
	//演示sadd smembers
	@Test
	public void test1(){
		jedis.sadd("language1","java","c++","ruby","python");
		
		Set<String> smembers = jedis.smembers("language1");
		System.out.println(smembers);
	}
	
	//演示srem
	@Test
	public void test2(){
		jedis.srem("language1", "java");
		Set<String> smembers = jedis.smembers("language1");
		System.out.println(smembers);
	}
	
	//差集 sdiff
	@Test
	public void test3(){
		jedis.sadd("language1","java","c++","ruby","python");
		jedis.sadd("language2","ios","c++","c#","android");
		
		Set<String> sdiff = jedis.sdiff("language1","language2");
		System.out.println(sdiff);
	}
	
	//交集
	@Test
	public void test4(){
		jedis.sadd("language1","java","c++","ruby","python");
		jedis.sadd("language2","ios","c++","c#","android");
		Set<String> sinter = jedis.sinter("language1","language2");
		System.out.println(sinter);
	}
	
	//并集
	@Test
	public void test5(){
		jedis.sadd("language1","java","c++","ruby","python");
		jedis.sadd("language2","ios","c++","c#","android");
		Set<String> sunion = jedis.sunion("language1","language2");
		System.out.println(sunion);
	}
	
}
