package com.itheima.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//用户
@Entity(name = "shop_user")//实体类跟数据表的对应
@Data//不再去写set和get方法
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//数据库自增
    private Integer uid;//主键
    private String username;//用户名
    private String password;//密码
    private String telephone;//手机号
}