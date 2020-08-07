package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserDao {

    /**
     * 根据用户id查询用户对象
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    public User findById(Integer id);

    /**
     * 查询所有用户以及用户下所有账户的集合
     * @return
     */
    @Select("select * from user")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "address", column = "address"),
            @Result(property = "accounts", column = "id", javaType = List.class,
                    many = @Many(select = "com.itheima.dao.AccountDao.findAccountByUid", fetchType = FetchType.LAZY))
    })
    public List<User> findAllUserWithAccounts();
}
