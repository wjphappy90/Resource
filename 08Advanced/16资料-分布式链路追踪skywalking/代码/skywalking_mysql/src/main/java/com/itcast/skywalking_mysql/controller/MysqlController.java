package com.itcast.skywalking_mysql.controller;

import com.itcast.skywalking_mysql.dao.UserRepository;
import com.itcast.skywalking_mysql.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MysqlController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> findAll(){
        List<User> result = new ArrayList<>();
        userRepository.findAll().forEach((user) -> {
            result.add(user);
        });

        return result;
    }
}
