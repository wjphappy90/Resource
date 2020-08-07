package cn.itcast;

import java.io.IOException;

/*
    -gc 选项：垃圾收集的堆统计信息
        S0C：当前幸存者空间0容量（kB）
        S1C：当前生存空间1的容量（kB）
        S0U：幸存者空间0使用大小（kB）
        S1U：幸存者空间1使用大小（kB）
        EC：当前伊甸园空间容量（kB）
        EU：伊甸园空间使用大小（kB）
        OC：当前的老年代容量（kB）
        OU：老年代使用大小（kB）
        MC：元空间容量（kB）
        MU：元空间使用大小（kB）
        CCSC：压缩的类空间容量（kB）
        CCSU：使用的压缩类空间（kB）
        YGC：新生代垃圾收集事件的数量
        YGCT：新生代垃圾回收时间
        FGC：完整GC事件的数量
        FGCT：完整的垃圾收集时间
        GCT：总垃圾收集时间
 */
public class Demo03 {
    //-Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc
    public static void main(String[] args) throws InterruptedException, IOException {
        final int _1MB = 1024 * 1024;
        byte[] b1 = new byte[2 * _1MB];
        System.out.println("1...");
        System.in.read();

        byte[] b2 = new byte[2 * _1MB];
        System.out.println("2...");
        System.in.read();

        byte[] b3 = new byte[2 * _1MB];
        System.out.println("3...");
        System.in.read();
    }
}

/*
    gcutil 选项：垃圾收集统计信息
        S0：幸存者空间0利用率占该空间当前容量的百分比
        S1：幸存者空间1利用率占空间当前容量的百分比
        E：Eden空间利用率占空间当前容量的百分比
        O：老年代利用率占空间当前容量的百分比
        M：元空间利用率占空间当前容量的百分比
        CCS：压缩的类空间利用率，以百分比表示
        YGC：新生代GC事件的数量
        YGCT：新生代垃圾回收时间
        FGC：完整GC事件的数量
        FGCT：完整的垃圾收集时间
        GCT：总垃圾收集时间
*/