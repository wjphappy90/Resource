package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有账户以及所属用户信息
     * @return
     */
    @Select("select * from account")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "money", column = "money"),
            @Result(property = "user", column = "uid", javaType = User.class,
                    one = @One(select = "com.itheima.dao.UserDao.findById", fetchType = FetchType.LAZY))
    })
    public List<Account> findAccountWithUser();

    /**
     * 根据用户id查询账户集合
     * @return
     */
    @Select("select * from account where uid = #{uid}")
    public List<Account> findAccountByUid();
}
