package com.itheima.ds_project01._04_stack;

class ArrayStack {
    // 栈大小
    private int size;
    // 默认栈容量
    private int DEFAULT_CAPACITY=10;
    // 栈数据
    private Object[] elements;

    private int MAX_ARRAY_SIZE  = Integer.MAX_VALUE-8;

    /**
     * 默认构造创建大小为10的栈
     */
    public ArrayStack(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * 通过指定大小创建栈
     * @param capacity
     */
    public ArrayStack(int capacity){
        elements = new Object[capacity];
    }

    /**
     * 入栈
     * @param element
     * @return
     */
    public boolean push(Object element){
        try {
            checkCapacity(size+1);
            elements[size++]=element;
            return true;
        }catch (RuntimeException e){
            return false;
        }
    }

    /**
     * 检查栈容量是否还够
     */
    private void checkCapacity(int minCapacity) {
        if(elements.length - minCapacity < 0 ){
            throw  new RuntimeException("栈容量不够!");
        }
    }

    /**
     * 出栈
     * @return
     */
    public Object pop(){
        if(size<=0){
            return null;//栈为空则直接返回null
        }
        Object obj = elements[size-1];
        elements[--size] = null;
        return obj;
    }

    /**
     * 获取栈的大小
     * @return
     */
    public int size(){
        return size;
    }

}
