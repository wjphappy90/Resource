package com.itheima.utils;

public class ArrayUtils {

    public static int getMax(int[] arr){
        //1.定义一个变量存储当前的最大值
        int max = arr[0];
        //2. 使用存储最大值的变量与数组中的每一个元素进行对比
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>max){
            //3. 如果发现了数组的元素比最大值变量要大，那么最大值的变量存储当前的元素
                max  = arr[i];
            }
        }
        //4. 返回最大值
        return max;
    }
}
