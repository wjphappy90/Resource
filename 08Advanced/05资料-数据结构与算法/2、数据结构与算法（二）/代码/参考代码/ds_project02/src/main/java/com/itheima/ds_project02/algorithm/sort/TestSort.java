package com.itheima.ds_project02.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by tanshuai on 2019/7/31.
 */
public class TestSort {

    /**
     * 冒泡排序
     * @param arr
     */
    public void bubble(int[] arr){
        int len = arr.length;
        if(len <= 1) return;
        
        for(int i=0;i<len;i++){
            
            boolean exitBubble = true; 
            
            for(int j=0 ;j< len -i -1;j++){
                
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    
                    exitBubble = false;
                }
            }
            if(exitBubble){
                break;
            }
        }
    }

    /**
     * 插入排序
     * @param arr
     */
    public void insertion(int[] arr){
        int len = arr.length;
        if(len <= 1) return;
        
        for(int i=1;i<len;i++){
            int current = arr[i];
            int preIndex = i-1;
            while(preIndex >=0 && arr[preIndex] > current){
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1] = current;
        }
    }

    /**
     * 选择排序
     * @param arr
     */
    public void selection(int[] arr){
        int len = arr.length;
        if(len <= 1) return;
        
        for(int i=0;i<len;i++){
            
            int current = arr[i];
            
            int minIndex = i;
            for(int j=i ;j<len;j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            //对调
            arr[i] = arr[minIndex];
            arr[minIndex] = current;
        }
        
    }

    /**
     * 归并排序
     * @param arr
     * @return
     */
    public int[] mergeSort(int[] arr){
        if(arr.length <2){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = Arrays.copyOfRange(arr,0,mid);
        int[] right = Arrays.copyOfRange(arr,mid,arr.length);
        return merge(mergeSort(left),mergeSort(right));
    }
    public int[] merge(int[] left,int[] right){
        int[] newArray = new int[left.length+right.length];
        
        int lindex=0;
        int rindex=0;
        for(int i=0;i<newArray.length;i++){
            
            if(lindex >= left.length){
                newArray[i] = right[rindex++];
            }else if(rindex >= right.length){
                newArray[i] = left[lindex++];
            }else if(left[lindex] < right[rindex]){
                newArray[i] = left[lindex++];
            }else {
                newArray[i] = right[rindex++];
            }
        }
        return newArray;
    }

    /**
     * 快排
     * @param arr
     */
    public void quickSort(int[] arr,int start,int end){
        if(arr.length <=1 || start >= end){
            return;
        }
        //进行分区
        int pivotIndex = partion(arr,start,end);
        //对分区左侧进行快排
        quickSort(arr,start,pivotIndex-1);
        //对分区右侧进行快排
        quickSort(arr,pivotIndex+1,end);
    }

    /**
     * 快排分区操作
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private int partion(int[] arr, int start, int end) {
        int pivotIndex = start;
        //默认使用数组尾部的数据作为基准点数据pivot
        int pivot = arr[end];
        for (int i=start; i< end;i++){
            if(arr[i] < pivot){
                if(i>pivotIndex){
                    swap(arr,pivotIndex,i);
                }
                pivotIndex++;
            }    
        }
        swap(arr,pivotIndex,end);
        return pivotIndex;
    }
    public void swap(int[] arr,int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    @Test
    public void testSort(){
        //准备一个int数组
        int[] array = new int[6];
        array[0] = 5;
        array[1] = 2;
        array[2] = 6;
        array[3] = 9;
        array[4] = 0;
        array[5] = 3;
        //进行排序
        System.out.println(Arrays.toString(array));
        quickSort(array,0,array.length-1);
        //输出排序结果
        System.out.println(Arrays.toString(array));
    }
}
