package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import config.SpringConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class SpringAspectTest {

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
        userService.saveUser(user);
    }
}
