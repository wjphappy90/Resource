package com.itheima.listener.bean;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
/**
 * 监听HttpSession中Java类的绑定和解除绑定的监听器
 * @author jt
 *
 */
public class Bean1 implements HttpSessionBindingListener{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("Bean1与session绑定了...");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("Bean1与session解除绑定了...");
	}
	
}
