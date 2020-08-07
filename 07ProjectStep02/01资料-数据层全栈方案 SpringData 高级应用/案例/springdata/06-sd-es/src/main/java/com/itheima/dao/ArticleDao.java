package com.itheima.dao;

import com.itheima.domain.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

//自定义的接口需要继承ElasticsearchRepository<实体类型,主键类型>  基本的crud 分页
public interface ArticleDao extends ElasticsearchRepository<Article, Integer> {

    //根据标题查询
    List<Article> findByTitle(String title);

    //根据标题或内容查询
    List<Article> findByTitleOrContext(String title, String context);

    //根据标题或内容查询(含分页)
    List<Article> findByTitleOrContext(String title, String context, Pageable pageable);


}
