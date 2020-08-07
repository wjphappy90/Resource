# day06【Map】

## 主要内容
-  Map集合  ，Collection集合
   -  键值对集合，用的也很多。
   -  Collection集合（单列集合，一个元素只能一个值。）
   -  Map集合（双列集合，一个元素有2个值，每个元素叫键值对象，元素格式必须是：key=value）
   -  **List<String> names = new ArrayList<>();**
   -  **Set<Student> names = new HashSet<>();**
   -  **Map<String , String> names = new HashMap<>()；**
-  图书管理系统(用的代码！)
   -  让我们把集合和Map集合都用起来，然后引入一些业务思维做一个综合性的案例！
-  Debug调试。(非常重要的排错手段)
   -  bug

## 教学目标
- [ ] 能够使用集合工具类

  ```java
   Collections下的API:
      1、public static <T> boolean addAll(Collection<? super T> c, T... elements)
          -- 参数一：操作的集合对象。
                  -- 参数二：可变参数，给集合批量加的元素值。
              2、public static void shuffle(List<?> list)：
                  -- 打乱List集合的顺序
              3、public static <T extends Comparable<? super T>> void sort(List<T> list)
          -- 给List集合进行默认的升序排序。默认只能由小到大。
                  -- 有值特性的，按照值特性排序。
                  -- 对于字符串按照首字母的编号排序！
                  -- 此方法默认不能给引用类型的对象做排序，因为人家不知道你的排序规则！
              4、public static <T> void sort(List<T> list,Comparator<? super T> c)
          -- 参数一：被排序的集合对象。
                  -- 参数二：比较器对象，用于程序员来定制大小排序规则。
  ```

- [ ] 能够使用Comparator比较器进行排序

  ```java
    		Student s1 = new Student("张三丰",100,'男');
          Student s2 = new Student("张无忌",32,'男');
          Student s3 = new Student("赵敏",22,'女');
          Student s4 = new Student("殷素素",45,'女');
  
          List<Student> stus = new ArrayList<>();
          Collections.addAll(stus ,  s1 , s2 , s3 , s4);
  	    Collections.sort(stus, new Comparator<Student>() {
              @Override
              public int compare(Student o1, Student o2) {
                  // Collections集合工具类会自动提取集合中的两两对象送进来让程序员自己来比较。
                  // o1  s1 = new Student("张三丰",100,'男');
                  // o2  s2 = new Student("张无忌",32,'男');
                  // 如果认为 o1 > o2 应该返回正整数
                  // 如果认为 o1 < o2 应该返回负整数
                  // 如果认为 o1 = o2 应该返回0
  //                if(o1.getAge() > o2.getAge()){
  //                    return  1;
  //                }else if(o1.getAge() < o2.getAge()){
  //                    return -1;
  //                }
  //                return 0;
                  return o1.getAge() - o2.getAge();
              }
          });
  ```

- [ ] 能够使用可变参数

  ```properties
  可变参数的作用：
      可变参数可以用在方法，构造器等形参中，用于接收多个数据。
  可变参数的格式：数据类型... 变量名称
  可变参数在内部本质上就是一个数组！！
  可变参数的优点：参数传输非常的灵活！！
  
  可变参数的注意事项：
      1.一个形参列表中只能有一个可变参数。
      2.可变参数必须放在形参列表的最后面。
  ```

- [ ] 能够理解冒泡排序的原理

  ```properties
  冒泡排序的核心点：每次两两比较找出当前最大值冒出到当前最后面即可！！
  ```

- [ ] 能够说出Map集合特点

  ```properties
  Map集合的特点：
      1.Map集合的特点都是由键决定的。
      2.Map集合的键是无序,不重复的，无索引的。
          Map集合后面重复的键对应的元素会覆盖前面的整个元素的值！
      3.Map集合的值无要求。
      4.Map集合的键值对都可以为null。
  ```

- [ ] 使用Map集合添加方法保存数据

  ```java
  maps.put("iphoneX" , 1);
  ```

- [ ] 使用”键找值”的方式遍历Map集合

  ```java
  // a.先提取Map集合全部的键到一个Set集合中去
  // keys = [huawei, Java, iphoneX, 娃娃]
  Set<String> keys = maps.keySet();
  System.out.println(keys);
  
  // b.再遍历全部键，通过键获取对应的值
  for(String key : keys){
      // 通过键取对应值
      Integer value = maps.get(key);
      System.out.println(key+"---->"+value);
  }
  ```

