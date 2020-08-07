package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import config.SpringConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class SpringEnableAspecctJAutoProxyTest {

    public static void main(String[] args) {
        //1.创建容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.获取对象
        UserService userService = ac.getBean("userService",UserService.class);
        //3.执行方法
        User user = new User();
        user.setId("1");
        user.setUsername("test");
        user.setNickname("泰斯特");

        List<User> users = new ArrayList<>();
        users.add(user);

        userService.saveAllUser(users);
    }
}
