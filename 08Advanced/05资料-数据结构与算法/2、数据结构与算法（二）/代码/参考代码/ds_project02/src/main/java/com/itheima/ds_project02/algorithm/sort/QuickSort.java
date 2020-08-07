package com.itheima.ds_project02.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 *   1\ 从我们的数据序列中找到一个分区点 【基准点】 pivot
 *   2、重新排序数列，所有元素和 基准点元素比较
 *     比基准点小  左边   比基准点大 右边
 *   3、递归 左边   和  右边
 *
 *
 */
public class QuickSort {
    /**
     * 快排
     * 借助递归和分区的思想来实现
     * @param arr
     * @param begin
     * @param end
     */
    public void quickSort(int[] arr,int begin,int end){
         //  校验 : 递归终止条件
        if (arr.length<=1|| begin>=end){
            return;
        }
        // 进行分区得到分区下标
        int  pivotIndex = partition(arr,begin,end);

        // 递归 （左侧快排）

        quickSort(arr,begin,pivotIndex-1);
        // 递归  （右侧）
        quickSort(arr,pivotIndex+1,end);

    }

    //  返回我们某一个序列的基准点 ！

    private int partition(int[] arr, int begin, int end) {
        // 默认使用 基准点 位序列最后一个元素
          int  pivot = arr[end];
          // 定义 分区后的 piovt 元素下标
        int piovtIndex = begin;
        for ( int i =begin;i<end ;i++){

            //   判断 如果该区间内有元素小于 piovt  则将该元素从区间头开始一直向后填充
            if(arr[i]<pivot){

                if (i>piovtIndex){
                      //  数据元素交换
                    swap(arr,i,piovtIndex);
                }
                  piovtIndex ++;
            }
        }
            swap(arr ,piovtIndex,end);

        return  piovtIndex;
    }

    /**
     *    交换方法
     * @param arr
     * @param i
     * @param j
     */
    private void swap(int[] arr,int i,int j){
             int temp = arr[j];
             arr[j] =arr[i];
             arr[i] = temp;

    }
    /**
     * 测试快排
     */
    @Test
    public void testQuickSort(){
        //准备一个int数组
        int[] array = new int[7];
        array[0] = 5;
        array[1] = 2;
        array[2] = 6;
        array[3] = 9;
        array[4] = 0;
        array[5] = 3;
        array[6] = 4;
        //进行排序
        System.out.println(Arrays.toString(array));
        quickSort(array,0,array.length-1);
        //输出排序结果
        System.out.println(Arrays.toString(array));
    }
}
