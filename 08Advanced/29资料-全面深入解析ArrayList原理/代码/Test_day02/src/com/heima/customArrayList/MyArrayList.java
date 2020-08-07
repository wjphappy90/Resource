package com.heima.customArrayList;
/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 *
 * 自定义ArrayList 版本二
 *      成员变量
 *      构造方法
 *      添加方法
 *      简单扩容
 *      转换方法&测试
 *      修改&删除&测试
 *
 *      获取方法&测试
 *          根据索引获取元素
 *          获取集合的长度
 */
@SuppressWarnings("all")
public class MyArrayList<E> {
    //定义数组,用于存储集合的元素
    private Object[] elementData;
    //定义变量,用于记录数组的个数
    private int size;
    //定义空数组,用于在创建集合对象的时候给elementData初始化
    private Object[] emptyArray = {};
    //定义常量,用于记录集合的容量
    private final int DEFAULT_CAPACITY = 10;

    //构造方法
    public MyArrayList(){
        //给elementData初始化
        elementData = emptyArray;
    }

    //定义add方法
    public boolean add(E e){
        //将来再调用的时候需要判断是否需要扩容
        grow();
        //将元素添加到集合
        elementData[size++] = e;
        return true;
    }

    //简单扩容
    private void grow(){
        //判断集合存储元素的数组是否等于emptyArray
        if(elementData == emptyArray){
            //第一次扩容
            elementData = new Object[DEFAULT_CAPACITY];
        }

        //核心算法 1.5倍
        //如果size==集合存元素数组的长度,就需要扩容
        if(size == elementData.length){
            //先定义变量记录老容量
            int oldCapacity = elementData.length;
            //核心算法 1.5倍
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            //创建一个新的数组,长度就newCapacity
            Object[] obj = new Object[newCapacity];
            //拷贝元素
            System.arraycopy(elementData, 0, obj, 0, elementData.length);
            //把新数组的地址赋值给elementData
            elementData = obj;
        }
    }

    //转换方法
    public String toString(){
        //建议对集合进行判断,如果没有内容直接返回 "[]"
        if(size == 0){
            return "[]";
        }

        //创建StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        //循环遍历数组
        for (int i = 0; i < size; i++) {
            //判断i是否等于size-1
            if(i == size-1){
                //要追加元素,还需要追加]
                sb.append(elementData[i]).append("]");
            }else{
                sb.append(elementData[i]).append(",").append(" ");
            }
        }
        //把sb中的所有数据转成一个字符串,且返回
        return sb.toString();
    }

    //修改方法
    public E set(int index, E element) {
        //建议先对方法的参数索引进行判断
        checkIndex(index);
        //把index索引对应的元素取出来
        E value = (E) elementData[index];
        //替换元素
        elementData[index] = element;
        return value;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size){
            //制造一个异常
            throw  new IndexOutOfBoundsException("索引越界了!");
        }
    }

    //删除方法
    public E remove(int index) {
        //校验索引
        checkIndex(index);
        //取出元素
        E value = (E) elementData[index];
        //计算出要移动元素的个数
        int numMoved = size - index - 1;
        //判断要移动的个数是否大于0
        if (numMoved > 0){
            System.arraycopy(elementData, index+1, elementData, index, numMoved);
        }
        //把最后一个位置上的元素置为null
        elementData[--size] = null;
        return value;
    }

    //根据索引获取元素
    public E get(int index){
        //调用方法校验索引
        checkIndex(index);
        //直接从elementData数组中获取元素且返回
        return (E) elementData[index];
    }

    //获取集合的长度
    public int getSize(){
        return size;
    }
}
