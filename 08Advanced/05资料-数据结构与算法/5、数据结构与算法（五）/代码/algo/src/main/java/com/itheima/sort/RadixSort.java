package com.itheima.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 基数排序
 *  1：取得数组中的最大数，并取得位数；
    2：arr为原始数组，从最低位开始取每个位组成radix数组；
    3：对radix进行计数排序（利用计数排序适用于小范围数的特点）；
 */
public class RadixSort {

    /**
     * 基数排序
     * @param array
     * @return
     */
    public int[] radixSort(int [] array){
        if (array == null || array.length < 2){
            return array;
        }
        // 1.先算出最大数的位数；
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++){
            bucketList.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                int num = (array[j] % mod) / div;
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++)
                    array[index++] = bucketList.get(j).get(k);
                bucketList.get(j).clear();
            }
        }
        return array;
    }


    @Test
    public void testRadixSort(){
        //准备一个int数组
        int[] array = new int[9];
        array[0] = 25;
        array[1] = 2;
        array[2] = 36;
        array[3] = 9;
        array[4] = 10;
        array[5] = 3;
        array[6] = 4;
        array[7] = 3;
        array[8] = 135;
        //进行排序
        System.out.println(Arrays.toString(array));
        array = radixSort(array);
        //输出排序结果
        System.out.println(Arrays.toString(array));
    }
}
