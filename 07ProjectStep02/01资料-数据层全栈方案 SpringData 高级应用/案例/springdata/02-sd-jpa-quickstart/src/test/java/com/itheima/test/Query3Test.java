package com.itheima.test;

import com.itheima.dao.ArticleDao;
import com.itheima.domain.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-jpa.xml")
public class Query3Test {

    @Autowired
    private ArticleDao articleDao;


    @Test
    public void testFindByCondition1() {
        List<Article> articles = articleDao.findByCondition1("黑马程序员1", "黑马");
        for (Article article : articles) {
            System.out.println(article);
        }
    }

    @Test
    public void testFindByCondition2() {
        List<Article> articles = articleDao.findByCondition2("黑马程序员1", "黑马");
        for (Article article : articles) {
            System.out.println(article);
        }
    }


    @Test
    public void testFindByCondition4() {
        List<Article> articles = articleDao.findByCondition4("黑马程序员");
        for (Article article : articles) {
            System.out.println(article);
        }
    }

    @Test
    public void testFindByCondition5() {
        Pageable pageable = PageRequest.of(0, 3);
        List<Article> articles = articleDao.findByCondition5(pageable, "黑马程序员");
        for (Article article : articles) {
            System.out.println(article);
        }
    }

    @Test
    public void testFindByCondition6() {
        List<Integer> list = new ArrayList<>();
        list.add(29);
        list.add(30);

        List<Article> articles = articleDao.findByCondition6(list);
        for (Article article : articles) {
            System.out.println(article);
        }
    }

    @Test
    public void testFindByCondition7() {
        Article articleParam = new Article();
        articleParam.setTitle("黑马程序员1");
        articleParam.setAuthor("黑马");
        List<Article> articles = articleDao.findByCondition7(articleParam);
        for (Article article : articles) {
            System.out.println(article);
        }
    }


    @Test
    public void testFindByCondition8() {
        List<Article> articles = articleDao.findByCondition8("黑马程序员1", "黑马");
        for (Article article : articles) {
            System.out.println(article);
        }
    }

}
