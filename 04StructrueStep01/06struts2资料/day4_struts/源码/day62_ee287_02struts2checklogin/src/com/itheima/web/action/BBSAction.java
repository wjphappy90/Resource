package com.itheima.web.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 动作类
 * @author zhy
 *
 */
public class BBSAction extends ActionSupport implements ServletRequestAware{

	private HttpServletRequest request;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	
	/**
	 * 娱乐
	 * @return
	 */
	public String demo1(){
		System.out.println(request);
		return SUCCESS;
	}

	/**
	 * 体育
	 * @return
	 */
	public String demo2(){
		System.out.println(request);
		return SUCCESS;
	}
	
	/**
	 * 军事
	 * @return
	 */
	public String demo3(){
		System.out.println(request);
		return SUCCESS;
	}

	/**
	 * 登录方法
	 * @return
	 */
	public String userLogin(){
		//往session域中存入一个登录标记
		ServletActionContext.getRequest().getSession().setAttribute("userinfo", "");
		return SUCCESS;
	}
	
}
