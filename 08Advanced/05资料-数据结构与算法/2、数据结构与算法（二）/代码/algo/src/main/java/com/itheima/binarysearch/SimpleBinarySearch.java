package com.itheima.binarysearch;

import org.junit.Test;

import java.util.Arrays;

/**
 * 二分查找的简单实现
 */
public class SimpleBinarySearch {

    /**
     * 使用非递归的形式查找
     * @param array  待查找的有序数组
     * @param value  要查找的数值
     * @return
     */
    public int cicleBinarySearch(int[] array,int value){
        int low = 0;
        int high = array.length-1;
        
        while(low <= high){
            //int mid = (high+low)/2;
            //计算中间元素的下标
            int mid = low +((high-low) >> 1);
            if(array[mid] == value){
                return mid;
            }else if( array[mid] < value){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        
        //如果至此还未找到则返回-1代表未找到匹配的元素
        return -1;
    }

    /**
     * 使用递归的形式查找
     * @param array
     * @param value
     * @return
     */
    public int recursionBinarySearch(int[] array,int value,int low,int high){
        if(low > high){
            return -1;
        }
        
        //int mid = (high+low)/2;
        //计算中间元素的下标
        int mid = low +((high-low) >> 1);
        if(array[mid] == value){
            return mid;
        }
        if( array[mid] < value){
            return recursionBinarySearch(array,value,mid+1,high);
        }else {
            return recursionBinarySearch(array,value,low,mid-1);
        }
    }

    @Test
    public void testBinarySearch(){
        //准备一个int数组 6，12，15，19，24，26，29，35，46，67
        int[] array = new int[10];
        array[0] = 6;
        array[1] = 12;
        array[2] = 15;
        array[3] = 19;
        array[4] = 24;
        array[5] = 26;
        array[6] = 29;
        array[7] = 35;
        array[8] = 46;
        array[9] = 67;
        //进行排序
        System.out.println(Arrays.toString(array));
       // int i = cicleBinarySearch(array, 15);
        int i = recursionBinarySearch(array, 15,0,array.length-1);
        //输出排序结果
        System.out.println("找到了目标元素的下标:"+i+"---对应的值为:"+array[i]);
    }
}
