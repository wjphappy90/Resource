package com.itheima.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//可以得到代理对象的工具类
public class ProxyBuilder implements InvocationHandler {
	// 目标对象
	private Object target;

	public ProxyBuilder(Object target) {
		this.target = target;
	}

	// 作用:创建代理对象
	public Object createProxy() {
		ClassLoader loader = target.getClass().getClassLoader();
		Class[] interfaces = target.getClass().getInterfaces();
		return Proxy.newProxyInstance(loader, interfaces, this);

	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// System.out.println(proxy);
		// System.out.println(method);
		// System.out.println(args[0]+" "+args[1]);

		// 在调用前，得到一个时间
		long l1 = System.currentTimeMillis();
		
		Object returnValue = method.invoke(target, args);// 调用目标行为

		long l2 = System.currentTimeMillis();

		System.out.println("目标行为执行时间:"+(l2 - l1));

		return returnValue;

	}
}
