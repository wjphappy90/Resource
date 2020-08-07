package cn.itcast;

import java.io.IOException;

/*
    jmap:
        命令像信息
        使用不带选项参数的jmap打印共享对象映射，将会打印目标虚拟机中加载的每个共享对象的起始地址、映射大小以及共享对象文件的路径全称

        命令：jmap -heap pid
        描述：显示Java堆详细信息
        打印一个堆的摘要信息，包括使用的GC算法、堆配置信息和各内存区域内存使用信息

        命令：jmap -histo:live pid
        命令：jmap -histo pid
        描述：显示堆中对象的统计信息
        其中包括每个Java类、对象数量、内存大小(单位：字节)、完全限定的类名。打印的虚拟机内部的类名称将会带有一个’*’前缀。如果指定了live子选项，则只计算活动的对象

        命令：jmap -clstats pid
        描述：打印类加载器信息
        -clstats是-permstat的替代方案，在JDK8之前，-permstat用来打印类加载器的数据
        打印Java堆内存的永久保存区域的类加载器的智能统计信息。对于每个类加载器而言，它的名称、活跃度、地址、父类加载器、它所加载的类的数量和大小都会被打印。此外，包含的字符串数量和大小也会被打印。

        命令：jmap -finalizerinfo pid
        描述：打印等待终结的对象信息
        Number of objects pending for finalization:0 说明当前F-Queue队列中并没有等待Finalizer线程执行finalizer方法的对象。

        命令：jmap -dump:live,format=b,file=jmap.bin pid
        描述：生成堆转储快照dump文件
        以二进制格式转储Java堆到指定filename的文件中。live子选项是可选的。如果指定了live子选项，堆中只有活动的对象会被转储。想要浏览heap dump，你可以使用jhat(Java堆分析工具)读取生成的文件。这个命令执行，JVM会将整个heap的信息dump写入到一个文件，heap如果比较大的话，就会导致这个过程比较耗时，并且执行的过程中为了保证dump的信息是可靠的，所以会暂停应用， 线上系统慎用
 */
public class Demo05 {
    public static void main(String[] args) throws IOException {
        Demo05 demo05 = new Demo05();
        System.out.println("jmap");
        System.in.read();
    }
}
