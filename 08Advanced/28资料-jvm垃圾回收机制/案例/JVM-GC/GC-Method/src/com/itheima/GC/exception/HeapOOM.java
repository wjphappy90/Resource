package com.itheima.GC.exception;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
    public static void main(String[] args) {
        //测试堆内存异常
        List<HeapOOM> heapOOMList = new ArrayList<>();
        while (true) {
            heapOOMList.add(new HeapOOM());
        }
    }
}
