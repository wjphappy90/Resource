package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import config.SpringConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class SpringAroundTest {

    public static void main(String[] args) {
        //1.创建容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.获取对象
        UserService userService = ac.getBean("userService",UserService.class);
        //3.执行方法
        //测试保存
        User user = new User();
        user.setId("1");
        user.setUsername("test");
        user.setNickname("泰斯特");
        userService.saveUser(user);
        System.out.println("-------------------------------------");
        //测试根据id查询
        User user1 = userService.findById("1");
        System.out.println("执行了根据id查询"+user1);
        System.out.println("-------------------------------------");
        //测试删除
        userService.delete("1");
        System.out.println("-------------------------------------");
        //测试更新
        userService.update(user);
        System.out.println("-------------------------------------");
        //测试查询所有
        List<User> users = userService.findAll();
        for(User user2 : users){
            System.out.println("执行了查询所有"+user2);
        }
    }
}
