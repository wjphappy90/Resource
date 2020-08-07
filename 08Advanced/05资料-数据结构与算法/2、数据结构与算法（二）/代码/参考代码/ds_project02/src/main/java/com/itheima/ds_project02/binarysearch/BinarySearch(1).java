package com.itheima.ds_project02.binarysearch;

import org.junit.Test;

import java.util.Arrays;
import java.util.EmptyStackException;

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
    public int binarySearch1(int[] array,int value) {
        //  定义我们查找范围
        int low = 0;
        int high = array.length -1 ;
        while (low<= high){
            //   中间指针 mid 计算出来
            int  mid  =  (low+high)/2;
            if(array[mid] == value){
                //    此时当我们的mid指针已经指向第一个元素或者我们的mid指针前一个元素不等与我们查找元素的时候直接返回mid下标，否则  继续二分查找
                if(mid==0 || array[mid-1] !=value){
                     return  mid;
                }else {
                     high = mid -1;
                }
            } else  if(array[mid] <value){
                     low = mid+1;
            }  else  if (array[mid]>value){
                     high = mid -1;
            }
        }

             return  -1;
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
         // 定义查找范围
         int low  = 0;
         int high = array.length-1;

         while (low<= high){
             int mid = (low+high)/2;
              //
             if (array[mid] == value){
                 // 如果我们中间指针指向数组的最后一个位置或者mid指针指向的元素的下一个元素不等查找的value，直接返回中间指针下标mid ，否则  向右检索
                 if(mid == array.length-1 ||  array[mid+1] !=value){
                     return  mid;
                 }else {
                     low = mid+1;
                 }
             } else if (array[mid] <value){
                     low = mid +1;
             } else  if (array[mid] >value){
                     high = mid-1;
             }
         }
        return  -1;

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
        //  给定区间范围
        int  low  =0;
        int  high =array.length-1;

        while (low<=high){
            int mid =(low+high)/2;

            if (array[mid]>=value){
                if (mid==0 ||  array[mid-1]<value){
                    return  mid;
                } else {
                     high = mid-1;
                }
            } else if (array[mid]<value){
                     low = mid+1;
            }

        }
        return  -1;

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
