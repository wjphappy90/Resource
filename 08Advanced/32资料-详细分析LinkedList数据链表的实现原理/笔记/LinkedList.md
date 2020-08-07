# 链表

### 课程安排

* 链表的介绍

* 手写单链表&双链表

* LinkedList 源码阅读

* LinkedList 并发修改异常

* LinkedList 多线程安全问题的产生和解决

  

### 一、ArrayList引发的思考

* 优点：查询快

* 缺点

  ​    1、增删慢，消耗cpu的性能

  ​               情况一、指定索引上的添加

  ​               情况二、如果原数组中的元素已经不够了

​            2、比较浪费内存空间

* 有没有一种数据结构可以用多少个空间就申请多少个空间，并且又能够提高他的增删速度呢？

###  二、链表

链表的分类：单链表，双链表，循环链表

* 链表：由链将一个个元素连接，每一个元素我们通常将其称之为Node 节点

* Node 节点：由两部分组成  
  
  * 数据值的变量
  * Node next 用来存放下一个节点的Node 对象
  
  

```java
public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(); //双向链表
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        System.out.println(linkedList);
    }
}
```

* 链表和数组的区别
  *  链表查询慢（因为链表没有索引），但是增删快，

 



### 三、自定义单向链表

设计接口

目的：为了体系的完整，以及代码的复用，设计出以下结构

需要实现的方法

```java
public int size();
public boolean isEmpty();
public boolean contains(E element);
public void add(E element);
public E get(int index);
public E set(int index,E element);
public void add(int index, E element);
public E remove(int index);
public int indexOf(E element);
public void clear();
public String toStrin();
```



#### 3.1 List 接口

包含共性的方法

```java
public interface List<E>{
    int size()
    boolean isEmpty()
    boolean contains(E element)
    void add(E element)
    E get(int index)
    E set(int index,E element)
    void add(int index, E element)
    E remove(int index)
    int indexOf(E element)
    void clear()
}

```

#### 3.2 AbstractList 抽象类

实现共性的方法，实现List

```java
public abstract class AbstractList implements List<E>{
     int size;
     int size(){
     }
     boolean isEmpty(){
         
     }
     boolean contains(E element){
         
     }
    // add方法都会调用 add(int index,E element)
     void add(E element) {
         
     }   
    
}


public class LinkedList <E> extends AbstractList<E> {
    
 	 //... 重写其他方法

}



```

将ArrayList 和 LinkedList 都  继承AbstractList

#### 3.3 实现

AbstractList

```java
   public abstract class AbstractList<E> implements List<E>{ 
   protected  int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    @Override
    public void add(E element) {

        add(size,element);
    }
   }

```

LinkedList 实现

顺序：

* 定义结构

* get -> node

* indexOf(E element)

* set(int index, E element)

* clear()

* add

* remove

* toString

  

```java
public class LinekdList<E> extends AbstractList<E> {
    
     public Node<E> first;
     private static class Node<E> {
        Node<E> next;
        Node<E> pre;
        E element;

        public Node(Node<E> next, E element, Node<E> pre) {
            this.next = next;
            this.element = element;
            this.pre = pre;
        }
    }
    
    private Node<E> node(int index) {

        Node x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }
    
    @Override
    public E get(int index) {
        return node(index).element;
    }
    
    @Override
    public int indexOf(E element) {

        Node x = first;
        int index = 0;
        if (element == null) {
            for (Node i = first; i != null; i = i.next) {
                if (element == i.element) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node i = first; i != null; i = i.next) {
                if (element.equals(i.element)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }
    
     @Override
    public E set(int index, E element) {

        Node<E> node = node(index);
        // 记录原来的老值
        E oldElement = node.element;
        // 將传入的值进行覆盖
        node.element = element;

        return oldElement;
    }
    
     @Override
    public void clear() {

        size = 0;
        first = null;

    }
    
    @Override
    public void add(int index, E element) {

        checkPostionIndex(index);
        if (index == 0) {
            first = new Node(first, element);
        } else {
            Node<E> pre = node(index - 1);
            Node next = pre.next;
            pre.next = new Node(next, element);
        }
    }

    @Override
    public E remove(int index) {

        checkElementIndex(index);
        Node<E> node = first;
        if (index == 0) {
            first = node.next;

        } else {
            Node<E> pre = node(index - 1);
            node = pre.next;
            pre.next = node.next;
        }
    }
    
    public String toString() {

        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Node i = first; i != null; i = i.next) {
            sb.append(i.element);
            if (i.next == null) {
                return sb.append("]").toString();
            }
            sb.append(",").toString();
        }
        return sb.toString();
    }
    
     private void checkElementIndex(int index) {

        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }
    
     private void checkPostionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }   

}
```

