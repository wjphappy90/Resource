package com.itheima.web.advice;

import com.itheima.web.exception.CustomerException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    public String handleException(Model model, Exception e){
        String errorMsg = "";
        //判断Exception的类型是不是CustomerException
        if(e instanceof CustomerException){
            errorMsg = e.getMessage();
        }else {
            //系统异常
            errorMsg = "服务器内部错误，请联系管理员！";
        }

        model.addAttribute("errorMsg",errorMsg);
        return "error";
    }
}
