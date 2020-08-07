package com.itheima.ds_project02.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class CountingSort {
    
    public void countingSort(int[] array){

        // 求出待排序的数组中的最大值和最小值，找出取值区间
        int max = array[0];
        int  min  =array[0];
        for  ( int i =0 ; i<array.length; i++){
            if (array[i]>max){
                max = array[i];
            }
            if (array[i]<min){
                min = array[i];
            }
        }
        // 定义一个额外的数组
        int bucketSize = (max -min)+1;
        int[] bucket  = new int[bucketSize];
        // 统计对应元素的个数
        for ( int i=0;i<array.length;i++){
            int bucketIndex =array[i] -min;
            bucket[bucketIndex]+=1;
        }
        //  对数组中的元素进行累加操作
        for (int i=1; i<bucket.length;i++){
            bucket[i] =bucket[i]+bucket[i-1];
        }

        // 创建一个临时数组，村塾最终有序的序列

        int [] temp = new int[array.length];

        // 逆序扫描待排序的数组，可以保证我们元素稳定性

        for(int i=array.length-1;i>=0;i--){
            int bucketIndex = array[i]-min;
            temp[bucket[bucketIndex]-1] =array[i];
            bucket[bucketIndex]-=1;
        }

        // 将我们临时数据一次放入 原始数组中

        for( int i =0; i<temp.length;i++){
             array[i] =temp[i];
        }

    }

    /**
     * 测试计数排序
     */
    @Test
    public void testCountingSort(){
        //准备一个int数组
        int[] array = new int[8];
        array[0] = 5;
        array[1] = 2;
        array[2] = 6;
        array[3] = 9;
        array[4] = 0;
        array[5] = 3;
        array[6] = 3;
        array[7] = 4;
        //进行排序
        System.out.println(Arrays.toString(array));
        countingSort(array);
        //输出排序结果
        System.out.println(Arrays.toString(array));
    }
}
