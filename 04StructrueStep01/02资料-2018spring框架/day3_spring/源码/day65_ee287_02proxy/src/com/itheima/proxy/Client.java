package com.itheima.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
		 *				要求：被代理类最少实现一个接口
		 *				提供者：JDK官方
		 *				涉及的类：Proxy
		 *			创建代理对象的方法：newProxyInstance(ClassLoader,Class[],InvocationHandler)
		 *				参数的含义：
		 *				ClassLoader：类加载器。和被代理对象使用相同的类加载器。一般都是固定写法。
		 *					Class[]：字节码数组。被代理类实现的接口。（要求代理对象和被代理对象具有相同的行为）。一般都是固定写法。
		 *		  InvocationHandler：它是一个接口，就是用于我们提供增强代码的。我们一般都是些一个该接口的实现类。实现类可以是匿名内部类。
		 *							 它的含义就是：如何代理。此处的代码只能是谁用谁提供。
		 *							策略模式：
		 *								使用要求：数据已经有了
		 *										目的明确
		 *										达成目标的过程就是策略。
		 *								在dbutils中的ResultSetHandler就是策略模式的具体应用。
		 *		基于子类的动态代理
		 *
		 */
		IActor proxyActor = (IActor) Proxy.newProxyInstance(actor.getClass().getClassLoader(), 
				actor.getClass().getInterfaces(),
				new InvocationHandler() {
					/**
					 * 执行被代理对象的任何方法都会经过该方法，该方法有拦截的功能
					 * 方法的参数
					 * 	  Object proxy：代理对象的引用。不一定每次都会有。
					 * 	  Method method：当前执行的方法 
					 * 	  Object[] args：当前执行方法所需的参数
					 * 返回值：
					 * 	  当前执行方法的返回值
					 */
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
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
		proxyActor.basicAct(20000);
		proxyActor.dangerAct(60000);
	}

}
