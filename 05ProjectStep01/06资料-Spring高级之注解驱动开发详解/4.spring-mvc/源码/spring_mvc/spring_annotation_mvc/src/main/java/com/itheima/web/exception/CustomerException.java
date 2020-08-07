package com.itheima.web.exception;

/**
 * 自定义异常（处理业务异常）
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class CustomerException extends Exception{

    private String message;

    public CustomerException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
