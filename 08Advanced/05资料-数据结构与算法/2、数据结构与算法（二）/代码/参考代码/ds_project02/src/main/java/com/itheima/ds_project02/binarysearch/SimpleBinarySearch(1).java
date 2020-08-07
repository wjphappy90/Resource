package com.itheima.ds_project02.binarysearch;

import com.sun.xml.internal.org.jvnet.fastinfoset.stax.LowLevelFastInfosetStreamWriter;
import org.junit.Test;

import javax.xml.bind.ValidationEvent;
import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 二分查找的简单实现
 */
public class SimpleBinarySearch {

    public  int  binarySearch(int [] array ,int value){

        int low = 0;
        int high =array.length-1;

        while (low<= high){
            // 计算 mid 指针
            int mid = (low+high)/2;
            if(array[mid] == value){
                return  mid;
            } else if( array[mid] < value){
                low = mid+1;
            }else {
                high = mid -1;
             }
    }
          return  -1;
    }

    public int recursionBinarySearch(int[] array,int value,int low,int high){

        if (low>=high){
            return -1;
        }

        // 计算mid 指针
        int mid = (low +high)/2;

        if (array[mid] == value){
            return  mid;
        } else  if (array[mid] <value){
           return  recursionBinarySearch(array,value,mid+1,high);
        } else {
           return   recursionBinarySearch(array,value,low,mid-1);
        }

    }


    @Test
        public void testBinarySearch() {
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
      //  int i = binarySearch(array, 15);

        int i =recursionBinarySearch(array,15,0,array.length-1);
        //输出排序结果
        System.out.println("找到了目标元素的下标:" + i + "---对应的值为:" + array[i]);
    }
}
