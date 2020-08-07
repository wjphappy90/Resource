package com.itheima.service;

import com.itheima.domain.User;
import org.springframework.context.annotation.Description;

import java.util.List;

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
    @Description("保存用户")
    void saveUser(User user);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Description("根据ID查询用户")
    User findById(String id);

    /**
     * 更新用户
     * @param user
     */
    @Description("更新用户")
    void update(User user);

    /**
     * 删除用户
     * @param id
     */
    @Description("根据ID删除用户")
    void delete(String id);

    /**
     * 查询所有用户
     * @return
     */
    @Description("查询所有用户")
    List<User> findAll();
}
