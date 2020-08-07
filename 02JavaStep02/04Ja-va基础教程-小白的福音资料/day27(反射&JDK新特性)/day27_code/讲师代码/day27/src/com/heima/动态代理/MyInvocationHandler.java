package com.heima.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
	private Object target;
	
	public MyInvocationHandler(Object target) {
		this.target = target;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("权限校验");
		method.invoke(target, args);					//执行被代理target对象的方法
		System.out.println("日志记录");
		return null;
	}

}
