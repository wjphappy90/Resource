package com.itheima.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aid;

    private String author;

    private Date createTime;

    private String title;


    @ManyToMany(mappedBy = "articles")
    private Set<Type> types = new HashSet<>(0);


    @OneToMany(mappedBy = "article")
    private Set<Comment> comments = new HashSet<>(0);

    //1 声明类间关系
    //声明主动放弃关系维护 mappedBy="当前类在对方类中的属性名"
    //当保存Article的时候,同时保存ArticleData
    @OneToOne(mappedBy = "article", cascade = CascadeType.PERSIST)
    private ArticleData articleData;


    //2 在类中使用注解再声明表间关系
    // --书写注解
    // --明确谁来维护关系(在多的一方维护关系)
    //  ----在维护的一方主动声明维护策略,在不维护的一方声明主动放弃


    public Set<Type> getTypes() {
        return types;
    }

    public void setTypes(Set<Type> types) {
        this.types = types;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public ArticleData getArticleData() {
        return articleData;
    }

    public void setArticleData(ArticleData articleData) {
        this.articleData = articleData;
    }

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
