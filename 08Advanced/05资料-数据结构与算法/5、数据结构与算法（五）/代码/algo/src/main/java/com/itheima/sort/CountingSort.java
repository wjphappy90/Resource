package com.itheima.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 计数排序
 *  1:找出待排序的数组中最大和最小的元素；
    2:统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
    3:对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
    4:反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
 */
public class CountingSort {
    
    public void countingSort(int[] array){
        //求出待排序数组的最大值,最小值,找出取值区间
        int max = array[0];
        int min = array[0];
        for(int i=0;i<array.length;i++){
            if( array[i] > max){
                max = array[i];
            }
            if(array[i] < min){
                min = array[i];
            }
        }
        //定义一个额外的数组C
        int bucketSize = max - min +1;
        int[] bucket = new int[bucketSize];
        //统计对应元素的个数,数组的下标不是单纯的值
        for(int i=0;i< array.length;i++){
            int bucketIndex = array[i] - min;
            bucket[bucketIndex]+=1;
        }
        //对数组C内元素进行累加 
        for(int i=1;i<bucket.length;i++){
            bucket[i] = bucket[i] + bucket[i-1];
        }
        //创建临时数组R 存储最终有序的数据列表 
        int[] temp = new int[array.length];
        //逆序扫描待排序数组 可保证元素的稳定性
        for(int i= array.length -1;i >=0;i--){
            int bucketIndex = array[i] - min;
            temp[bucket[bucketIndex]-1]  = array[i];
            bucket[bucketIndex] -=1;
        }
        /*for(int i= 0;i < array.length;i++){
            int bucketIndex = array[i] - min;
            temp[bucket[bucketIndex]-1]  = array[i];
            bucket[bucketIndex] -=1;
        }*/
        //将临时数据列表依次放入原始数组
        for(int i=0;i<temp.length;i++){
            array[i] = temp[i];
        }
    }

    /**
     * 测试快排
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
