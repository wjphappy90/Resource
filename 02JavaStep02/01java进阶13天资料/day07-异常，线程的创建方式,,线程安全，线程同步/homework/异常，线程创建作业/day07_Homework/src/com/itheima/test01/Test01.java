package com.itheima.test01;

/**
 需求说明
 1. 请说出异常的继承体系
 2. 请说出你对错误(Error)的理解
 3. 请说出你对编译异常(Expection的理解)
 4. 请说出你对运行时异常(RuntimeException)的理解
 */
public class Test01 {
    /*1.	异常继承体系为:
        a)	最顶层父类是Throwable
        b)	Error与Exception继承Throwable
        c)	RuntimeException继承Exception
    2.	Error是系统级别的严重的错误,错误无法处理,只能修改代码.
    3.	Exception是编译时异常,编译时必须对编译异常进行处理,否则编译失败,如:日期格式化异常
    4.	RuntimeException是运行时异常,编译时无需处理,但程序运行的时候可能会报错,如:算术异常*/
}
