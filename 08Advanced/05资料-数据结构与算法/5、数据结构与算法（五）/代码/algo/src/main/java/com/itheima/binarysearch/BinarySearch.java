package com.itheima.binarysearch;

import javafx.scene.shape.VLineTo;
import org.junit.Test;

import java.util.Arrays;

/**
 * 数据序列中存在重复元素的二分查找的变形写法
 */
public class BinarySearch {
    /**
     * 查找数据序列中第一个等于给定值的元素的下标
     * @param array
     * @param value
     * @return
     */
    public int binarySearch1(int[] array,int value){
        //定义查找边界low high 
        int low = 0;
        int high = array.length-1;
        
        //循环的去判断
        while (low <= high){
            //计算mid
            int mid = low + ((high-low)>>1);
            
            if(array[mid] == value){
                //之前是直接返回mid,现在要找的是第一个等于值的元素。
                //由于数据序列是有序的,因此我们向前一位查看一下是否也等于该值,如果相等则继续二分查找,否则直接返回mid
                if(mid==0 || array[mid-1] != value){
                    return mid;
                }else {
                    high = mid-1;
                }
            }else if(array[mid] > value){
                high = mid -1;
            }else {
                low = mid +1;
            }
        }
        return -1;
    }

    /**
     * 测试查找数据序列中第一个等于给定值的元素的下标
     */
    @Test
    public void test1(){
        //准备一个int数组 6，12，15，19，24，26，29，29，29，67
        int[] array = new int[10];
        array[0] = 6;
        array[1] = 12;
        array[2] = 15;
        array[3] = 19;
        array[4] = 24;
        array[5] = 26;
        array[6] = 29;
        array[7] = 29;
        array[8] = 29;
        array[9] = 67;
        //进行排序
        System.out.println(Arrays.toString(array));
        // int i = cicleBinarySearch(array, 15);
        int i = binarySearch1(array, 29);
        //输出排序结果
        System.out.println("找到了目标元素的下标:"+i+"---对应的值为:"+array[i]);
    }

    /**
     * 从数据序列中查找最后一个值等于给定值的元素
     * @param array
     * @param value
     * @return
     */
    public int binarySearch2(int[] array,int value){
        //定义查找边界low high 
        int low = 0;
        int high = array.length-1;

        //循环的去判断
        while (low <= high){
            //计算mid
            int mid = low + ((high-low)>>1);

            if(array[mid] == value){
                //之前是直接返回mid,现在要找的是最后一个值等于给定值的元素
                //由于数据序列是有序的,因此我们向前后位查看一下是否也等于该值,如果相等则继续二分查找,否则直接返回mid
                if(mid==array.length-1 || array[mid+1] != value){
                    return mid;
                }else {
                    low = mid +1;
                }
            }else if(array[mid] > value){
                high = mid -1;
            }else {
                low = mid +1;
            }
        }
        return -1;
    }

    /**
     * 测试从数据序列中查找最后一个值等于给定值的元素
     */
    @Test
    public void test2(){
        //准备一个int数组 6，12，15，19，24，26，29，29，29，67
        int[] array = new int[10];
        array[0] = 6;
        array[1] = 12;
        array[2] = 15;
        array[3] = 19;
        array[4] = 24;
        array[5] = 26;
        array[6] = 29;
        array[7] = 29;
        array[8] = 29;
        array[9] = 67;
        //进行排序
        System.out.println(Arrays.toString(array));
        // int i = cicleBinarySearch(array, 15);
        int i = binarySearch2(array, 29);
        //输出排序结果
        System.out.println("找到了目标元素的下标:"+i+"---对应的值为:"+array[i]);
    }


    /**
     * 从数据序列中查找第一个大于等于给定值的元素
     * @param array
     * @param value
     * @return
     */
    public int binarySearch3(int[] array,int value){
        //定义查找边界low high 
        int low = 0;
        int high = array.length-1;

        //循环的去判断
        while (low <= high){
            //计算mid
            int mid = low + ((high-low)>>1);

            if(array[mid] >= value){
                if(mid==0 || array[mid-1] < value){
                    return mid;
                }else {
                    high = mid -1;
                }
            }else {
                low = mid +1;
            }
        }
        return -1;
    }

    /**
     * 测试从数据序列中查找第一个大于等于给定值的元素
     */
    @Test
    public void test3(){
        //准备一个int数组 6，12，15，19，24，26，29，29，29，67
        int[] array = new int[10];
        array[0] = 6;
        array[1] = 12;
        array[2] = 15;
        array[3] = 19;
        array[4] = 24;
        array[5] = 26;
        array[6] = 29;
        array[7] = 29;
        array[8] = 29;
        array[9] = 67;
        //进行排序
        System.out.println(Arrays.toString(array));
        // int i = cicleBinarySearch(array, 15);
        int i = binarySearch3(array, 28);
        //输出排序结果
        System.out.println("找到了目标元素的下标:"+i+"---对应的值为:"+array[i]);
    }

    /**
     * 从数据序列中查找出最后一个值小于等于给定值的元素
     * @param array
     * @param value
     * @return
     */
    public int binarySearch4(int[] array,int value){
        //定义查找边界low high 
        int low = 0;
        int high = array.length-1;

        //循环的去判断
        while (low <= high){
            //计算mid
            int mid = low + ((high-low)>>1);

            if(array[mid] <= value){
                if(mid== array.length-1 || array[mid + 1] > value){
                    return mid;
                }else{
                    low = mid + 1;
                }
                
            }else {
                high = mid -1;
            }
        }
        return -1;
    }

    /**
     * 测试从数据序列中查找出最后一个值小于等于给定值的元素
     */
    @Test
    public void test4(){
        //准备一个int数组 6，12，15，19，24，26，29，29，29，67
        int[] array = new int[10];
        array[0] = 6;
        array[1] = 12;
        array[2] = 15;
        array[3] = 19;
        array[4] = 24;
        array[5] = 26;
        array[6] = 29;
        array[7] = 29;
        array[8] = 29;
        array[9] = 67;
        //进行排序
        System.out.println(Arrays.toString(array));
        // int i = cicleBinarySearch(array, 15);
        int i = binarySearch3(array, 30);
        //输出排序结果
        System.out.println("找到了目标元素的下标:"+i+"---对应的值为:"+array[i]);
    }
}
