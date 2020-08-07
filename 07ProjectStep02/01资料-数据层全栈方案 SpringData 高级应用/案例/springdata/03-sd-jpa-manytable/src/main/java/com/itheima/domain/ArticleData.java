package com.itheima.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "article_data")
public class ArticleData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;


    //让这个实体维护关系
    //name                    当前表中的外键名
    //referencedColumnName    指向的对方表中的主键名
    @OneToOne
    @JoinColumn(name = "articleId", referencedColumnName = "aid", unique = true)
    private Article article;


    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

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

    @Override
    public String toString() {
        return "ArticleData{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
