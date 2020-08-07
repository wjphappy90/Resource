package com.itheima.domain;

import javax.persistence.*;
import java.util.Date;

@Entity//告诉jpa这是一个实体类，需要把它跟数据库中的表做映射
//使用注解建立实体类和数据表之间的对应关系
@Table(name = "article")//@Table建立了实体类和数据表的关系  name指向表名
public class Article {

    @Id//标识这是主键字段
    //指定主键生成策略，GenerationType.IDENTITY就是对应到mysql中的数据自增策略
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aid;

    //使用@Column映射类的属性和数据表的字段关系  name指定表中的字段名
    //当类的属性名和数据表的字段名一致时，此注解可省略
    @Column(name = "author")
    private String author;

    private Date createTime;

    private String title;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

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
                "aid=" + aid +
                ", author='" + author + '\'' +
                ", createTime=" + createTime +
                ", title='" + title + '\'' +
                '}';
    }
}
