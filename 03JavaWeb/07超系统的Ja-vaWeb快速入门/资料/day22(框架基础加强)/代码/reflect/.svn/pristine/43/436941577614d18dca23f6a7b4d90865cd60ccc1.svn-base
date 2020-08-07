package com.itheima.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class Reflect_ConstructorTest {

	// 获取User类中的无参数构造
	@Test
	public void test1() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		// 1.得到User的Class
		Class clazz = User.class;

		// 2.通过getConstructor方法来获取User类的无参数构造
		Constructor ct = clazz.getConstructor();
		System.out.println(ct);

		// 实例化对象 User user=new User();
		Object obj = ct.newInstance();

		System.out.println(obj);
	}

	// 获取User类中的有参数构造
	@Test
	public void test2() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		// 1.得到User的Class
		Class clazz = User.class;

		// 2.获取有参数构造
		// Constructor ct=clazz.getConstructor(String.class);

		Constructor ct = clazz.getDeclaredConstructor(String.class);

		System.out.println(ct);

		// 3.实例化对象 User user=new User("tom");
		ct.setAccessible(true); // 取消检查
		Object obj = ct.newInstance("tom"); // 因为构造器是private,我们在操作时会报错
		// AccessibleObject 类是 Field、Method 和 Constructor
		// 对象的基类。它提供了将反射的对象标记为在使用时取消默认 Java 语言访问控制检查的能力。

		System.out.println(obj);
	}

	// 获取所有构造方法
	@Test
	public void test3() {
		// 1.得到User的Class
		Class clazz = User.class;

		// 2.得到所有构造方法
		Constructor[] cts = clazz.getConstructors();

		for (Constructor ct : cts) {
			System.out.println(ct);
		}
	}
}
