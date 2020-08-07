package jedisTest;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

//string操作
public class JedisDemo2 {
	Jedis jedis;

	@Before
	public void createJedis() {
		jedis = new Jedis("192.168.19.128");
		// 设置密码
		jedis.auth("admin");
	}

	// 演示 set get
	@Test
	public void test1() {
		jedis.set("username", "tom");		
		String value = jedis.get("username");
		System.out.println(value);
	}
	
	//演示mset  mget
	@Test
	public void test2(){
		jedis.mset("password","123","age","20");
		
		List<String> values = jedis.mget("username","password","age");
		
		System.out.println(values);
	}
	
	//演示  append  setrange  getrange
	@Test
	public void test3(){
		//jedis.append("username"," is boy");
		
		//jedis.setrange("username", 7,"girl");
		System.out.println(jedis.get("username"));
		
		
		System.out.println(jedis.getrange("username", 7, -1));
	}

}
