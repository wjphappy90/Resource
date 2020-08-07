package cn.itcast;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
    JConsole演示内存变化
*/
public class Demo08 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Thread.sleep(5000);
        System.out.println("start...");
        test1(10000);

        System.in.read();
    }

    public static void test1(int num) throws InterruptedException {
        final int _128K = 128 * 1024; //128k
        List<byte[]> list = new ArrayList<byte[]>();
        for (int i = 0; i < num; i++) {
            //稍作延时，令监视曲线的变化更加明显
            Thread.sleep(100);
            list.add(new byte[_128K]);
        }
    }
}