- [ ] 使用”键值对”的方式遍历Map集合

  ```java
  /**
      maps = {huawei=8, Java=1, iphoneX=1, 娃娃=8}
      最开始是想直接用foreach遍历Map集合
      发现foreach根本不能直接遍历Map集合，Map集合的键值对元素直接来看是没有类型的。
  
          ↓
  
      可以把Map集合通过如下API转换成一个Set集合。
          -- Set<Map.Entry<K, V>> entrySet()
          -- entrySet = [(huawei=8), (Java=1), (iphoneX=1), (娃娃=8)]
          --   entry
          -- 此时该Set集合中的键值对元素成为一个整体，有了类型，
              类型叫键值对实体类型：Map.Entry<String,Integer>
          ↓
      此时就可以通过foreach遍历entrySet集合了!
   */
   Set<Map.Entry<String, Integer>> entrySet = maps.entrySet();
   for(Map.Entry<String,Integer> entry : entrySet){
       String key = entry.getKey();
       Integer value = entry.getValue();
       System.out.println(key+"-->"+value);
   }
  ```

- [ ] 能够使用HashMap存储自定义键值对的数据

  ```java
  // 学生对象作为键的类型，值用字符串表示地址信息
  Map<Student , String> maps = new HashMap<>();
  maps.put(new Student("欧世杰",18,'男') , "广州");
  maps.put(new Student("林志玲",41,'女') , "日本");
  maps.put(new Student("林志玲",41,'女') , "日本");
  maps.put(new Student("古天乐",41,'男') , "香港");
  ```

- [ ] 能够理解图书管理系统案例

  ```properties
  参见代码！
  ```

# 第一章 Map集合

## 1.1 概述

现实生活中，我们常会看到这样的一种集合：IP地址与主机名，身份证号与个人，系统用户名与系统用户对象等，这种一一对应的关系，就叫做映射。Java提供了专门的集合类用来存放这种对象关系的对象，即`java.util.Map`接口。

我们通过查看`Map`接口描述，发现`Map`接口下的集合与`Collection`接口下的集合，它们存储数据的形式不同，如下图。

![](imgs/Collection%E4%B8%8EMap.bmp)

- `Collection`中的集合，元素是孤立存在的（理解为单身），向集合中存储元素采用一个个元素的方式存储。
- `Map`中的集合，元素是成对存在的(理解为夫妻)。每个元素由键与值两部分组成，通过键可以找对所对应的值。
- `Collection`中的集合称为单列集合，`Map`中的集合称为双列集合。
- 需要注意的是，`Map`中的集合不能包含重复的键，值可以重复；每个键只能对应一个值。

## 1.2  Map的常用子类

通过查看Map接口描述，看到Map有多个子类，这里我们主要讲解常用的HashMap集合、LinkedHashMap集合。

- **HashMap<K,V>**：存储数据采用的哈希表结构，元素的存取顺序不能保证一致。由于要保证键的唯一、不重复，需要重写键的hashCode()方法、equals()方法。
- **LinkedHashMap<K,V>**：HashMap下有个子类LinkedHashMap，存储数据采用的哈希表结构+链表结构。通过链表结构可以保证元素的存取顺序一致；通过哈希表结构可以保证的键的唯一、不重复，需要重写键的hashCode()方法、equals()方法。
- **TreeMap<K,V>**：TreeMap集合和Map相比没有特有的功能，底层的数据结构是红黑树；可以对元素的***键***进行排序，排序方式有两种:**自然排序**和**比较器排序**

> tips：Map接口中的集合都有两个泛型变量<K,V>,在使用时，要为两个泛型变量赋予数据类型。两个泛型变量<K,V>的数据类型可以相同，也可以不同。

## 1.3  Map的常用方法

Map接口中定义了很多方法，常用的如下：

- `public V put(K key, V value)`:  把指定的键与指定的值添加到Map集合中。
- `public V remove(Object key)`: 把指定的键 所对应的键值对元素 在Map集合中删除，返回被删除元素的值。
- `public V get(Object key)` 根据指定的键，在Map集合中获取对应的值。
- `public Set<K> keySet()`: 获取Map集合中所有的键，存储到Set集合中。
- `public Set<Map.Entry<K,V>> entrySet()`: 获取到Map集合中所有的键值对对象的集合(Set集合)。
- `public boolean containKey(Object key)`:判断该集合中是否有此键。

Map接口的方法演示

