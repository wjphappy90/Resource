package cn.itcast;

import java.io.IOException;

/*
    jinfo:
        命令：jinfo pid
        描述：输出当前 jvm 进程的全部参数和系统属性

         命令：jinfo -flags pid
        描述：输出全部的虚拟机参数

        命令：jinfo -sysprops pid
        描述：输出当前虚拟机进程的全部的系统属性


        命令：jinfo -flag name pid
        描述：使用该命令，可以查看指定的 jvm 参数的值
        如：查看当前 jvm 进程是否开启打印 GC 日志
        jinfo -flag PrintGC pid

        命令：jinfo -flag [+|-]name pid
        描述：开启或者关闭对应名称的参数
        使用 jinfo 可以在不重启虚拟机的情况下，可以动态的修改 jvm 的参数。尤其在线上的环境特别有用。
        jinfo -flag +PrintGC pid
        jinfo -flag PrintGC pid
        jinfo -flag +PrintGC pid
        jinfo -flag PrintGC pid

        命令：jinfo -flag name=value pid
        描述：修改指定参数的值。
        和上面的例子相似，但是上面的主要是针对 boolean 值的参数设置的。
        如果是设置 value值，则需要使用 name=value 的形式
        jinfo -flag HeapDumpPath pid
        jinfo -flag HeapDumpPath=d:\\dump pid
        jinfo -flag HeapDumpPath pid
        jinfo -flag HeapDumpPath= pid
        jinfo -flag HeapDumpPath pid

        注意：jinfo虽然可以在java程序运行时动态地修改虚拟机参数，但并不是所有的参数都支持动态修改



 */
public class Demo04 {
    public static void main(String[] args) throws IOException {
        System.out.println("jinfo");
        System.in.read();
    }
}
