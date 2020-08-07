package com.itheima.nacos;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Administrator
 * @version 1.0
 **/
public class PasswordEncoderUtil {
    public static void main(String[] args) {
        String encode = new BCryptPasswordEncoder().encode("456");
        System.out.println(encode);
    }
}