```java
public class MapDemo {
    public static void main(String[] args) {
        //创建 map对象
        HashMap<String, String>  map = new HashMap<String, String>();

        //添加元素到集合
        map.put("黄晓明", "杨颖");
        map.put("文章", "马伊琍");
        map.put("邓超", "孙俪");
        System.out.println(map);

        //String remove(String key)
        System.out.println(map.remove("邓超"));
        System.out.println(map);

        // 想要查看 黄晓明的媳妇 是谁
        System.out.println(map.get("黄晓明"));
        System.out.println(map.get("邓超"));    
    }
}
```

> tips:
>
> 使用put方法时，若指定的键(key)在集合中没有，则没有这个键对应的值，返回null，并把指定的键值添加到集合中； 
>
> 若指定的键(key)在集合中存在，则返回值为集合中键对应的值（该值为替换前的值），并把指定键所对应的值，替换成指定的新值。 

## 1.4   Map的遍历

### 方式1:键找值方式

通过元素中的键，获取键所对应的值

分析步骤：

1. 获取Map中所有的键，由于键是唯一的，所以返回一个Set集合存储所有的键。方法提示:`keyset()`
2. 遍历键的Set集合，得到每一个键。
3. 根据键，获取键所对应的值。方法提示:`get(K key)`

遍历图解：

![](imgs/Map%E9%9B%86%E5%90%88%E9%81%8D%E5%8E%86%E6%96%B9%E5%BC%8F%E4%B8%80.bmp)

- 

### 方式2:键值对方式

即通过集合中每个键值对(Entry)对象，获取键值对(Entry)对象中的键与值。

**Entry键值对对象:**

我们已经知道，`Map`中存放的是两种对象，一种称为**key**(键)，一种称为**value**(值)，它们在在`Map`中是一一对应关系，这一对对象又称做`Map`中的一个`Entry(项)`。`Entry`将键值对的对应关系封装成了对象。即键值对对象，这样我们在遍历`Map`集合时，就可以从每一个键值对（`Entry`）对象中获取对应的键与对应的值。

在Map集合中也提供了获取所有Entry对象的方法：

- `public Set<Map.Entry<K,V>> entrySet()`: 获取到Map集合中所有的键值对对象的集合(Set集合)。

 获取了Entry对象 , 表示获取了一对键和值，那么同样Entry中 , 分别提供了获取键和获取值的方法：

- `public K getKey()`：获取Entry对象中的键。
- `public V getValue()`：获取Entry对象中的值。

操作步骤与图解：

1. 获取Map集合中，所有的键值对(Entry)对象，以Set集合形式返回。方法提示:`entrySet()`。
2. 遍历包含键值对(Entry)对象的Set集合，得到每一个键值对(Entry)对象。
3. 通过键值对(Entry)对象，获取Entry对象中的键与值。  方法提示:`getkey() getValue()`     

遍历图解：

![](../../../%E5%9F%BA%E7%A1%80%E5%8A%A0%E5%BC%BA%E8%AF%BE%E6%94%B9/day01-day15%E8%AE%B2%E4%B9%89-MD/day06-Collections,Set,Map,%E6%96%97%E5%9C%B0%E4%B8%BB%E6%8E%92%E5%BA%8F/img/Map%E9%9B%86%E5%90%88%E9%81%8D%E5%8E%86%E6%96%B9%E5%BC%8F%E4%BA%8C.bmp)

> tips：Map集合不能直接使用迭代器或者foreach进行遍历。但是转成Set之后就可以使用了。

## 1.5  HashMap存储自定义类型

练习：每位学生（姓名，年龄）都有自己的家庭住址。那么，既然有对应关系，则将学生对象和家庭住址存储到map集合中。学生作为键, 家庭住址作为值。

> 注意，学生姓名相同并且年龄相同视为同一名学生。

编写学生类：

```java
public class Student {
    private String name;
    private int age;

    //构造方法
    //get/set
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
```

编写测试类：

```java 
public class HashMapTest {
    public static void main(String[] args) {
        //1,创建Hashmap集合对象。
        Map<Student,String> map = new HashMap<Student,String>();
        //2,添加元素。
        map.put(new Student("lisi",28), "上海");
        map.put(new Student("wangwu",22), "北京");
        map.put(new Student("wangwu",22), "南京");
        
        //3,取出元素。键找值方式
        Set<Student> keySet = map.keySet();
        for(Student key: keySet){
            String value = map.get(key);
            System.out.println(key.toString()+"....."+value);
        }
    }
}
```

