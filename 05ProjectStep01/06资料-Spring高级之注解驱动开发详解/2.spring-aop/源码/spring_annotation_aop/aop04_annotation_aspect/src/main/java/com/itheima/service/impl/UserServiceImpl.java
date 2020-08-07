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
    public void saveUser(User user) {
//        try {
//            Thread.sleep(3000);
            System.out.println("执行了保存用户" + user);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
