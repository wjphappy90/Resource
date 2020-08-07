package com.itheima.dao;

public interface UserDao {

    default void methodA(){
        System.out.println("methodA...");
        commons();
    }

    default void methodB(){
        System.out.println("methodB...");
        commons();
    }

    //定一个私有的方法，把重复部分的代码抽离出来。然后在methodA与methodB方法内部去调用。
    //私有方法只能在本类中调用，这里包括接口的实现类也不能调用。
   private void commons(){
        System.out.println("A....");
        System.out.println("B....");
        System.out.println("C....");
    }

}
