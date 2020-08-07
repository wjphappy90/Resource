package com.itheima.listener.onlinecount;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class OnLineCountServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 在服务器启动的时候初始化一个值为0
		// 还需要将这个值存入到ServletContext中。
		sce.getServletContext().setAttribute("count", 0);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
