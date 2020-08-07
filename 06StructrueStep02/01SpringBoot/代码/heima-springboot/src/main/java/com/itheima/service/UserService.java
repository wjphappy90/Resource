package com.itheima.service;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    //根据id查询
    public User queryById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }

    //新增保存用户
    @Transactional
    public void saveUser(User user){
        System.out.println("新增用户... ");
        //选择性新增；如果属性为空则该属性不会出现在insert语句上
        userMapper.insertSelective(user);
        int i = 1/0;
    }
}