### 四、将单链表改造成双向链表

####  4.1 双向链表

可以从前指向后，也可以从后去指向前

LinkedList 内部  size  first  last    

以及Node

​			  E element

​			  Node next

​         	 Node  pre



双向链表遍历效率可能优于单向链表

原因：双向链表可以在查找元素时，判断靠近头还是靠近尾，如果靠近头从头开始找，如果靠近尾从尾开始找

####  4.2 双向链表的实现

* add方法

```
public void add(int index, E element) {
checkPostionIndex(index); // 0   index >= 0
if(index == size){
     // 1. 添加到末尾 ||  2.没有元素的时候
    linkLast(element);
}else{
   linkBefore(element,node(index));
}
size++;

private void linkLast(E element) {
      Node l = last;
      Node  newNode = new Node(l,null,element);
      last = newNode;
      if( l == null){
         first = newNode;
      }else{
         l.next = newNode;
      }
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
    
```



* 删除方法

```
public E remove(int index) {
checkElementIndex(index);  
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
```

* clear

```
public void clear() {
    size = 0;
    first = null;
    last = null;
}
```



### 五、LinkedList 源码

* 并发修改异常

```
private class ListItr implements ListIterator<E> {
    private Node<E> lastReturned;
    private Node<E> next;
    private int nextIndex;
    private int expectedModCount = modCount;

    ListItr(int index) {
        //初始化时index == 0  ，此时返回的是对应的0 号节点
        next = (index == size) ? null : node(index);
        // nextIndex = 0 ，代表下一次要去遍历的角标
        nextIndex = index;
    }

    public boolean hasNext() 
        // 判断是否需要去取下一个元素
        return nextIndex < size;
    }

    public E next() {
        checkForComodification();
        if (!hasNext())
            throw new NoSuchElementException();
		// 将0号节点的数据赋值给lastReturned
        lastReturned = next;
        // 取下一个节点元素
        next = next.next;
        // 记录这次操作
        nextIndex++;
        return lastReturned.item;
    }

    public boolean hasPrevious() {
        return nextIndex > 0;
    }
```

* 测试并发修改异常

```
public class TestLinkedList {

    public static void main(String[] args) {

        LinkedList  linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        //nextIndex ： 0     next  第一号节点元素
        //lastReturned 记录返回值的对象
        // private int expectedModCount = modCount; 将记录链表长度发生变化次数的记录值赋值给 期望值 ->  程序在初始化的时候，那么他们一定是相等的
        //Iterator iterator = linkedList.iterator();
        ListIterator iterator = linkedList.listIterator();
        while (iterator.hasNext()){
            //hashNext  遍历链表长度的次数
            iterator.add(10);
            System.out.println(iterator.next());
        }
       // System.out.println(linkedList);
    }
}
```

## 六、 多线程LinkedList 不安全情况

```
public class LInkedListThread {
    public static void main(String[] args) {

       /* LinkedList<String> linkedList = new LinkedList();
        Collection  ts = Collections.synchronizedCollection(linkedList);*/
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue(); // cas 无锁化机制  volatile 关键字来解决的

        for (int i = 0; i < 4; i++) {
              new Thread(new Runnable() {
                  @Override
                  public void run() {
                      concurrentLinkedQueue.add(UUID.randomUUID().toString().substring(0,10));
                      System.out.println(concurrentLinkedQueue);
                  }
              }).start();
        }
    }
}
```











