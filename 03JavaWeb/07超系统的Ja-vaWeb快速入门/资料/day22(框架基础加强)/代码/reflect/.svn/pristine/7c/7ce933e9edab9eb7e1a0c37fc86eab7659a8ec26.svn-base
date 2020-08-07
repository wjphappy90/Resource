package com.itheima.reflect;

import java.lang.reflect.Field;

import org.junit.Test;

public class Reflect_FieldTest {

	// 获取username属性
	@Test
	public void test1() throws NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException {
		// 1.获取User类的Class
		Class clazz = User.class;

		// 根据clazz获取构造方法，在初始化创建一个对象
		Object user = clazz.newInstance(); // 它底层就是使用class类的默认无参数构造来实例化

		// 2.获取属性
		// Field field_username = clazz.getField("username"); //获取public属性
		Field field_username = clazz.getDeclaredField("username"); // 获取非public属性

		// 取消检查
		field_username.setAccessible(true);

		System.out.println(field_username);

		// 3.进行赋值操作
		field_username.set(user, "tom"); // User user=new User();
											// user.username="tom"
		// 4.进行取值操作

		Object returnvalue = field_username.get(user); // user.username;

		System.out.println(returnvalue);
	}

}
