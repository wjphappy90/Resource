package com.itheima.listener.weblistener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 监听ServletRequest对象的创建和销毁的监听器
 * @author jt
 *
 */
public class MyServletRequestListener implements ServletRequestListener{
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("ServletRequest对象被创建了...");
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("ServletRequest对象被销毁了...");
	}

}
