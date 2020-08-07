package com.itheima.web.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * @author zhy
 *
 */
public class MyInterceptor2 extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("访问Action之前：MyInterceptor22222222222拦截了。。。。");
		String rtValue = invocation.invoke();//放行
		System.out.println("访问Action之后：MyInterceptor22222222222拦截了。。。。");
		return rtValue;
	}

}
