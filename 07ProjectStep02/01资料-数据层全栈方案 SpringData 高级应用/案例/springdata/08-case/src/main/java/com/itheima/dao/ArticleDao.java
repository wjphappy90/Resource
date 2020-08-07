package com.itheima.dao;

import com.itheima.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleDao extends JpaRepository<Article, Integer> {
}
