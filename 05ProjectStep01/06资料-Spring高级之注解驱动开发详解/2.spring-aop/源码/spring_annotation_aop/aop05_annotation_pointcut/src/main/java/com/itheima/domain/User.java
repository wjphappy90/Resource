package com.itheima.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class User implements Serializable {
    private String id;
    private String username;
    private String password;
    private String email;
    private Date birthday;
    private String gender;
    private String mobile;
    private String nickname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "id='" + id + '\'' +
//                ", username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                ", email='" + email + '\'' +
//                ", birthday=" + birthday +
//                ", gender='" + gender + '\'' +
//                ", mobile='" + mobile + '\'' +
//                ", nickname='" + nickname + '\'' +
//                '}';
//    }
}
