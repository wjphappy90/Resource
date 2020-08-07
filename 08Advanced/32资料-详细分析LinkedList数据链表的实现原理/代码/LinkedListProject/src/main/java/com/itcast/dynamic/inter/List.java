package com.itcast.dynamic.inter;

// 将arryList 和LinkedList中共性方法进行抽取->保证体系的完整性
public interface List<E> {

    int size();
    boolean isEmpty();
    boolean contains(E element);
    void add(E element);
    E get(int index);
    E set(int index,E element);
    void add(int index, E element);
    E remove(int index);
    int indexOf(E element);
    void clear();
    String toString();
}
