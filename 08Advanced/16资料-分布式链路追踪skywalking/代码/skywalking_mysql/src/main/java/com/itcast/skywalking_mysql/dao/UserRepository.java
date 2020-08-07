package com.itcast.skywalking_mysql.dao;

import com.itcast.skywalking_mysql.pojo.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
