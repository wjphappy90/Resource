package com.itheima.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://visualgo.net
 * 快速排序算法
 *  1：从数列中挑出一个元素，称为 “基准”（pivot）；
    2：重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
    3：递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
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
        //判断递归截止条件
        if(arr.length <=1 || begin >=end){
            return;
        }
        //进行分区 得到分区下标
        int pivotIndex = partition(arr,begin,end);
        //对分区左侧进行快排
        quickSort(arr,begin,pivotIndex-1);
        //对分区右侧进行快排
        quickSort(arr,pivotIndex+1,end);
    }

    /**
     * 分区函数
     * @param arr
     * @param begin
     * @param end
     * @return
     */
    private int partition(int[] arr, int begin, int end) {
        //默认数组中待分区区间的最后一个是pivot元素  当然也可以随机指定pivot元素
        int  pivot = arr[end];
        //定义分区后pivot元素的下标
        int pivotIndex = begin;
        for(int i= begin;i< end;i++){
            //判断如果该区间内如果有元素小于pivot则将该元素从区间头开始一直向后填充 有点类似选择排序
            if(arr[i] < pivot){
                
                if(i>pivotIndex){
                    swap(arr,i,pivotIndex);
                }
                pivotIndex++;
            }
        }
        swap(arr,pivotIndex,end);
        return pivotIndex;
    }

    /**
     * 交换数组内下标为i j的两个元素
     * @param arr
     * @param i
     * @param j
     */
    private void swap(int[] arr,int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
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
