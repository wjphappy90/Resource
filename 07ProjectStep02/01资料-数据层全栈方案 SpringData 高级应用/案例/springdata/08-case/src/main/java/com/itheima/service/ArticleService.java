package com.itheima.service;

import com.itheima.domain.Article;
import com.itheima.es.EsArticle;

import java.util.List;

public interface ArticleService {

    //保存文章
    void saveArticle(Article article);


    //更新文章
    void updateArticle(Article article);


    //删除文章
    void deleteByAid(Integer aid);


    //最新文章列表
    List<Article> findNewArticleList();


    //文章检索
    List<EsArticle> search(Integer pageNum, Integer pageSize, String keyword);
}