- 当给HashMap中存放自定义对象时，如果自定义对象作为key存在，这时要保证对象唯一，必须复写对象的hashCode和equals方法(如果忘记，请回顾HashSet存放自定义对象)。
- 如果要保证map中存放的key和取出的顺序一致，可以使用`java.util.LinkedHashMap`集合来存放。

## 1.6   LinkedHashMap介绍

我们知道HashMap保证成对元素唯一，并且查询速度很快，可是成对元素存放进去是没有顺序的，那么我们要保证有序，还要速度快怎么办呢？

在HashMap下面有一个子类LinkedHashMap，它是链表和哈希表组合的一个数据存储结构。

```java
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("邓超", "孙俪");
        map.put("李晨", "范冰冰");
        map.put("刘德华", "朱丽倩");
        Set<Entry<String, String>> entrySet = map.entrySet();
        for (Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }
    }
}
```

结果:

```
邓超  孙俪
李晨  范冰冰
刘德华  朱丽倩
```

## 1.7 TreeMap集合

### 1.TreeMap介绍

TreeMap集合和Map相比没有特有的功能，底层的数据结构是红黑树；可以对元素的***键***进行排序，排序方式有两种:**自然排序**和**比较器排序**；到时使用的是哪种排序，取决于我们在创建对象的时候所使用的构造方法；

```java
public TreeMap()									使用自然排序
public TreeMap(Comparator<? super K> comparator) 	比较器排
```

### 2.演示

案例演示**自然排序**

```java
public static void main(String[] args) {
 	TreeMap<Integer, String> map = new TreeMap<Integer, String>();
  	map.put(1,"张三");
  	map.put(4,"赵六");
  	map.put(3,"王五");
  	map.put(6,"酒八");
  	map.put(5,"老七");
  	map.put(2,"李四");
  	System.out.println(map);
}

控制台的输出结果为:
{1=张三, 2=李四, 3=王五, 4=赵六, 5=老七, 6=酒八}
```

案例演示**比较器排序**

**需求:**

1. 创建一个TreeMap集合，键是学生对象(Student)，值是居住地 (String)。存储多个元素，并遍历。
2. 要求按照学生的年龄进行升序排序，如果年龄相同，比较姓名的首字母升序， 如果年龄和姓名都是相同，认为是同一个元素；

 **实现:**

为了保证age和name相同的对象是同一个,Student类必须重写hashCode和equals方法

```java
public class Student {
    private int age;
    private String name;
	//省略get/set..
    public Student() {}
    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
```

```java
public static void main(String[] args) {
  	TreeMap<Student, String> map = new TreeMap<Student, String>(new Comparator<Student>() {
    	@Override
    	public int compare(Student o1, Student o2) {
      		//先按照年龄升序
      		int result = o1.getAge() - o2.getAge();
      		if (result == 0) {
        		//年龄相同,则按照名字的首字母升序
        		return o1.getName().charAt(0) - o2.getName().charAt(0);
      		} else {
        		//年龄不同,直接返回结果
        		return result;
      		}
    	}
  	});
  	map.put(new Student(30, "jack"), "深圳");
  	map.put(new Student(10, "rose"), "北京");
  	map.put(new Student(20, "tom"), "上海");
  	map.put(new Student(10, "marry"), "南京");
  	map.put(new Student(30, "lucy"), "广州");
  	System.out.println(map);
}
控制台的输出结果为:
{
  Student{age=10, name='marry'}=南京, 
  Student{age=10, name='rose'}=北京, 
  Student{age=20, name='tom'}=上海, 
  Student{age=30, name='jack'}=深圳, 
  Student{age=30, name='lucy'}=广州
}
```

## 1.8 Map集合练习

**需求：**

输入一个字符串中每个字符出现次数。

**分析：**

1. 获取一个字符串对象
2. 创建一个Map集合，键代表字符，值代表次数。
3. 遍历字符串得到每个字符。
4. 判断Map中是否有该键。
5. 如果没有，第一次出现，存储次数为1；如果有，则说明已经出现过，获取到对应的值进行++，再次存储。     
6. 打印最终结果

**方法介绍**

`public boolean containKey(Object key)`:判断该集合中是否有此键。

**代码：**

