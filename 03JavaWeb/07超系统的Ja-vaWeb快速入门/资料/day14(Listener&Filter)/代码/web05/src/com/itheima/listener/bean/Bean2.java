package com.itheima.listener.bean;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
/**
 * 监听HttpSession中的对象的钝化和活化的监听器
 * @author jt
 *
 */
public class Bean2 implements HttpSessionActivationListener ,Serializable{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("Bean2被session钝化了...");
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("Bean2被session活化了...");
	}
	
}
