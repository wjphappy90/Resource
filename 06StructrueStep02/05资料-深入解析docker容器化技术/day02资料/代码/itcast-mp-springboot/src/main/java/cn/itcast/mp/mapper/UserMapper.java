package cn.itcast.mp.mapper;

import cn.itcast.mp.pojo.User;

public interface UserMapper extends MyBaseMapper<User> {

    User findById(Long id);



}
