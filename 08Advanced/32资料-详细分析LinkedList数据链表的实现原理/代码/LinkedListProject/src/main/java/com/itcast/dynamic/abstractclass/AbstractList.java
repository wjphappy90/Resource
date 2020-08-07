package com.itcast.dynamic.abstractclass;

import com.itcast.dynamic.inter.List;

// 用于实现 LinkedList 和ArrayList 中那些共性方法
public abstract class AbstractList<E> implements List<E> {

    protected int size;

    @Override
    public int size() {
        return size;
    }

    // 判断当前集合中是否有元素
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(E element) {

        add(size,element);

    }

    //indexOf : 去寻找对应的元素，如果找到了返回元素的索引，如果没找到返回一个-1
    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1 ;
    }

}
