package com.itcast.dynamic.Linked;

import com.itcast.dynamic.abstractclass.AbstractList;

public class LinkedList2<E> extends AbstractList<E> {
    // 约定：我在说链表查找元素位置时，我还是将index 称之为索引
    private Node first;
    private Node last;

    private static class Node<E> {
        Node<E> pre;
        Node<E> next;
        E element;

        public Node(Node pre, Node next, E element) {
            this.pre = pre;
            this.next = next;
            this.element = element;
        }
    }


    @Override
    public E get(int index) {   // 要查找的元素 index >= 0 ,index < size
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
        // 先去判断要查找的index 是靠近头还是靠近尾，如果靠近头，从头开始找，如果靠近尾巴，从尾开始
        if (index > size >> 1) {
            // 靠近尾
            x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.pre;
            }
        } else {
            //靠近头
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
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
       // 1.  获得指定的index  2.前一个节点的获取， 3 构建新的now -> 完成指向关系 4.改变1,2的指向

        if(index == size){
             // 1. 添加到末尾 ||  2.没有元素的时候
            linkLast(element);
        }else{
           linkBefore(element,node(index));
        }
        size++;
    }

    private void linkLast(E element) {
          //拿到last 节点
          // 构建node  完成他的指向关系
         //3 将原来的last 节点的next 修改成 新构建出来的node
         //4 将链表的last 进行修改
         Node l = last;
         Node  newNode = new Node(l,null,element);
         last = newNode;
         if( l == null)
               first = newNode;
          else
             l.next = newNode;
    }

    private void linkBefore(E element,Node node) {

        Node<E> pre = node.pre; // null
        Node<E> newNode =  new Node(pre,node,element);
        node.pre = newNode;
        if(pre == null){
            first = newNode;
        }else{
            pre.next =newNode;
        }
    }


    private void checkPostionIndex(int index) {
        if (!isPostionIndex(index)) {
            throw new IndexOutOfBoundsException(": Index: " + index + ", Size: " + size);
        }
    }

    private boolean isPostionIndex(int index) {
        return index >= 0 && index <= size;
    }

    @Override
    public E remove(int index) {
        checkElementIndex(index);  // index >= 0 && index <  size
        /*Node<E> oldNode = first;
        if (index == 0) {
            first = first.next;
        } else {
            Node<E> pre = node(index - 1);
            oldNode = pre.next;
            pre.next = oldNode.next;
        }
        size-- ;*/
        Node<E> node = node(index);
        Node<E> pre = node.pre;
        Node<E> next = node.next;

        if(pre == null){
            // 1. first 进行修改
            first = next;
            //  2.
            next.pre = null;

        }else{
            pre.next = next;
        }

        if(next == null){
            last = pre;
        }else{
            next.pre = pre;
        }

        size -- ;


        return node.element;

    }

    @Override
    public int indexOf(E element) {
        //  查找有没有 element 元素，如果有返回 element 元素的索引，如果没有则返回-1   ==   Person (age  name)

        Node x = first;
        int index = 0;
        if (element == null) {

            for (Node i = x; i != null; i = i.next) {
                if (element == i.element) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node i = x; i != null; i = i.next) {
                if (element.equals(i.element)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @Override
    public void clear() {

        size = 0;
        // help gc
        first = null;

        last = null;


    }


    public String toString() {

        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder().append("[");
        Node x = first;
        for (Node i = x; i != null; i = i.next) {
            sb.append(i.element);
            if (i.next == null) {
                return sb.append("]").toString();
            }
            sb.append(",");
        }
        return sb.toString();
    }

}
