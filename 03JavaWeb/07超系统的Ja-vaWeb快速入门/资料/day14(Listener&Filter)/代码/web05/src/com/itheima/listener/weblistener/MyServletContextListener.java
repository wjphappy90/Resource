package com.itheima.listener.weblistener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServletContextListener监听器
 * @author jt
 * * 事件源：ServletContext
 * * 监听器：MyServletContextListener
 * * 事件源和监听器绑定：通过配置方式绑定
 */
public class MyServletContextListener implements ServletContextListener{

	@Override
	// 监听ServletContext对象的创建
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext对象被创建了...");
	}

	@Override
	// 监听ServletContext对象的销毁
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext对象被销毁了...");
	}

}
