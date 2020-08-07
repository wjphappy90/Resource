package com.itheima.dao;

import com.itheima.domain.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleDao extends JpaRepository<Article, Integer>, JpaSpecificationExecutor<Article> {

}
