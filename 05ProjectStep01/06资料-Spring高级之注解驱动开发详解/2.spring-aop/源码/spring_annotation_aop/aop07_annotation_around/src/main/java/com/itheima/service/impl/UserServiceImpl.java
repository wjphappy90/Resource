package com.itheima.service.impl;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    public void saveUser(User user) {
        System.out.println("执行了保存用户" + user);
    }

    @Override
    public User findById(String id) {
        User user = new User();
        user.setId("1");
        user.setUsername("test");
        user.setNickname("泰斯特");
        return user;
    }

    @Override
    public void update(User user) {
        System.out.println("执行了更新用户"+user);
    }

    @Override
    public void delete(String id) {
        System.out.println("执行了删除用户"+id);
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        for(int i=1;i<10;i++){
            User user = new User();
            user.setId("1"+i);
            user.setUsername("test"+i);
            user.setNickname("泰斯特"+i);
            users.add(user);
        }
        return users;
    }
}
