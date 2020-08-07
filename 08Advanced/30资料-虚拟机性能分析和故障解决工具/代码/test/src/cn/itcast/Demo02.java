package cn.itcast;

import java.io.IOException;

/*
    -class选项：类加载器统计信息
        Loaded：已加载的类数
        Bytes：加载的kB数
        Unloaded：卸载的类数
        Bytes：卸载的KB数

        Time：执行类加载和卸载操作所花费的时间

    -compiler选项：Java HotSpot VM即时编译器统计信息
        Compiled：执行的编译任务数
        Failed：编译任务数失败
        Invalid：无效的编译任务数
        Time：执行编译任务所花费的时间
        FailedType：上次失败的编译的编译类型
        FailedMethod：上次失败的编译的类名和方法


 */
public class Demo02 {
    public static void main(String[] args) throws IOException {
        System.out.println("jstat");
        System.in.read();
    }
}
