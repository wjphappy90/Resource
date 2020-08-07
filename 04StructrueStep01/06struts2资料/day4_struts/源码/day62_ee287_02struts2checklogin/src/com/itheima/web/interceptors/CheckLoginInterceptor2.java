package com.itheima.web.interceptors;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 检查登录拦截器
 * @author zhy
 *
 */
public class CheckLoginInterceptor2 extends MethodFilterInterceptor {

	@Override
	public String doIntercept(ActionInvocation invocation) throws Exception {
		Object obj = ServletActionContext.getRequest().getSession().getAttribute("userinfo");
		if(obj == null){
			return "login";//没登录，去登录
		}
		return invocation.invoke();//已登录，就放行
	}

}
