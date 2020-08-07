package com.itheima.dao;

import com.itheima.domain.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ArticleDao extends MongoRepository<Article, Integer> {

    //根据标题查询
    List<Article> findByNameLike(String name);

    //根据点击量查询
    List<Article> findByHitsGreaterThan(Integer hits);

}
