package com.itheima.ds_project02.algorithm.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 桶排序
 */
public class BucketSort {
    /**
     * 桶排序
     * @param array       待排序集合
     * @param bucketSize  桶中元素类型的个数即每个桶所能放置多少个不同数值
     *                    （例如当BucketSize==5时，该桶可以存放｛1,2,3,4,5｝这几种数字，但是容量不限，即可以存放100个3）
     * @return            排好序后的集合
     */
    public  List<Integer> bucketSort(List<Integer> array,int bucketSize){
        //  合法性校验
        if(array==null || array.size()<2 || bucketSize<1){
            return  array;
        }
        //  找出我们集合中的元素的最大值和最小值
        int max = array.get(0);
        int min =array.get(0);
        for (int i=0;i<array.size();i++){
            if(array.get(i)>max){
                max = array.get(i);
            }
            if (array.get(i)<min){
                min = array.get(i);
            }
        }
        //   计算桶的个数   【集合中的最小值 min ---  集合中最大值 max】 表示我们整个  所有待排序的数据  范围
        int bucketCount = (max-min)/bucketSize+1;
        //  按照顺序创建桶，创建一个list ，list带下标是有序的，list中的每一个元素是一个桶，也用list桶
        List<List<Integer>>  bucketList = new ArrayList<>();
        for (int i=0; i<bucketCount;i++){
            bucketList.add(new ArrayList<Integer>());
        }
        //   将待排序的集合一次添加到对应的桶中

        for (int j=0;j<array.size();j++){
            int  bucketIndex = (array.get(j)-min)/bucketSize;
            bucketList.get(bucketIndex).add(array.get(j));
        }
        //   桶内元素的排序
        List<Integer>  reustList = new ArrayList<>();
        for ( int j =0; j<bucketList.size();j++){
              List<Integer>  everyBucket  =bucketList.get(j);

              if (everyBucket.size()>0){

                    if (bucketCount == 1){
                          bucketSize --;
                    }
                    List<Integer> temp = bucketSort(everyBucket,bucketSize);

                    for ( int i= 0; i<temp.size();i++){
                        reustList.add(temp.get(i));
                    }
              }

        }

        return  reustList;
    }

    /**
     * 测试桶排序
     */
    @Test
    public void testBucketSort(){
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(2);
        list.add(6);
        list.add(9);
        list.add(0);
        list.add(3);
        list.add(4);
        System.out.println(list);
        List<Integer> bucketSort = bucketSort(list, 2);
        System.out.println(bucketSort);
    }
}
