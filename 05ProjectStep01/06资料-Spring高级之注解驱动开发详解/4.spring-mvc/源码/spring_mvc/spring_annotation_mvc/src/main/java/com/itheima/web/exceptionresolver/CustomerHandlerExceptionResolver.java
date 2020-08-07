package com.itheima.web.exceptionresolver;

import com.itheima.web.exception.CustomerException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常处理解析器
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
//@Component
public class CustomerHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //1.创建返回值对象
        ModelAndView mv = new ModelAndView();
        //2.设置错误提示信息
        //判断Exception的类型是不是CustomerException
        if(ex instanceof CustomerException){
            mv.addObject("errorMsg",ex.getMessage());
        }else {
            //系统异常
            mv.addObject("errorMsg","服务器内部错误，请联系管理员！");
        }
        //3.设置结果视图名称
        mv.setViewName("error");
        //4.返回
        return mv;
    }
}
