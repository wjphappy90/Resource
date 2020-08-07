package com.itheima.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aid;//主键
    private String title;//文章标题
    private String author;//文章作者
    private Date createTime;//创建时间


    //建立从Article到ArticleData的一对一关系
    @OneToOne(mappedBy = "article")
    private ArticleData articleData;


    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public ArticleData getArticleData() {
        return articleData;
    }

    public void setArticleData(ArticleData articleData) {
        this.articleData = articleData;
    }

    @Override
    public String toString() {
        return "Article{" +
                "aid=" + aid +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
