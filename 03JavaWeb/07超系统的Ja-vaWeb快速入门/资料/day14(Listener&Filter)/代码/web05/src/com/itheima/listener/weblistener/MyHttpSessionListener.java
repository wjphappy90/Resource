package com.itheima.listener.weblistener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * 监听HttpSession的创建和销毁的监听器
 * @author jt
 *
 */
public class MyHttpSessionListener implements HttpSessionListener{

	@Override
	// 监听HttpSession的创建
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("HttpSession对象被创建了...");
	}

	@Override
	// 监听HttpSession的销毁
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("HttpSession对象被销毁了...");
	}
	
}
