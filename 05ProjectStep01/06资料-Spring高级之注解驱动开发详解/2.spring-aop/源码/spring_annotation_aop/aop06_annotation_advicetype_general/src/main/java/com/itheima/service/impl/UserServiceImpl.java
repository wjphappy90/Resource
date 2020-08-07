package com.itheima.service.impl;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    public void saveUser(User user,String id) {
        System.out.println("执行了保存用户" + user+","+id);
    }

    @Override
    public User findById(String id) {
        User user = new User();
        user.setId("1");
        user.setUsername("test");
        user.setNickname("泰斯特");
        System.out.println("准备返回的对象是"+user);
        int i=1/0;
        return user;
    }
}
