package com.heima.cloneDemo.domain;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 */
public class Student implements Cloneable{
    //姓名
    private String name;
    //年龄
    private int age;
    //技能
    private Skill skill;

    public Student() {
    }

    public Student(String name, int age, Skill skill) {
        this.name = name;
        this.age = age;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", skill=" + skill +
                '}';
    }

    /*
        注意:
            首先方法的权限修饰符需要更改为public
            方法的返回值可以更改为当前类的类名
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        //return super.clone();     //深拷贝,不能简单的调用父类的方法
        //先克隆出来一个学生对象
        Student stu = (Student) super.clone();
        //调用Skill类中的克隆方法,克隆出来一个Skill对象
        Skill skill = (Skill) this.skill.clone();
        //将克隆出来的skill赋值给stu该对象的成员变量
        stu.setSkill(skill);
        //需要把stu返回
        return stu;
    }

}
