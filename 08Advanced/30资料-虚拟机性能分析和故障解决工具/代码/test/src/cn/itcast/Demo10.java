package cn.itcast;

import java.util.ArrayList;
import java.util.List;

/*
    jvisualvm:内存分析
 */
public class Demo10 {
    public static void main(String[] args) throws Exception{
        test1();
        System.in.read();
    }

    private static void test1() throws Exception{
        List<Student> list = new ArrayList<Student>();
        for (int i = 0; i < 100; i++) {
            Thread.sleep(1000);
            list.add(new Student());
        }

    }

}

class Student {
    private byte[] big = new byte[5 * 1024 * 1024]; //5M
}