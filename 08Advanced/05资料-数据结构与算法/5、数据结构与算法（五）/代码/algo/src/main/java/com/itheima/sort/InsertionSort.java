package com.itheima.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 插入排序算法
 * 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。
 * 我们将数组中的数据分为两个区间，已排序区间和未排序区间。初始已排序区间只有一个元素，就
    是数组的第一个元素。插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的
    插入位置将其插入，并保证已排序区间数据一直有序。重复这个过程，直到未排序区间中元素为
    空，算法结束。
 * 
 * 步骤：
 1：从第一个元素开始，该元素可以认为已经被排序；
 2：取出下一个元素，在已经排序的元素序列中从后向前扫描；
 3：如果该元素（已排序）大于新元素，将该元素移到下一位置；
 4：重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 5：将新元素插入到该位置后；
 6：重复步骤2~5。
 */
public class InsertionSort {
    
    public void insertionSort1(int[] arr){
        int len = arr.length;
        if(len <=1) {
            return;
        }
        //开始排序
        for(int i= 1;i<len;i++){
            //取出未排序的下一个元素，及当前参与比较的元素
            int current = arr[i];
            //在已经排序的元素序列中从后向前扫描,定义前置索引
            int preIndex = i-1;
            // 从后向前依次和当前元素进行比较,
            while(preIndex >= 0 && arr[preIndex] > current ){
                //比较过程中如果元素大于当前的元素则将元素后移一位
                arr[preIndex+1] = arr[preIndex];
                preIndex --;
            }
            //比较过程中如果该元素小于等于当前元素,则将当前元素放在该元素后面
            arr[preIndex+1] = current;
        }
    }

    /**
     * 测试插入排序
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
        insertionSort1(array);
        //输出排序结果
        System.out.println(Arrays.toString(array));
    }
}
