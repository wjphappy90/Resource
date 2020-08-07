package com.itheima.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    private String name;

    @ManyToMany
    @JoinTable(
            //代表中间表名称
            name = "article_type",
            //中间表的外键对应到当前表的主键名称
            joinColumns = {@JoinColumn(name = "tid", referencedColumnName = "tid")},
            //中间表的外键对应到对方表的主键名称
            inverseJoinColumns = {@JoinColumn(name = "aid", referencedColumnName = "aid")}
    )
    private Set<Article> articles = new HashSet<>(0);


    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Type{" +
                "tid=" + tid +
                ", name='" + name + '\'' +
                '}';
    }
}
