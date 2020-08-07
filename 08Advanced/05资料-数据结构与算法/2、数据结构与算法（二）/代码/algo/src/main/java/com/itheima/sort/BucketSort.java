package com.itheima.sort;

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
     * @param bucketSize  桶中元素类型的个数即每个桶所能放置多少个不同数值（例如当BucketSize==5时，该桶可以存放｛1,2,3,4,5｝这几种数字，但是容量不限，即可以存放100个3）
     * @return            排好序后的集合
     */
    public static List<Integer> bucketSort(List<Integer> array,int bucketSize){
        if(array == null || array.size() < 2 || bucketSize < 1){
            return array;
        }
        //找出集合中元素的最大值,最小值
        int max = array.get(0);
        int min = array.get(0);
        for(int i=0 ;i < array.size();i++){
            if(array.get(i) > max){
                max = array.get(i);
            }
            if(array.get(i) < min){
                min = array.get(i);
            }
        }
        //计算桶的个数   最大值-最小值代表了集合中元素取值范围区间 
        int bucketCount = (max - min )/bucketSize +1;
        //按序创建桶,创建一个List,List带下标是有序的,List中的每一个元素是一个桶,也用List表示
        List<List<Integer>> bucketList = new ArrayList<>();
        for(int i=0;i< bucketCount;i++){
            bucketList.add(new ArrayList<Integer>());
        }
        //将待排序的集合依次添加到对应的桶中
        for(int j=0; j< array.size();j++){
            int bucketIndex = (array.get(j)-min)/bucketSize;
            bucketList.get(bucketIndex).add(array.get(j));
        }
        //对每一个桶中的数据进行排序(可以使用别的排序方式),然后再将桶中的数据依次取出存放到一个最终的集合中
        //创建最终的集合
        List<Integer> resultList = new ArrayList<>();
        for(int j=0;j < bucketList.size(); j++){
            
            List<Integer> everyBucket = bucketList.get(j);
            //如果桶内有元素
            if(everyBucket.size()>0){
                
                //递归的使用桶排序为每一个桶进行排序
                //当某次桶排序待排序集合都分配到一个桶中时,缩小桶的范围以获得更多的桶
                if(bucketCount ==1){
                    bucketSize--;
                }
                List<Integer> temp = bucketSort(everyBucket, bucketSize);
                for(int i=0;i<temp.size();i++){
                    resultList.add(temp.get(i));
                }
            }
        }
        return resultList;
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
