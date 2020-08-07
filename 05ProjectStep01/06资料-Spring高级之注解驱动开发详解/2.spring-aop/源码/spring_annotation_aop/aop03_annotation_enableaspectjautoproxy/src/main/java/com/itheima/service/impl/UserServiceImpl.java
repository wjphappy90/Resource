package com.itheima.service.impl;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    public void saveUser(User user) {
        System.out.println("执行了保存用户"+user);
    }

    @Override
    public void saveAllUser(List<User> users) {
        for(User user : users){
            UserService proxyUserServiceImpl = (UserService)AopContext.currentProxy();
            proxyUserServiceImpl.saveUser(user);
        }
    }
}
