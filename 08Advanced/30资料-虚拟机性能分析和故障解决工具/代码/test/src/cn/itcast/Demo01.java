package cn.itcast;

import java.io.IOException;

/*
    jps
        -q：显示进程ID
        -m：显示进程ID，主类名称，以及传入main方法的参数
        -l：显示进程ID，主类全名
        -v：显示进程ID，主类名称，以及传入JVM的参数
        -V：显示进程ID，主类名称
 */
//-Xmn8m 指定年轻代内存大小
public class Demo01 {
    public static void main(String[] args) throws IOException {
        System.out.println("jps");
        System.in.read();

    }
}