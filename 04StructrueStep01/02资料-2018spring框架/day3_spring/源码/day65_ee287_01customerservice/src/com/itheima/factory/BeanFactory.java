package com.itheima.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.itheima.service.ICustomerService;
import com.itheima.service.impl.CustomerServiceImpl;
import com.itheima.utils.TransactionManager;

/**
 * 用于生成bean对象
 * @author zhy
 *
 */
public class BeanFactory {
	
	public static ICustomerService getCustomerService(){
		final ICustomerService cs = new CustomerServiceImpl();
		//创建业务层的代理对象
		ICustomerService proxyCs = (ICustomerService) Proxy.newProxyInstance(cs.getClass().getClassLoader(), 
				cs.getClass().getInterfaces(), 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						if("test".equals(method.getName())){
							return method.invoke(cs, args);
						}
						try{
							//开启事务
							TransactionManager.beginTransaction();
							//执行操作
							Object rtValue = method.invoke(cs, args);
							//提交事务
							TransactionManager.commit();
							//返回结果
							return rtValue;
						}catch(Exception e){
							//回滚事务
							TransactionManager.rollback();
							//处理异常
							throw new RuntimeException(e);
						}finally{
							//关闭资源
							//由于我们把session绑定到线程上了，hibernate就帮我们关闭了
						}
					}
				});
		return proxyCs;
	}
}
