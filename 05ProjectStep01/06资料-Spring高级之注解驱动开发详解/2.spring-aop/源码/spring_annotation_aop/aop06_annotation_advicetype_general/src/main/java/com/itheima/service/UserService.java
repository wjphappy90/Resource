package com.itheima.service;

import com.itheima.domain.User;

/**
 * 业务层接口
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public interface UserService {

    /**
     * 模拟保存用户
     * @param user
     */
    void saveUser(User user,String id);

    /**
     * 模拟根据id查询用户
     * @param id
     * @return
     */
    User findById(String id);
}
