package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    public List<User> findAll();

    /**
     * 添加用户
     * @param user
     */
    @Insert("insert into user (username, birthday, sex, address) " +
            "values " +
            "(#{username}, #{birthday}, #{sex}, #{address})")
    public void saveUser(User user);

    /**
     * 修改用户
     * @param user
     */
    @Update("update user set username=#{username}," +
            "birthday=#{birthday}," +
            "sex=#{sex}," +
            "address=#{address}" +
            "where id=#{id}")
    public void updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    @Delete("delete from user where id = #{id}")
    public void deleteById(Integer id);
}
