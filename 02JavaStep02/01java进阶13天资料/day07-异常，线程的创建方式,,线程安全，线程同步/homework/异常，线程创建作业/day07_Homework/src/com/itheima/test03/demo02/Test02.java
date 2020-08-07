package com.itheima.test03.demo02;

/**
 请描述以下方式创建线程的步骤。
    - 继承Thread类方式
    - 实现Runnable接口方式


 答：
    继承Thread类方式
		1.定义Thread类的子类，
		2.重写该类的run()方法，将线程任务相关的代码写在该方法中。
		3.创建Thread子类的对象，即创建了线程对象。
		4.调用线程对象的start()方法来启动该线程。

 	实现Runnable接口方式
		1.定义Runnable接口的实现类
		2.重写该接口的run()方法，将线程任务相关的代码写在该方法中
		3.创建Runnable实现类的对象，并以此对象作为Thread的target来创建Thread对象
		4.调用线程对象的start()方法来启动线程

 */
public class Test02 {
}