```java
public class MapTest {
public static void main(String[] args) {
        //友情提示
        System.out.println("请录入一个字符串:");
        String line = new Scanner(System.in).nextLine();
        // 定义 每个字符出现次数的方法
        findChar(line);
    }
    private static void findChar(String line) {
        //1:创建一个集合 存储  字符 以及其出现的次数
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        //2:遍历字符串
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            //判断 该字符 是否在键集中
            if (!map.containsKey(c)) {//说明这个字符没有出现过
                //那就是第一次
                map.put(c, 1);
            } else {
                //先获取之前的次数
                Integer count = map.get(c);
                //count++;
                //再次存入  更新
                map.put(c, ++count);
            }
        }
        System.out.println(map);
    }
}
```

# 第二章  模拟斗地主洗牌发牌

## 2.1 案例介绍

按照斗地主的规则，完成洗牌发牌的动作。

![](imgs/%E6%96%97%E5%9C%B0%E4%B8%BB.png)

具体规则：

1. 组装54张扑克牌
2. 54张牌顺序打乱
3. 三个玩家参与游戏，三人交替摸牌，每人17张牌，最后三张留作底牌。
4. 查看三人各自手中的牌（按照牌的大小排序）、底牌

> 规则：手中扑克牌从大到小的摆放顺序：大王,小王,2,A,K,Q,J,10,9,8,7,6,5,4,3

## 2.2 案例需求分析

1.准备牌：

完成数字与纸牌的映射关系：

使用双列Map(HashMap)集合，完成一个数字与字符串纸牌的对应关系(相当于一个字典)。

2.洗牌：

通过数字完成洗牌发牌

3.发牌：

将每个人以及底牌设计为ArrayList<String>,将最后3张牌直接存放于底牌，剩余牌通过对3取模依次发牌。

存放的过程中要求数字大小与斗地主规则的大小对应。

将代表不同纸牌的数字分配给不同的玩家与底牌。

4.看牌：

通过Map集合找到对应字符展示。

通过查询纸牌与数字的对应关系，由数字转成纸牌字符串再进行展示。

![](img/%E6%96%97%E5%9C%B0%E4%B8%BB%E5%88%86%E6%9E%90.png)

## 2.3  实现代码步骤

```java
package com.itheima04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
 * 组合牌
 * 	  定义一个Map集合用来存储牌号  和 牌 
 * 	  定义一个List集合用来存储牌号
 * 	 花色:♥-♠-♦-♣
 * 	 数字:2-A-K-Q-J-10-9-8-7-6-5-4-3
 * 洗牌
 * 		Collections.shuffle(牌号集合)
 * 发牌
 * 		三个玩家三个集合
 * 		发牌号 
 * 排序
 * 看牌
 */
public class Pooker {

	public static void main(String[] args) {
		// 定义一个Map集合用来存储牌号  和 牌 
		Map<Integer, String> pookerMap = new HashMap<Integer, String>();
		//定义一个List集合用来存储牌号
		ArrayList<Integer> pookerList = new ArrayList<Integer>();
		
		String[] colors = "♥-♠-♦-♣".split("-");
		String[] nums = "2-A-K-Q-J-10-9-8-7-6-5-4-3".split("-");
		
		
		int index = 2;
		for(String num : nums){
			for(String color : colors){
				String thisPooker = color+num;
//				System.out.println(thisPooker);
				//将扑克牌放入Map集合
				pookerMap.put(index, thisPooker);
				//将牌号放入到pookerList集合中
				pookerList.add(index);
				index++;
			}
		}
		
		
		//将大王小王添加到集合
		pookerMap.put(0, "大王");
		pookerMap.put(1, "小王");
		pookerList.add(0);
		pookerList.add(1);
		
//		System.out.println(pookerMap);
//		System.out.println(pookerList);
		
		//洗牌
		Collections.shuffle(pookerList);
		
		//发牌
		ArrayList<Integer> player1 = new ArrayList<Integer>();
		ArrayList<Integer> player2 = new ArrayList<Integer>();
		ArrayList<Integer> player3 = new ArrayList<Integer>();
		ArrayList<Integer> diPai = new ArrayList<Integer>();
		
		//遍历牌号的集合 判断索引发牌号
		for(int i = 0 ;i < pookerList.size() ;i++){
			Integer pookerNum = pookerList.get(i);
			
			if(i>=51){
				diPai.add(pookerNum);
			}else if(i % 3 == 0){
				player1.add(pookerNum);
			}else if(i % 3 == 1){
				player2.add(pookerNum);
			}else if(i % 3 == 2){
				player3.add(pookerNum);
			}
		}
		
		
//		排序
		
		Collections.sort(player1);
		Collections.sort(player2);
		Collections.sort(player3);
		Collections.sort(diPai);
//		System.out.println(player1);
//		System.out.println(player2);
//		System.out.println(player3);
//		System.out.println(diPai);
		
		show("张三",player1,pookerMap);
		show("李四",player2,pookerMap);
		show("王五",player3,pookerMap);
		show("底牌",diPai,pookerMap);
		
	}
	//定义方法 看牌
	public static void show(String name,ArrayList<Integer> player,HashMap<Integer, String> pookerMap ){
		System.out.print(name+":");
		for(Integer pookerNum : player){
			String thisPooker = pookerMap.get(pookerNum);
			System.out.print(thisPooker+" ");
		}
		System.out.println();
	}
}

```

