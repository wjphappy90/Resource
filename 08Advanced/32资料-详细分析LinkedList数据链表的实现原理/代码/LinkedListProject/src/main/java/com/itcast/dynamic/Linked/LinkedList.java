package com.itcast.dynamic.Linked;

import com.itcast.dynamic.abstractclass.AbstractList;

import java.util.List;

public class LinkedList<E> extends AbstractList<E>   {
    // 约定：我在说链表查找元素位置时，我还是将index 称之为索引
    private Node first;

    private static class Node<E> {
        Node<E> next;
        E element;

        public Node(Node next, E element) {
            this.next = next;
            this.element = element;
        }

    }



    @Override
    public E get(int index) {  // index = 2
        checkElementIndex(index);
        return node(index).element;
    }

    private void checkElementIndex(int index) {

        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(": Index: " + index + ", Size: " + size);
        }

    }

    private boolean isElementIndex(int index) {
        // 满足条件
        return index >= 0 && index < size;

    }

    private Node<E> node(int index) {
        Node x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    @Override
    public E set(int index, E element) {
        // 你在指定索引上去修改元素值是 element  ，原来返回原来的值
        // 1 .获得index 上的node 2.拿到原来的老值  3.去进行修改  4.return 原来的老值
        checkElementIndex(index);
        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }



    @Override
    public void add(int index, E element) {
          checkPostionIndex(index); // 0   index >= 0
          // 1. 获得 index -1 的Node  同时 还要获得 index 节点  去改变index- 1 上的next ，同时去  将next 节点的内存值 赋值给 新new 出来的Node

    if(index == 0){
        first = new Node(first,element);

    }else{
        Node<E> pre = node(index - 1);
        Node<E> next = pre.next;
        pre.next = new Node<E>(next,element);
    }
    size++;

}

    private void checkPostionIndex(int index) {
         if(!isPostionIndex(index)){
             throw new IndexOutOfBoundsException(": Index: " + index + ", Size: " + size);
         }
    }

    private boolean isPostionIndex(int index) {
         return index >= 0 && index <= size;
    }

    @Override
    public E remove(int index) {
        checkElementIndex(index);
        Node<E> oldNode = first;
        if(index == 0){
              first = first.next;
        }else {
            Node<E> pre = node(index - 1);
            oldNode = pre.next;
            pre.next = oldNode.next;
        }
        return oldNode.element;
    }

    @Override
    public int indexOf(E element) {
        //  查找有没有 element 元素，如果有返回 element 元素的索引，如果没有则返回-1   ==   Person (age  name)

        Node x = first;
        int index = 0;
        if (element == null) {

            for (Node i = x; i != null; i = i.next) {
                  if(element == i.element){
                        return index;
                  }
                  index ++;
            }
        } else {
            for (Node i = x; i != null; i = i.next) {
                if( element.equals(i.element)){
                    return index;
                }
                index ++;
            }
        }
        return -1;
    }

    @Override
    public void clear() {

        size = 0;
        // help gc
        first = null;


    }



        public String toString(){

            if(size == 0){
                return  "[]";
            }
            StringBuilder sb = new StringBuilder().append("[");
            Node x = first;
            for(Node i = x; i != null ; i = i.next){
                  sb.append(i.element);
                  if( i.next == null){
                          return sb.append("]").toString();
                  }
                  sb.append(",");
            }
            return  sb.toString();
        }

}
