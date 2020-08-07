package com.itheima.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class Reflect_MethodTest {

	// 获取Method对象
	@Test
	public void test1() {

		// 1.获取User类Class
		Class clazz = User.class;

		// 2.获取Method对象
		// Method[] methods = clazz.getMethods(); //它获取所有方法，包含父中继承过来的
		Method[] methods = clazz.getDeclaredMethods(); // 它只获取本类中所拥有的方法
		for (Method m : methods) {
			System.out.println(m.getName());
		}
	}

	// 获取某一个方法
	@Test
	public void test2() throws NoSuchMethodException, SecurityException {
		// 1.获取User类Class
		Class clazz = User.class;

		// 2.获取sayHello方法
		// 参数一代表的是方法的名称
		// 参数二它是一个可变参数 Class...，其实就是一个Class[],它描述的是方法的参数Class
		Method method = clazz.getMethod("sayHello", String.class);
		System.out.println(method.getName());

	}

	// 执行方法
	@Test
	public void test3() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		User user = new User();
		String st = user.sayHello("fox");
		// System.out.println(st);

		// 1.获取sayHello方法的Method对象
		Class clazz = user.getClass();

		// 2.获取Method对象
		Method method = clazz.getMethod("sayHello", String.class);

		// 3.让方法执行
		Object invoke = method.invoke(user, "fox");

		System.out.println(invoke);
	}

	// 调用static方法
	@Test
	public void test4() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Class clazz = User.class;

		// 得到sum方法
		Method method = clazz.getMethod("sum"); // 注意sum是一个静态方法

		method.invoke(null);
	}

	// 调用参数是数组类型的方法
	@Test
	public void test5() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class clazz = User.class;

		// 得到sum方法
		Method method = clazz.getMethod("sum",Integer[].class); 
		
		//执行sum方法
		Integer[] args={1,2,3,4};
		//解决方案一:将args直接强制转换成Object在传递		
		//method.invoke(null, ((Object)args));		
		//解决方案二:在args这个数组外层在包装一层数组
		Object[] objs={args};
		method.invoke(null, objs);
		
	}

}
