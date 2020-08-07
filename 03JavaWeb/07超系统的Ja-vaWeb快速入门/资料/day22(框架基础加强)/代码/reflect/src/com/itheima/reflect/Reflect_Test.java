package com.itheima.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class Reflect_Test {

	@Test
	public void test() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", "tom");
		map.put("age", 20);
		map.put("sex", "男");
		map.put("address", "北京");

	}

	// 通过属性对应setXxx方法来完成操作
	@Test
	public void test2() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", "tom");
		map.put("age", 20);
		map.put("sex", "男");
		map.put("address", "北京");

		// 1.得到Person类的Class
		Class clazz = Class.forName("com.itheima.reflect.Person");
		Object obj = clazz.newInstance();
		
		//2.得到Person类中的方法
		Method[] methods = clazz.getDeclaredMethods();
		
		//3.遍历map
		for(String key:map.keySet()){
			//将所有的key前面添加上set，与方法的名称不区分大小写来对比。
			String methodName="set"+key; //操作的方法
			for(Method method:methods){
				String mname=method.getName();
				if(methodName.equalsIgnoreCase(mname)){
					method.invoke(obj, map.get(key));
				}
			}
		}
		
		System.out.println(obj);
		
	}

	// 通过属性来完成操作
	@Test
	public void test1() throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", "tom");
		map.put("age", 20);
		map.put("sex", "男");
		map.put("address", "北京");

		// 1.得到Person类的Class
		Class clazz = Class.forName("com.itheima.reflect.Person");
		Object obj = clazz.newInstance();
		// 2.得到Person类的所有属性
		Field[] fds = clazz.getDeclaredFields();
		// 3.得到map中所有的key
		Set<String> keys = map.keySet();
		for (Field f : fds) {
			String field_name = (f.getName()); // 得到属性名称

			if (keys.contains(field_name)) { // map的key中包含了Person类的属性
				// 4.将key对应的value赋值给属性
				f.setAccessible(true);
				f.set(obj, map.get(field_name));
			}
		}

		System.out.println(obj);
	}
}
