package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    /**
     * 根据用户id查询用户对象
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    public User findById(Integer id);
}
