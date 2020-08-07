package com.itheima.sort;


import org.junit.Test;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {

    /**
     * 堆排序：分为两步
     *  1：建堆
     *  2：排序
     *  注意：这里数组中的数据是从下标为1开始
     * @param array
     */
    public void heapSort(int[] array){
        //1:建堆
        buildHeap(array,array.length-1);
        // 排序
        sort(array,array.length-1);
    }

    /**
     * 排序：
     *  我们把堆顶元素跟最后一个元素互换,然后对1~n-1区间的元素再堆化,然后在将堆顶元素跟最后一个元素互换继续操作，
     *  有点类型删除堆顶元素
     * @param array
     */
    private void sort(int[] array,int n){
        while (n > 1){
            swap(array,1,n);
            headifyFromTop2Button(array,1,--n);
        }
    }

    /**
     * 建堆：建大顶堆,堆化是自上而下堆化
     * @param array   待建堆数组
     * @param n       数组最后一个元素的下标---堆中最后一个元素下标
     */
    private void buildHeap(int[] array,int n) {
        // 从后往前处理数组数据,堆化的时候是自上而下堆化
        for(int i= n/2;i>0; i--){
            headifyFromTop2Button(array,i,n);
        }
    }

    /**
     * 将数组data堆化
     * @param data
     * @param begin 从该位置自上而下堆化
     * @param end   堆化截止位置
     */
    private void headifyFromTop2Button(int[] data,int begin,int end){
        while (true){
            // 定义最大值的下标
            int maxPos = begin;
            // 比较当前节点与其左子节点,右子节点的大小关系,找出最大值
            if( 2*begin <= end && data[maxPos] < data[2*begin]){
                maxPos = 2*begin;
            }
            if(2*begin+1 <=end && data[maxPos] < data[2*begin +1]){
                maxPos = 2*begin +1;
            }
            if(begin == maxPos){
                break;
            }
            swap(data,begin,maxPos);
            begin = maxPos;
        }
    }

    /**
     * 交换数组下标i,j的元素
     * @param array
     * @param i
     * @param j
     */
    public void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    
    @Test
    public void testHeapSort(){
        //准备一个int数组
        int[] array = new int[7];
        array[1] = 2;
        array[2] = 6;
        array[3] = 9;
        array[4] = 0;
        array[5] = 3;
        array[6] = 5;
        //进行排序
        System.out.println(Arrays.toString(array));
        heapSort(array);
        //输出排序结果
        System.out.println(Arrays.toString(array));
    }
}
