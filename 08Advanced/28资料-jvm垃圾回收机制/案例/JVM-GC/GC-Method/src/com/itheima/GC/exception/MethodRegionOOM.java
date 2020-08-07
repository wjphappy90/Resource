package com.itheima.GC.exception;

public class MethodRegionOOM {
    public static void main(String[] args) {
        int num = 0;
        while (true) {
            String.valueOf(num++).intern();
        }
    }
}
