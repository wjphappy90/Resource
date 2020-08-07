package com.itheima.es;

import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EsArticleDao extends ElasticsearchRepository<EsArticle, Integer> {

    //根据title或者content进行查询
    List<EsArticle> findByTitleOrContent(String title, String content, Pageable pageable);

}
