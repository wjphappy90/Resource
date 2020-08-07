package com.itheima.domain;

import javax.persistence.*;

@Entity
public class ArticleData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//主键
    private String content;//文章内容

    //建立从ArticleData到Article的一对一关系
    @OneToOne
    //@JoinColumn(name=当前表的外键字段名称,referencedColumnName 指向对方表的主键)
    @JoinColumn(name = "articleId", referencedColumnName = "aid", unique = true)
    private Article article;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "ArticleData{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
