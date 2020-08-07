package com.itheima.gjp.app;

import com.itheima.gjp.controller.MainFrameContrller;

/*
 * 整个项目的起始入口
 */
public class MainApp {
	public static void main(String[] args) {
		//开启主窗体，创建他的子类对象
		new MainFrameContrller().setVisible(true);
	}
}
