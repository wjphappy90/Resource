package com.heima.cloneDemo.demo;

import com.heima.cloneDemo.domain.Skill;
import com.heima.cloneDemo.domain.Student;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 * 案例:已知A对象的姓名为豹子头林冲，年龄30 。由于项目特殊要求需要将该对象的数据
 * 复制另外一个对象B中，并且此后A和B两个对象的数据不会相互影响
 *
 * 方式三:深拷贝
 */
@SuppressWarnings("all")
public class CloneTest03 {
    public static void main(String[] args) throws CloneNotSupportedException {
        //创建技能对象
        Skill s = new Skill("倒拔垂杨柳");
        //创建学生对象
        Student stu1 = new Student("鲁智深",30,s);
        //调用clone的方法进行数据的拷贝
        Object stu2 = stu1.clone();
        System.out.println(stu1 == stu2);
        System.out.println(stu1);
        System.out.println(stu2);

        System.out.println("----此时不管修改哪个对象的内容,stu1和stu2都不会受到影响----");
        //更改stu1对象的内容
        stu1.setAge(33);
        s.setSkillName("拳打镇关西");
        System.out.println(stu1);
        System.out.println(stu2);
    }
}






/*

        //创建技能对象
        Skill s = new Skill("倒拔垂杨柳");
        //创建学生对象
        Student stu1 = new Student("鲁智深",30,s);
        //调用clone的方法进行数据的拷贝
        Object stu2 = stu1.clone();
        System.out.println(stu1 == stu2);
        System.out.println(stu1);
        System.out.println(stu2);

        System.out.println("----此时不管修改哪个对象的内容,stu1和stu2都不会受到影响----");
        //更改技能
        s.setSkillName("拳打镇关西");
        System.out.println(stu1);
        System.out.println(stu2);
 */
