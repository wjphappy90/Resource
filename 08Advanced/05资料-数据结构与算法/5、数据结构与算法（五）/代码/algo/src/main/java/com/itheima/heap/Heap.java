package com.itheima.heap;

import java.util.Arrays;

/**
 * 堆:
 *  利用数组实现的大顶堆
 */
public class Heap{
    
    // 存储堆中元素数据的数组
    private int[]  data;
    // 堆中可存数据的最大个数
    private int size;
    // 堆中已存元素的个数
    private int count;

    /**
     * 利用初始容量构造存储堆元素的数组
     * @param capacity
     */
    public Heap(int capacity){
        // 利用数组存储堆,从数组下标为1的地方开始存储,方便计算
        this.data = new int[capacity+1];
        this.size = capacity;
        this.count = 0;
    }

    /**
     * 移除堆顶元素
     * @return
     */
    public int removeMax(){
        // 如果是大顶堆,数组下标为1的元素就是最大值
        int max = data[1];
        //移除完成后要保证堆的完整，需要找第二大的元素放到堆顶
        //1: 将最后一个元素直接放在堆顶,并减少数量
        data[1] = data[count--];
        //2: 堆化让其继续成为一个合格的堆---->这个时候要自上而下堆化
        headifyFromTop2Button(data,1,count);
        return max;
    }

    /**
     * 将数组data堆化
     * @param data
     * @param begin 从该位置自上而下堆化
     * @param end   堆化截止位置
     */
    private void headifyFromTop2Button(int[] data,int begin,int end){
        while (true){
            // 定义最大值的下标
            int maxPos = begin;
            // 比较当前节点与其左子节点,右子节点的大小关系,找出最大值
            if( 2*begin <= end && data[maxPos] < data[2*begin]){
                maxPos = 2*begin;
            }
            if(2*begin+1 <=end && data[maxPos] < data[2*begin +1]){
                maxPos = 2*begin +1;
            }
            if(begin == maxPos){
                break;
            }
            swap(data,begin,maxPos);
            begin = maxPos;
        }
    }
    
    /**
     * 将数据存入堆中,
     * @param data
     */
    public void insert(int data){
        if(count >= size ){
            return;// 堆已满
        }
        // 将数据存入
        this.data[++count] = data;
        // 堆化：自下而上堆化
        heapifyFromBottom2Top(this.data,count);
    }

    /**
     * 将数组data堆化
     * @param data
     * @param end  从end位置自下而上堆化
     */
    private void heapifyFromBottom2Top(int[] data,int end){
        int i = end;
        while ( i/2 > 0 && this.data[i/2] < this.data[i]){
            swap(this.data,i/2,i);
            i /=2;
        }
    }
    /**
     * 交换数组下标i,j的元素
     * @param array
     * @param i
     * @param j
     */
    public void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
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
