package com.itheima.domain;

import java.io.Serializable;
import java.util.Date;


//注意:实体类必须实现序列化接口
public class Article implements Serializable {
    //作者
    private String author;
    //创建时间
    private Date createTime;
    //标题
    private String title;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Article{" +
                "author='" + author + '\'' +
                ", createTime=" + createTime +
                ", title='" + title + '\'' +
                '}';
    }
}