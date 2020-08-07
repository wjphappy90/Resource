package com.itheima.cglib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 模拟一个剧组
 * @author zhy
 *
 */
public class Client {

	public static void main(String[] args) {
		final Actor actor = new Actor();
//		actor.basicAct(100f);
//		actor.dangerAct(500f);
		/**
		 * 动态代理：
		 * 	作用：不改变源码的基础上，对已有方法增强。（它是AOP思想的实现技术）
		 * 	分类：
		 *		基于接口的动态代理：
		 *		基于子类的动态代理：
		 *			要求：被代理类不能是最终类。不能被final修饰
		 *			提供者：第三方CGLib
		 *			涉及的类：Enhancer
		 *			创建代理对象的方法：create(Class,Callback);
		 *			参数的含义：
		 *				Class：被代理对象的字节码
		 *				Callback：如何代理。它和InvocationHandler的作用是一样的。它也是一个接口，我们一般使用该接口的子接口MethodInterceptor
		 *						 在使用时我们也是创建该接口的匿名内部类。
		 *
		 */
		Actor cglibActor = (Actor)Enhancer.create(actor.getClass(), new MethodInterceptor() {
			/**
			 * 执行被代理对象的任何方法，都会经过该方法。它和基于接口动态代理的invoke方法的作用是一模一样的。
			 * 方法的参数;
			 * 	  前面三个和invoke方法的参数含义和作用都一样。
			 * 	 MethodProxy methodProxy：当前执行方法的代理对象。一般不用
			 */
			@Override
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
				Object rtValue = null;
				//1.取出执行方法中的参数：给的多少钱
				Float money = (Float)args[0];
				//2.判断当前执行的是什么方法
				if("basicAct".equals(method.getName())){
					//基本演出
					if(money > 10000){
						//执行方法（开始表演）
						rtValue = method.invoke(actor, money/2);
					}
				}
				if("dangerAct".equals(method.getName())){
					//危险演出
					if(money > 50000){
						//执行方法
						rtValue = method.invoke(actor, money/2);
					}
				}
				return rtValue;
			}
		});
		cglibActor.basicAct(50000);
		cglibActor.dangerAct(100000);
	}

}
