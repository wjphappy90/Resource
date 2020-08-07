package jedisTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

//key的通用操作
public class JedisDemo7 {
	Jedis jedis;

	@Before
	public void createJedis() {
		jedis = new Jedis("192.168.19.128");
		// 设置密码
		jedis.auth("admin");

	}
	// keys patten
	@Test
	public void test1(){
		Set<String> keys = jedis.keys("*");
		System.out.println(keys);
	}
	
	// del key
	@Test
	public void test2(){
		Long del = jedis.del("user");
		System.out.println(del);
	}
	
	//关于key时间设置
	@Test
	public void test3(){
		//jedis.expire("username", 200); //设置生命周期为200秒
		jedis.persist("username");
		Long ttl = jedis.ttl("username"); //获取生命周期值
		System.out.println(ttl);
		
	}

}
