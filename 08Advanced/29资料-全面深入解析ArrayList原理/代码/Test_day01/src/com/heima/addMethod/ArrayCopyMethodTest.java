package com.heima.addMethod;

import java.util.Arrays;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 *
 * System类 arraycopy方法
 * 参数
    src - 源数组。
    srcPos - 源数组中的起始位置。
    dest - 目标数组。
    destPos - 目的地数据中的起始位置。
    length - 要复制的数组元素的数量。

    public static void arraycopy​(Object src,int srcPos,Object dest,int destPos,int length)

    分析如何计算拷贝位置
 */
public class ArrayCopyMethodTest {
    public static void main(String[] args) {
        //数据源: list
        String[] a = {"黑马程序员","传智播客","传智大学"};
        //数据目的: list1
        String[] arr = {"酷丁鱼","博学谷",null,null,null,null,null,null,null,null};
        /*
        int numNew = a.length;
        int numMoved = size - index;
        if (numMoved > 0)
            System.arraycopy(elementData, index, elementData, index + numNew,
                             numMoved);
         */
        //获取数据源的长度 3
        int numNew = a.length;
        //numMoved = 集合真实长度 - 要存的索引位置
        //要移动元素的个数为:1
        int numMoved = 2 - 1;
        //判断是否需要移动元素
        if (numMoved > 0)
            //src - 源数组。
            //srcPos - 源数组中的起始位置。
            //dest - 目标数组。
            //destPos - 目的地数据中的起始位置。
            //length - 要复制的数组元素的数量
            System.arraycopy(arr, 1, arr, 4,
                    numMoved);

        System.out.println(Arrays.toString(arr));
    }
}
