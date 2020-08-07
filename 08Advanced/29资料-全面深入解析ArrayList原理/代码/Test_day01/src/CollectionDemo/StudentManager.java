package CollectionDemo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.CheckedInputStream;

/*
    学生管理系统
 */
@SuppressWarnings("all")
public class StudentManager {
    private static String uName = "老王";
    private static String uPassword = "123";
    private static Scanner sc = new Scanner(System.in);
    private static String disposition = "没有数据,请先添加";

    public static void main(String[] args) {
        //创建集合对象，用于存储学生数据
        ArrayList<Student> array = new ArrayList<Student>();
        //用Scanner实现键盘录入数据
        boolean b = login(sc);
        if (b) {
            //用循环完成再次回到主界面
            while (true) {
                //用输出语句完成主界面的编写
                System.out.println("请根据对应序号进行选择");
                System.out.println("1 添加技师");
                System.out.println("2 删除技师");
                System.out.println("3 修改技师");
                System.out.println("4 查看技师");
                System.out.println("5 统计操作");
                System.out.println("6 退出");
                System.out.println("请输入你的选择：");
                String line = sc.nextLine();
                //用switch语句完成操作的选择
                switch (line) {
                    case "1":
                        addStudent(array);
                        break;
                    case "2":
                        deleteStudent(array);
                        break;
                    case "3":
                        updateStudent(array);
                        break;
                    case "4":
                        findStudent(array);
                        break;
                    case "5":
                        count(array);
                        break;
                    case "6":
                        System.out.println("谢谢使用");
                        System.exit(0); //JVM退出
                    default:
                        System.out.println("没有对应的操作,请重新选择");
                }
            }
        }
    }

    private static void count(ArrayList<Student> array) {
        System.out.println("请选择: 1 统计大于18的人数 2 根据地址统计人数 ");
        String s = sc.nextLine();
        switch (s) {
            case "1":
                getPerCount(array);
                break;
            case "2":
                getCount(array);
                break;
            default:
                System.out.println("没有对应的操作!");
        }
    }

    private static void getCount(ArrayList<Student> array) {
        if (check(array)){
            int count = 0;
            System.out.println("请输入地址:");
            String address = sc.nextLine();
            for (int i = 0; i < array.size(); i++) {
                Student stu = array.get(i);
                if(stu.getAddress().equals(address)){
                    count++;
                }
            }
            System.out.println("来自于 "+address+" 共有 "+count+" 人");
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
        }else{
            System.out.println(StudentManager.disposition);
        }
    }

    private static void getPerCount(ArrayList<Student> array) {
        if (check(array)){
            int count = 0;
            for (int i = 0; i < array.size(); i++) {
                Student stu = array.get(i);
                if (stu.getAge() > 18){
                    count++;
                }
            }

            System.out.println("大于18岁的有 :" +count +" 个");
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
        }else{
            System.out.println(StudentManager.disposition);
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
        }
    }

    //查看学生
    private static void findStudent(ArrayList<Student> array) {
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println("请选择: 1 查看所有 2 根据年龄区间查询 3 根据地址查询 4 根据名字查询");
        String s = sc.nextLine();
        switch (s){
            case "1":
                findAllStudent(array);
                break;
            case "2":
                findAge(array);
                break;
            case "3":
                findAddress(array);
                break;
            case "4":
                findName(array);
                break;

            default:
                System.out.println("没有对应的操作,请重新选择");
                System.out.println("----------------------------------------");
                System.out.println("--------没有对应的操作,请重新选择--------");
                System.out.println("----------------------------------------");
        }
    }

    private static void findName(ArrayList<Student> array) {
        if (!check(array)){
            System.out.println("----------------------------------------");
            System.out.println("-----------没有数据,请重新选择-----------");
            System.out.println("----------------------------------------");
            return;
        }
        System.out.println("请输入名字:");
        String name = sc.nextLine();
        for (int i = 0; i < array.size(); i++) {
            Student stu = array.get(i);
            if (stu.getName().equals(name)){
                System.out.println(stu);
                System.out.println("----------------------------------------");
                System.out.println("----------------------------------------");
                return;
            }
        }

        System.out.println("-------------"+name+",未下海-------------");
        System.out.println("----------------------------------------");

    }

    private static void findAddress(ArrayList<Student> array) {
        if (check(array)){
            System.out.println("请输入地址:");
            String address = sc.nextLine();
            for (int i = 0; i < array.size(); i++) {
                Student stu = array.get(i);
                if (stu.getAddress().equals(address)){
                    System.out.println(stu);
                }
            }
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
        }else{
            System.out.println("没有数据,请先添加");
        }
    }

    private static void findAge(ArrayList<Student> array) {
        if (check(array)){
            System.out.println("请输入最小年龄:");
            int minAge = inputAge();
            System.out.println("请输入最大年龄:");
            int maxAge = inputAge();
            for (int i = 0; i < array.size(); i++) {
                Student stu = array.get(i);
                if(stu.getAge() > minAge && stu.getAge() < maxAge){
                    System.out.println(stu);
                }
            }
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
        }else{
            System.out.println("没有数据,请先添加");
        }
    }

    private static int inputAge() {
        while (true){
            try {
                String s = sc.nextLine();
                int i = Integer.parseInt(s);
                return i;
            } catch (Exception e) {
                System.out.println("请重新输入:");
            }
        }
    }

    private static boolean check(ArrayList<Student> array) {
        if (array == null || array.size() == 0){
            return false;
        }
        return true;
    }


