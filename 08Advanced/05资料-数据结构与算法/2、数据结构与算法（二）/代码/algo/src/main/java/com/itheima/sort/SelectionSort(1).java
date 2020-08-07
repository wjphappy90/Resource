package com.itheima.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 选择排序算法
 * 选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。但是选择排序每次会
   从未排序区间中找到最小的元素，将其放到已排序区间的末尾
 */
public class SelectionSort {

    /**
     * 算法实现
     * @param arr
     */
    public void selectionSort(int[] arr){
        int len = arr.length;
        if(len<=1){
            return;
        }
        for(int i=0;i<len;i++){
            
            //接下来找到未排序区间的最小值的下标
            int minIndex = i;
            for(int j=i;j<len;j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            //交换未排序区间最小元素和当前元素的位置
            int current = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = current;
        }
    }
    /**
     * 测试选择排序
     */
    @Test
    public void testInsertionSort1(){
        //准备一个int数组
        int[] array = new int[6];
        array[0] = 5;
        array[1] = 2;
        array[2] = 6;
        array[3] = 9;
        array[4] = 0;
        array[5] = 3;
        //进行排序
        System.out.println(Arrays.toString(array));
        selectionSort(array);
        //输出排序结果
        System.out.println(Arrays.toString(array));
    }
}
