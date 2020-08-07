package com.itheima.web.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 纯注解开发中自定义拦截器步骤：
 * 第一步：编写一个普通类，实现HandlerInterceptor接口
 * 第二步：把拦截器用注解存入IOC容器
 * 第三步：注册到InterceptorRegistry中
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Component
public class MyInterceptorDemo1 implements HandlerInterceptor {

    /**
     * 拦截器的拦截方法，它是在控制器方法执行之前先执行。可以做一些前置增强
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle方法执行了11111");
        if (request.getRequestURL().toString().contains("login")) {
            return true;//登录方法直接放行
        }
        Object obj = request.getSession().getAttribute("loginName");
        if(obj == null){
            return false;//不放行
        }
        return true;//放行
    }

    /**
     * 它是拦截器的后处理方法，执行时机在控制器方法执行之后，同时结果视图执行之前。它可以对响应数据进行增强
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle方法执行了11111");
        String message = (String)modelAndView.getModelMap().get("message");
        if(!StringUtils.isEmpty(message)){
            message = message.replace("itheima","**");
            modelAndView.getModelMap().addAttribute("message",message);
        }
    }

    /**
     * 它是拦截器最后执行的方法，执行时机在结果视图执行完成之后，响应之前
     * 此时它可以实现一些清理的操作
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion方法执行了11111");
    }
}
