package com.itheima.test01;

/*
 1.定义异常类NoScoreException,继承RuntimeException
	a)提供空参和有参构造方法
 */
public class NoScoreException extends RuntimeException {
    // 空参构造
    public NoScoreException() {
        super();
    }

    // 有参构造
    public NoScoreException(String message) {
        super(message);
    }
}
