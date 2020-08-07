package com.itcast.dynamic.arr;

import com.itcast.dynamic.abstractclass.AbstractList;

//自己实现的ArrayList
public class ArrayList <E>  extends AbstractList<E> {

    private E[] elementData;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    private void rangeCheck(int index) {
        if (index < 0 || index > this.size) {
            throw new RuntimeException("Index: " + index + ",  Size:" + size);
        }
    }

    public ArrayList(int capacity) {

        capacity = capacity < DEFAULT_CAPACITY ? DEFAULT_CAPACITY : capacity;
        elementData = (E[]) new Object[capacity];
    }






    public void add(E element) {

    }







    public E get(int index) {
        rangeCheck(index);
        return elementData[index];
    }


    public E set(int index, E element) {

        rangeCheck(index);
        E oldResult = elementData[index];
        elementData[index] = element;
        return oldResult;
    }



    public void add(int index, E element) {
        rangeCheck(index);

        ensureCapacityInternal(size + 1);
        for (int i = size - 1; i >= index; i--) {
            elementData[i + 1] = elementData[i];
        }
        elementData[index] = element;
        size++;

    }



    private void ensureCapacityInternal(int capacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity >= capacity) return;

        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElement = (E[]) new Object[newCapacity];
        for (int i = 0; i < oldCapacity; i++) {
            newElement[i] = elementData[i];
        }
        elementData = newElement;
        System.out.println("扩容了old" + oldCapacity + "新的" + newCapacity);
    }

    public E remove(int index) {
        rangeCheck(index);
        E old = elementData[index];
        for (int i = index + 1; i < size; i++) {
            elementData[i - 1] = elementData[i];
        }
        elementData[--size] = null;

        return old;
    }

    /**
     * @Description 找到了就返回对应的索引i，没找到就返回-1
     * @Param
     * @Return
     */
    public int indexOf(E element) {

        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == element) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elementData[i])) return i;
            }
        }
        return -1;
    }

    public void clear() {
        // help GC
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }



}

