package com.itheima.ds_project02.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 归并排序算法
 *  归并排序的核心思想还是蛮简单的。如果要排序一个数组，我们先把数组从中间分成前后两部分，
    然后对前后两部分分别排序，再将排好序的两部分合并在一起，这样整个数组就都有序了
 */
public class MergeSort {
    public int[] mergeSort(int[] arr){

        if (arr.length<2){
            return  arr;
        }
        //将我们的数组拆分成两个部分

        int mid = arr.length/2;
        int [] left = Arrays.copyOfRange(arr,0,mid);
        int [] right = Arrays.copyOfRange(arr,mid,arr.length);

        //  分解并合并
        return merge(mergeSort(left),mergeSort(right));


    }
    /**
     * 合并两个有序数组并返回新的数组
     * @param left
     * @param right
     */
    public int[] merge(int[] left,int[] right){

        // 创建一个新的数组，这个数组的长度等于两个数组长度之和
       int [] newArray = new int[left.length+right.length];
       //  定义两个指针分别代表两个数组的下标
        int lindex = 0;
        int rindex = 0;
        for (int i=0; i< newArray.length;i++){
            if (lindex>=left.length){
                newArray[i]=right[rindex++];
            } else  if (rindex>=right.length){
                newArray[i] =left[lindex++];
            } else if(left[lindex] <right[rindex]){
                newArray[i] = left[lindex++];
            } else {
                newArray[i] = right[rindex++];
            }
        }
        return  newArray;
    }


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
        array = mergeSort(array);
        //输出排序结果
        System.out.println(Arrays.toString(array));
    }
}
