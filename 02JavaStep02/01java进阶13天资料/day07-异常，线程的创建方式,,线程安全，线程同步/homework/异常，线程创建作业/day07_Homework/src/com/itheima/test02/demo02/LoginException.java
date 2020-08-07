package com.itheima.test02.demo02;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test02.demo02
 * @date 2018/3/21  下午10:16
 */
public class LoginException extends Exception {
    public LoginException() {
        super();
    }

    public LoginException(String message) {
        // 一定要调用父类的构造方法
        super(message);
    }
}