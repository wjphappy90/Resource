package cn.itcast;

import java.io.IOException;

/*
    jstack:
        -F : 当线程挂起时，使用jstack pid 请求不被响应时，强制输出线程堆栈

        -l : 除堆栈外，显示关于锁的附加信息,例如 ownable synchronizers

        -m : 可以同时输出java以及C/C++的堆栈信息

 */
public class Demo06 {
    public static void main(String[] args) throws IOException {
        System.out.println("jstack");
        System.in.read();
    }
}