# 第三章 图书管理系统

## 3.1 图书管理系统项目演示

![1543580142920](imgs/1543580142920.png)



![1543580255773](imgs/1543580255773.png)



![1543580374974](imgs/1543580374974.png)



![1543580413991](imgs/1543580413991.png)



![1543580469034](imgs/1543580469034.png)

![1543580482970](imgs/1543580482970.png)

**图书管理系统分析:**
1.定义Book类
2.完成主界面和选择
3.完成查询所有图书
4.完成添加图书
5.完成删除图书
6.完成修改图书
7.使用Debug追踪调试

## 3.2 图书管理系统之标准Book类

![1543582871305](imgs/1543582871305.png)

我们发现每一本书都有书名和价格,定义一个Book类表示书籍

```java
public class Book {
    private String name;
    private double price;

    public Book() {
    }

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
```



## 3.3 图书管理系统之主界面和选择的实现

![1543580142920](imgs/1543580142920.png)

主界面的内容其实就是通过打印语句打印出来的.但是要注意因为每个操作过后都会重新回到主界面,所以使用`while(true)`死循环的方式.

```java
public class BookManager {
    public static void main(String[] args) {
        while (true) {
            //这是学生管理系统的主界面
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1.查看所有书籍");
            System.out.println("2.添加书");
            System.out.println("3.删除书");
            System.out.println("4.修改书");
            System.out.println("5.退出");
            System.out.println("请输入你的选择：");

            //创建键盘录入对象
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    // 查看所有书籍
                    break;
                case 2:
                    // 添加书籍
                    break;
                case 3:
                    // 删除书
                    break;
                case 4:
                    // 修改书
                    break;
                case 5:
                    // 退出
                    break;
                default:
                    System.out.println("输入错误,请重新输入");
                    break;
            }
        }
    }
}
```



## 3.4 图书管理系统之查询所有图书

![1543582871305](imgs/1543582871305.png)

```java
public class BookManager {
    public static void main(String[] args) {
        Map<String, ArrayList<Book>> map = new HashMap<>();
        // 创建集合对象，用于存储学生数据
        ArrayList<Book> it = new ArrayList<Book>();
        it.add(new Book("Java入门到精通", 99));
        it.add(new Book("PHP入门到精通", 9.9));
        map.put("it书籍", it);
        ArrayList<Book> mz = new ArrayList<Book>();
        mz.add(new Book("西游记", 19));
        mz.add(new Book("水浒传", 29));
        map.put("名著", mz);

        while (true) {
            //这是学生管理系统的主界面
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1.查看所有书籍");
            System.out.println("2.添加书");
            System.out.println("3.删除书");
            System.out.println("4.修改书");
            System.out.println("5.退出");
            System.out.println("请输入你的选择：");

            //创建键盘录入对象
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    // 查看所有书籍
                    findAllBook(map);
                    break;
                case 2:
                    // 添加书籍
                    break;
                case 3:
                    // 删除书
                    break;
                case 4:
                    // 修改书
                    break;
                case 5:
                    // 退出
                    System.out.println("谢谢你的使用");
                    System.exit(0); // JVM退出
                    break;
                default:
                    System.out.println("输入错误,请重新输入");
                    break;
            }
        }
    }
    
    private static void findAllBook(Map<String, ArrayList<Book>> map) {
        System.out.println("类型\t\t书名\t价格");
        Set<Map.Entry<String, ArrayList<Book>>> entries = map.entrySet();
        for (Map.Entry<String, ArrayList<Book>> entry : entries) {
            String key = entry.getKey();
            System.out.println(key);

            ArrayList<Book> value = entry.getValue();
            for (Book book : value) {
                System.out.println("\t\t" + book.getName() + "\t" + book.getPrice());
            }
        }
    }
}    
```



