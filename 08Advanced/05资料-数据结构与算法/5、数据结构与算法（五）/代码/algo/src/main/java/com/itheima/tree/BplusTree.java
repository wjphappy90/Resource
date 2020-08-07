package com.itheima.tree;

/**
 * B+树
 */
public class BplusTree {


    /**
     * B+树非叶子节点的定义
     * 其中m的值是实现计算好的，计算的依据是让所有信息的大小正好等于页的大小
     */
    private   class BplusNode{
        // m=5代表5叉树
        private int m = 5;
        //数据键值 用来划分数据区域
        private int[] key  = new int[m];
        
        //子节点指针数组
        private BplusNode[] childrens = new BplusNode[m];
    }
    
    /**
     * B+树叶子节点的定义
     * B+ 树中的叶子节点跟内部结点是不一样的,叶子节点存储的是值，而非区间。
     * 这个定义里，每个叶子节点存储 k=3 个数据行的键值及地址信息。
     * k值的大小是实现要计算的，计算的依据是让所有信息的大小正好等于页的大小
     */
    private class BplusLeafNode{
        private  int k = 3;
        //存储数据的键值
        private int[] key = new int[k];
        //存储真实数据的地址
        private long[] dataAddress = new long[k];
        
        private BplusLeafNode prev; //链表的前驱节点
        private BplusLeafNode next; //链表的后继节点
        
    }
}
