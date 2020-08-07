package com.itheima.heap;

import org.junit.Test;

import java.util.Arrays;

/**
 * 测试自定义的堆
 */
public class HeapTest {
    
    @Test
    public void test1(){
        Heap heap = new Heap(6);
        
        heap.insert(12);
        heap.insert(15);
        heap.insert(16);
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        System.out.println(heap);
        int max = heap.removeMax();
        System.out.println(max);
        System.out.println(heap);
    }
}
