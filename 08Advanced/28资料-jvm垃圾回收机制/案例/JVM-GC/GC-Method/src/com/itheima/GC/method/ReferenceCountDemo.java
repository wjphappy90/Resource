package com.itheima.GC.method;

public class ReferenceCountDemo {
    private ReferenceCountDemo instance = null;
    private int _1m = 1024 *1024;
    private byte[] bytes = new byte[_1m * 2];
    public static void testGC(){
        ReferenceCountDemo objA = new ReferenceCountDemo();
        ReferenceCountDemo objB = new ReferenceCountDemo();
        objA = objB;
        objB = objA;
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
