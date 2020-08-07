package com.itheima.web.listener;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.itheima.service.IProductExpirationService;
import com.itheima.service.impl.ProductExpirationServiceImpl;

//监听产品到期
public class ProdictExpirationListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	// ServletContext创建
	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		// 计算当天的0点
		Calendar c = Calendar.getInstance(); // 获取当前时间
		// c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH),
		// c.get(Calendar.DATE)+1, 0, 0, 0);
		c.add(Calendar.DATE, 1);
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), 0, 0, 0);

		// 当服务启动时会创建ServletContext对象。
		Timer timer = new Timer();

		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				//查询product_account表，判断购买的产品是否到期，如果到期，将收益累加到当前客户的account表的interest上。
				IProductExpirationService pes=new ProductExpirationServiceImpl();
				pes.checkProductExpiration();
				
			}
		}, c.getTime(), 24 * 60 * 60 * 1000);

	}

}
