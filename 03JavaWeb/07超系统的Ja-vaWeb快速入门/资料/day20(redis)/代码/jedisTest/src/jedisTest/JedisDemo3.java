package jedisTest;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.Jedis;

//list操作
public class JedisDemo3 {
	Jedis jedis;

	@Before
	public void createJedis() {
		jedis = new Jedis("192.168.19.128");
		// 设置密码
		jedis.auth("admin");
	}

	// 演示lpush lrange
	@Test
	public void test1() {
		jedis.lpush("names", "tom", "james", "张三", "李四");
		List<String> names = jedis.lrange("names", 0, -1);
		System.out.println(names);
	}

	// lset
	@Test
	public void test2() {
		// jedis.lset("names", 1, "王五");
		// List<String> names = jedis.lrange("names", 0, -1);
		// System.out.println(names);

		String value = jedis.lindex("names", 1);
		System.out.println(value);
	}

	// linsert
	@Test
	public void test3() {
		jedis.linsert("names", LIST_POSITION.BEFORE, "james", "fox");

		List<String> names = jedis.lrange("names", 0, -1);
		System.out.println(names);
	}
	
	// lrem
	@Test
	public void test4(){
		jedis.lrem("names", 1, "tom");
		List<String> names = jedis.lrange("names", 0, -1);
		System.out.println(names);
		
		
	}

}
