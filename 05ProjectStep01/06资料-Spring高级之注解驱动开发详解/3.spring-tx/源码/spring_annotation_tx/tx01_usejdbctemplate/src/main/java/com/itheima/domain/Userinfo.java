package com.itheima.domain;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 用户信息的实体类
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class Userinfo implements Serializable {

    private Integer id;
    private byte[] images;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImages() {
        return images;
    }

    public void setImages(byte[] images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "id=" + id +
                ", images=" + Arrays.toString(images) +
                ", description='" + description + '\'' +
                '}';
    }
}
