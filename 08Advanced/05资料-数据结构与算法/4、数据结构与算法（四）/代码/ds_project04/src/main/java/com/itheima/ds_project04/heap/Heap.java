package com.itheima.ds_project04.heap;

import com.sun.org.apache.xml.internal.security.Init;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 实现堆结构+操作
 */
public class Heap {

    /**
     * 创建堆
     */
    // 创建一个存储队中元素数组
    private int[] data;
    // 堆中存储数据最大个数
    private int size;
    //堆中已经存储元素的个数
    private int count;

    /**
     * 构造一个使用数组进行存储的堆
     * @param cp
     */
    public Heap( int cp){
        this.data  = new int[cp+1];
        this.size = cp;
        this.count =0 ;
    }

    /**
     * 删除堆顶元素
     */

    public  int  removeMaxTop(){
        int max = data[1];
        data[1] =data[count--];
        this.heapT2B(data,1,count);
        return max;
    }


    /**
     * 自顶线下堆化
     */
    private  void  heapT2B( int [] data , int begin, int end){

        while (true){
            // 定义最大值的下标
            int maxPos = begin;
            // 用当前结点和他的左右子节点比较，找出最大值
            if(2*begin<=end&& data[maxPos]<data[2*begin]){
                 maxPos = 2* begin;
            }
            if (2*begin+1<=end&& data[maxPos]<data[2*begin+1]){
                 maxPos = 2*begin+1;
            }
            if (begin == maxPos){
                break;
            }
            swp(data,begin,maxPos);
            begin = maxPos;
        }

    }

    /**
     * 向堆中插入元素【堆化--》数据j交换】
     * @return
     */

    public  void   insert(int data){
        if (count>=size){
            return;
        }
        this.data[++count] =data;
        // 堆化的操作
        this.heapB2T(this.data,count);
    }


    /**
     * 自底向上堆化操作
     * @param data
     * @param end
     */
    private   void   heapB2T(int[] data , int end){
        int i = end;
        while (i/2>0&& data[i/2] <data[i]){
             swp(data,i/2,i);
             i=i/2;
        }
    }


    /**
     *  交换数组中 下标为 i 和 j的两个元素
     * @param array
     * @param i
     * @param j
     */
    private void swp(int [] array , int i, int j){
          int temp = array[i];
          array[i] =array[j];
          array[j] =temp;
      }

    @Override
    public String toString() {
        return "Heap{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", count=" + count +
                '}';
    }
}
