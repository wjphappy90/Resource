package com.heima.cloneDemo.demo;

import com.heima.cloneDemo.domain.Student;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 *
 * 案例:已知A对象的姓名为豹子头林冲，年龄30 。由于项目特殊要求需要将该对象的数据
 * 复制另外一个对象B中，并且此后A和B两个对象的数据不会相互影响
 */
@SuppressWarnings("all")
public class CloneTest01 {
    public static void main(String[] args) {
        /*//传统方式:
        //创建学生对象
        Student stu1 = new Student("豹子头林冲",30);
        //再次创建一个新的学生对象
        Student stu2 = new Student();
        //把stu1对象name的值取出来赋值给stu2对象的name
        stu2.setName(stu1.getName());
        //把stu1对象age的值取出来赋值给stu2对象的age
        stu2.setAge(stu1.getAge());

        System.out.println(stu1 == stu2);
        System.out.println(stu1);
        System.out.println(stu2);

        System.out.println("----此时不管修改哪个对象的内容,stu1和stu2都不会受到影响----");
        stu1.setName("扈三娘");
        System.out.println(stu1);
        System.out.println(stu2);*/
    }
}