## 3.5 图书管理系统之添加图书

![1543580374974](imgs/1543580374974.png)

```java
private static void addBook(Map<String, ArrayList<Book>> map) {
    // 创建键盘录入对象
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入要添加书籍的类型:");
    String type = sc.next();
    System.out.println("请输入要添加的书名:");
    String name = sc.next();
    System.out.println("请输入要添加书的价格:");
    double price = sc.nextDouble();
    Book book = new Book(name, price);

    // 拿到书籍列表
    ArrayList<Book> books = map.get(type);
    if (books == null) {
        // 如果书籍列表不存在创建一个书籍列表
        books = new ArrayList<>();
        map.put(type, books);
    }

    // 将书添加到集合中
    books.add(book);
    System.out.println("添加" + name + "成功");
}
```



## 3.6 图书管理系统之删除图书

![1543580413991](imgs/1543580413991.png)

```java
private static void deleteBook(Map<String, ArrayList<Book>> map) {
    // 创建键盘录入对象
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入要删除书籍的类型:");
    String type = sc.next();
    System.out.println("请输入要删除的书名:");
    String name = sc.next();

    // 拿到书籍列表  ： 用Map集合的
    ArrayList<Book> books = map.get(type);
    if (books == null) {
        System.out.println("您删除的书籍类型不存在");
        return;
    }

    for (int i = 0; i < books.size(); i++) {
        Book book = books.get(i);
        if (book.getName().equals(name)) {
            books.remove(i); // 找到这本书,删除这本书
            System.out.println("删除" + name + "书籍成功");
            return; // 删除书籍后结束方法
        }
    }
    System.out.println("没有找到" + name + "书籍");
}
```



## 3.7 图书管理系统之修改图书

![1543580469034](imgs/1543580469034.png)

```java
private static void editBook(Map<String, ArrayList<Book>> map) {
    // 创建键盘录入对象
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入要修改书籍的类型:");
    String type = sc.next();
    System.out.println("请输入要修改的书名:");
    String oldName = sc.next();

    System.out.println("请输入新的书名:");
    String newName = sc.next();
    System.out.println("请输入新的价格:");
    double price = sc.nextDouble();

    // 拿到书籍列表
    ArrayList<Book> books = map.get(type); // 根本不不像一个技术人员
    if (books == null) {
        System.out.println("您修改的书籍类型不存在");
        return;
    }

    for (int i = 0; i < books.size(); i++) {
        Book book = books.get(i);
        if (book.getName().equals(oldName)) {
            // 找到这本书,修改这本书
            book.setName(newName);
            book.setPrice(price);
            System.out.println("修改成功");
            return; // 修改书籍后结束方法
        }
    }
    System.out.println("没有找到" + oldName + "书籍");
}
```

## 3.8 Debug追踪调试
之前我们看程序的执行流程都是通过`System.out.println();`但是有不能让程序执行到某条语句后**停下来**,也不能看到程序**具体的执行步骤**.而是执行完所有的语句程序结束了。

**断点调试可以查看程序的执行流程和暂停程序.可以快速解决程序中的bug**

Debug调试窗口介绍

![](imgs\debug5.png)

# 第四章 排序算法介绍

## 4.1 冒泡排序

### 4.1.1 冒泡排序概述

- 一种排序的方式，对要进行排序的数据中相邻的数据进行两两比较，将较大的数据放在后面，依次对所有的数据进行操作，直至所有数据按要求完成排序
- 如果有n个数据进行排序，总共需要比较n-1次
- 每一次比较完毕，下一次的比较就会少一个数据参与

### 4.1.2 冒泡排序图解

![5](../../../../%E5%9F%BA%E7%A1%80%E5%8A%A0%E5%BC%BA%E8%AF%BE%E6%94%B9/day01-day15%E8%AE%B2%E4%B9%89-MD/day07-%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95,%E5%BC%82%E5%B8%B8,%E5%A4%9A%E7%BA%BF%E7%A8%8B%E5%9F%BA%E7%A1%80/img/5.png)

### 4.1.3 冒泡排序代码实现

