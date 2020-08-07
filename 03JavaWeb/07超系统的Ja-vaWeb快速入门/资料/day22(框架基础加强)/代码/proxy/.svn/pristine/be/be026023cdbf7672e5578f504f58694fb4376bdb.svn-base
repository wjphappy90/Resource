package com.itheima.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class TagertTest {

	// 直接访问目标
	@Test
	public void test1() {
		ITarget target = new Target();
		target.show();
	}

	// 通过代理来访问
	@Test
	public void test2() {

		// 1.创建目标
		ITarget target = new Target();

		// 2.创建代理
		ITarget targetProxy = new TargetProxy(target);

		// 3.通过代理来调用目标
		targetProxy.show();
	}

	// 使用jdk提供的Proxy类来完成动态代理
	@Test
	public void test3() {
		// 1.创建目标
		final ITarget target = new Target();
		
		//2.使用Proxy的newProxyInstance方法来完成代理对象创建
		ITarget targetProxy=(ITarget) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				return method.invoke(target, args);
			}
		});
		
		targetProxy.show();
		
	}
}
