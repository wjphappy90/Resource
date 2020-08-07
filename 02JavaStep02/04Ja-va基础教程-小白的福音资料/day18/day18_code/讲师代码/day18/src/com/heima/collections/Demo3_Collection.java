package com.heima.collections;

public class Demo3_Collection {

	/**
	 * Collection
	 * 		List(存取有序,有索引,可以重复)
	 * 			ArrayList
	 * 				底层是数组实现的,线程不安全,查找和修改快,增和删比较慢
	 * 			LinkedList
	 * 				底层是链表实现的,线程不安全,增和删比较快,查找和修改比较慢
	 * 			Vector
	 * 				底层是数组实现的,线程安全的,无论增删改查都慢
	 * 			如果查找和修改多,用ArrayList
	 * 			如果增和删多,用LinkedList
	 * 			如果都多,用ArrayList
	 * 		Set(存取无序,无索引,不可以重复)
	 * 			HashSet
	 * 				底层是哈希算法实现
	 * 				LinkedHashSet
	 * 					底层是链表实现,但是也是可以保证元素唯一,和HashSet原理一样
	 * 			TreeSet
	 * 				底层是二叉树算法实现
	 * 			一般在开发的时候不需要对存储的元素排序,所以在开发的时候大多用HashSet,HashSet的效率比较高
	 * 			TreeSet在面试的时候比较多,问你有几种排序方式,和几种排序方式的区别
	 * Map
	 * 		HashMap
	 * 			底层是哈希算法,针对键
	 * 			LinkedHashMap
	 * 				底层是链表,针对键
	 * 		TreeMap
	 * 			底层是二叉树算法,针对键
	 * 		开发中用HashMap比较多
	 */
	public static void main(String[] args) {

	}

}