```java
/*
    冒泡排序：
        一种排序的方式，对要进行排序的数据中相邻的数据进行两两比较，将较大的数据放在后面，
        依次对所有的数据进行操作，直至所有数据按要求完成排序
 */
public class ArrayDemo {
    public static void main(String[] args) {
        //定义一个数组
        int[] arr = {7, 6, 5, 4, 3};
        System.out.println("排序前：" + Arrays.toString(arr));

        // 这里减1，是控制每轮比较的次数
        for (int x = 0; x < arr.length - 1; x++) {
            // -1是为了避免索引越界，-x是为了调高比较效率
            for (int i = 0; i < arr.length - 1 - x; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        System.out.println("排序后：" + Arrays.toString(arr));
    }
}
```

## 4.2 选择排序

### 4.2.1 选择排序概述

- 另外一种排序的方式，选中数组的某个元素,其后面的元素依次和选中的元素进行两两比较，将较大的数据放在后面，依次从前到后选中每个元素，直至所有数据按要求完成排序
- 如果有n个数据进行排序，总共需要比较n-1次
- 每一次比较完毕，下一次的比较就会少一个数据参与

### 4.2.2 选择排序图解

![5](../../../../%E5%9F%BA%E7%A1%80%E5%8A%A0%E5%BC%BA%E8%AF%BE%E6%94%B9/day01-day15%E8%AE%B2%E4%B9%89-MD/day07-%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95,%E5%BC%82%E5%B8%B8,%E5%A4%9A%E7%BA%BF%E7%A8%8B%E5%9F%BA%E7%A1%80/img/6.png)

### 4.2.3 选择排序代码实现

```java
/*
    选择排序：
        另外一种排序的方式，选中数组的某个元素,其后面的元素依次和选中的元素进行两两比较，将较大的数据放在后面，依次从前到后选中每个元素，直至所有数据按要求完成排序
 */
public class ArrayDemo {
    public static void main(String[] args) {
        //定义一个数组
        int[] arr = {7, 6, 5, 4, 3};
        System.out.println("排序前：" + Arrays.toString(arr));
  		// 这里减1，是控制比较的轮数
        for (int x = 0; x < arr.length; x++) {
            // 从x+1开始,直到最后一个元素
            for (int i = x+1; i < arr.length; i++) {
                if (arr[x] > arr[i]) {
                    int temp = arr[x];
                    arr[x] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println("排序后：" + Arrays.toString(arr));
    }
}
```

# 第五章 二分查找

## 5.1 普通查找和二分查找

**普通查找**

原理：遍历数组，获取每一个元素，然后判断当前遍历的元素是否和要查找的元素相同，如果相同就返回该元素的索引。如果没有找到，就返回一个负数作为标识(一般是-1)

**二分查找**

原理: 每一次都去获取数组的中间索引所对应的元素，然后和要查找的元素进行比对，如果相同就返回索引；

如果不相同，就比较中间元素和要查找的元素的值；

如果中间元素的值大于要查找的元素，说明要查找的元素在左侧，那么就从左侧按照上述思想继续查询(忽略右侧数据)；

如果中间元素的值小于要查找的元素，说明要查找的元素在右侧，那么就从右侧按照上述思想继续查询(忽略左侧数据)；

**二分查找对数组是有要求的,数组必须已经排好序**

## 5.2 二分查找图解

假设有一个给定有序数组(10,14,21,38,45,47,53,81,87,99),要查找50出现的索引

则查询过程如下图所示:

![5](../../../../%E5%9F%BA%E7%A1%80%E5%8A%A0%E5%BC%BA%E8%AF%BE%E6%94%B9/day01-day15%E8%AE%B2%E4%B9%89-MD/day07-%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95,%E5%BC%82%E5%B8%B8,%E5%A4%9A%E7%BA%BF%E7%A8%8B%E5%9F%BA%E7%A1%80/img/7.png)

## 5.3 二分查找代码实现

```java
	public static void main(String[] args) {
        int[] arr = {10, 14, 21, 38, 45, 47, 53, 81, 87, 99};
        int index = binarySerach(arr, 38);
        System.out.println(index);
	}
	/**
     * 二分查找方法
     * @param arr 查找的目标数组
     * @param number 查找的目标值
     * @return 找到的索引,如果没有找到返回-1
     */
    public static int binarySerach(int[] arr, int number) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (number == arr[mid]) {
                return mid + 1;
            } else if (number < arr[mid]) {
                end = mid - 1;
            } else if (number > arr[mid]) {
                start = mid + 1;
            }
        }
        return -1;  //如果数组中有这个元素，则返回
    }
```

# 