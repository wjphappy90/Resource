package com.itheima.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//使用@Document建立的是实体类和collection的关系
@Document("article")
public class Article {

    @Id//用来标识主键
    private Integer id;

    //使用@Field建立实体类中属性跟collection中字段的映射关系,如果省略,代表两个名称一致
    //@Field
    private String name;
    private String content;
    private Integer hits;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", hits=" + hits +
                '}';
    }
}
