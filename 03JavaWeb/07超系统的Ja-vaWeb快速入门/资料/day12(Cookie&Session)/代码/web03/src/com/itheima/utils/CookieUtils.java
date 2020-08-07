package com.itheima.utils;

import javax.servlet.http.Cookie;

/**
 * 查找指定名称Cookie的工具类
 * @author jt
 *
 */
public class CookieUtils {

	public static Cookie findCookie(Cookie[] cookies,String name){
		if(cookies == null){
			// 浏览器没有携带任何的Cookie
			return null;
		}else{
			for (Cookie cookie : cookies) {
				// 判断数组中的每个cookie的名称与给定名称是否一致
				if(name.equals(cookie.getName())){
					// 直接返回：
					return cookie;
				}
			}
			// 浏览器带有Cookie过来了，但是没有指定名称的那个Cookie
			return null;
		}
	}
}
