package com.itheima.test;

/**
 请描述在线程的生命周期中， 有几种状态呢 ?

 1.	NEW(新建) 线程刚被创建，但是并未启动。
 2.	Runnable(可运行)
 线程可以在java虚拟机中运行的状态，可能正在运行自己代码，也可能没有，这取决于操作系统处理器。
 3.	Blocked(锁阻塞)
 当一个线程试图获取一个对象锁，而该对象锁被其他的线程持有，则该线程进入Blocked状态；当该线程持有锁时，该线程将变成Runnable状态。
 4.	Waiting(无限等待)
 一个线程在等待另一个线程执行一个（唤醒）动作时，该线程进入Waiting状态。进入这个状态后是不能自动唤醒的，必须等待另一个线程调用notify或者notifyAll方法才能够唤醒。
 5.	Timed Waiting(计时等待)
 同waiting状态，有几个方法有超时参数，调用他们将进入Timed Waiting状态。这一状态将一直保持到超时期满或者接收到唤醒通知。带有超时参数的常用方法有Thread.sleep 、Object.wait。
 6.	Teminated(被终止)
 因为run方法正常退出而死亡，或者因为没有捕获的异常终止了run方法而死亡。

 */
public class Demo06 {
}
