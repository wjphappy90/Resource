package com.itheima.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodingTest {
    //加盐加密
    //123---bcaddjlj    加盐    321xiaoming---dsgagagfd
    //动态加盐
    //$2a$10$CYX9OMv0yO8wR8rE19N2fOaXDJondci5uR68k2eQJm50q8ESsDMlC
    //$2a$10$sfam.BrjudKnEeuhZGrh6.p67bUzBX/Szq3i47oagpRlkQQmlwQ7G
    //$2a$10$hy6KkOfi.qTTiQx6WXX6vu9goE2FFy7xZIdT75ji8N0OSV4po4FOu
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("123"));
    }
}