    private static boolean login(Scanner sc) {
        System.out.println("----欢迎来到五楼后台管理系统,请先登录----");
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户名:");
            String username = sc.nextLine();
            System.out.println("请输入密码:");
            String password = sc.nextLine();
            if(username.equals(uName) && password.equals(uPassword)){
                System.out.println("----------------------------------------");
                System.out.println("----------------------------------------");
                System.out.println("------"+username+",欢迎您登录五楼后台管理系统-------");
                System.out.println("----------------------------------------");
                System.out.println("----------------------------------------");
                return true;
            }else{
                if(i == 2){
                    System.out.println("该账户已被锁定,请联系管理员!!!");
                }else{
                    System.out.println("用户名或密码错误,您还有"+(2-i)+"次机会");
                }
            }
        }
        return false;
    }

    public static void addStudent(ArrayList<Student> array) {
        //键盘录入学生对象所需要的数据,显示提示信息，提示要输入何种信息
        Scanner sc = new Scanner(System.in);
        //为了让sid在while循环外面被访问到，我们就把它定义在了循环外
        String sid = "";
        //为了让程序能够回到这里，我们使用循环实现
        while (true) {
            System.out.println("请输入学生学号：");
            sid = sc.nextLine();
            //校验 键盘输入的sid是否在学生对象中存在
            boolean flag = isUsed(array, sid);
            if (flag) {
                System.out.println("你输入的学号已经被使用，请重新输入");
            } else {
                break;
            }
        }
        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄：");
        int age;
        while (true){
            try {
                String a = sc.nextLine();
                age = Integer.parseInt(a);
                break;
            } catch (NumberFormatException e) {
                System.out.println("你输入的年龄不合法,请重新输入:");
            }
        }
        System.out.println("请输入学生居住地：");
        String address = sc.nextLine();
        //创建学生对象，把键盘录入的数据赋值给学生对象的成员变量
        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        //将学生对象添加到集合中
        array.add(s);
        //给出添加成功提示
        System.out.println("添加学生成功");
        //调用查询所有方法
        findAllStudent(array);
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
    }

    //定义一个方法，判断学号是否被使用
    public static boolean isUsed(ArrayList<Student> array, String sid) {
        //如果与集合中的某一个学生学号相同，返回true;如果都不相同，返回false
        boolean flag = false;

        for(int i=0; i<array.size(); i++) {
            Student s = array.get(i);
            if(s.getSid().equals(sid)) {
                flag = true;
                break;
            }
        }

        return flag;
    }

    //定义一个方法，用于查看学生信息
    public static void findAllStudent(ArrayList<Student> array) {
        //判断集合中是否有数据，如果没有显示提示信息
        if (array.size() == 0) {
            System.out.println("无信息，请先添加信息再查询");
            //为了让程序不在往下执行，给出return;
            return;
        }

        //显示表头信息
        //\t 其实就是tab键的位置
        System.out.println("学号\t\t姓名\t\t年龄\t\t居住地");

        //将集合中数据取出按照对应格式显示学生信息，年龄显示补充“岁”
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            System.out.println(s.getSid() + "\t\t" + s.getName() + "\t\t" + s.getAge() + "岁\t\t" + s.getAddress());
        }
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
    }

    //定义一个方法，用于删除学生信息
    public static void deleteStudent(ArrayList<Student> array) {
        if (!check(array)){
            System.out.println("----------------------------------------");
            System.out.println("------------无数据,请先添加-------------");
            System.out.println("----------------------------------------");
            return;
        }

        findAllStudent(array);
        //键盘录入要删除的学生学号,显示提示信息
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要删除的学生的学号：");
        String sid = sc.nextLine();
        //在删除/修改学生操作前，对学号是否存在进行判断
        //如果不存在，显示提示信息
        //如果存在，执行删除/修改操作
        int index = -1;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                //                int index = i;
                index = i;      //把集合的索引赋值给 变量
                break;
            }
        }

        if (index == -1) {
            System.out.println("该信息不存在，请重新输入");
        } else {
            array.remove(index);    //根据索引删除集合的元素
            //给出删除成功提示
            System.out.println("删除学生成功");
            findAllStudent(array);
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
        }
    }

    //定义一个方法，用于修改学生信息
    public static void updateStudent(ArrayList<Student> array) {
        if(array == null || array.size() == 0){
            System.out.println("没有数据,请先添加再进行修改");
            return;
        }
        //调用查询所有
        findAllStudent(array);
        //键盘录入要修改的学生学号，显示提示信息
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你要修改的学生的学号：");
        String sid = sc.nextLine();




        boolean b = false;
        //遍历集合修改对应的学生信息
        for (int i = 0; i < array.size(); i++) {
            Student student = array.get(i);
            if (student.getSid().equals(sid)) {
                //键盘录入要修改的学生信息
                System.out.println("请输入学生新姓名：");
                String name = sc.nextLine();
                System.out.println("请输入学生新年龄:");
                int age;
                while (true){
                    try {
                        String a = sc.nextLine();
                        age = Integer.parseInt(a);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("你输入的年龄不合法,请重新输入:");
                    }
                }
                System.out.println("请输入学生新居住地：");
                String address = sc.nextLine();

                //创建学生对象
                Student s = new Student();
                s.setSid(sid);
                s.setName(name);
                s.setAge(age);
                s.setAddress(address);
                array.set(i, s);
                //给出修改成功提示
                System.out.println("修改学生成功");
                b = true;
                break;
            }
        }

        if (b) {
            //调用查询所有方法
            findAllStudent(array);
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
        }else{
            System.out.println("您要修改的学员不存在!");
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
        }
    }
}
