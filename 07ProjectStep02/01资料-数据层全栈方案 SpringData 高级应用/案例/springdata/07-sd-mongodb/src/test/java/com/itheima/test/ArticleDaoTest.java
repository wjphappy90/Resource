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

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ArticleDaoTest {

    @Autowired
    private ArticleDao articleDao;


    //保存
    @Test
    public void testSave() {
        Article article = new Article();
        article.setId(1);
        article.setName("黑马程序员");
        article.setContent("黑马程序员很低调");
        article.setHits(100);

        articleDao.save(article);
    }


    //修改
    @Test
    public void testUpdate() {
        Article article = new Article();
        article.setId(1);
        article.setName("黑马程序员2");
        article.setContent("黑马程序员很低调2");
        article.setHits(200);

        articleDao.save(article);
    }

    //修改
    @Test
    public void testDelete() {
        articleDao.deleteById(1);
    }


    //做数据
    @Test
    public void makeData() {
        for (int i = 1; i <= 10; i++) {
            Article article = new Article();
            article.setId(i);
            article.setName("黑马程序员" + i);
            article.setContent("黑马程序员很低调" + i);
            article.setHits(100 + i);

            articleDao.save(article);
        }
    }


    //查询所有
    @Test
    public void testFindAll() {
        List<Article> articles = articleDao.findAll();
        for (Article article : articles) {
            System.out.println(article);
        }
    }

    //主键查询
    @Test
    public void testFindById() {
        Optional<Article> opt = articleDao.findById(1);
        System.out.println(opt.get());
    }

    //分页和排序
    @Test
    public void testFindAllWithPageAndSort() {

        //设置排序条件
        Sort sort = Sort.by(Sort.Order.desc("hits"));

        //设置分页条件
        Pageable pageable = PageRequest.of(1, 3, sort);

        Page<Article> page = articleDao.findAll(pageable);
        for (Article article : page.getContent()) {
            System.out.println(article);
        }
    }


    //根据标题查询
    @Test
    public void testFindByName() {
        List<Article> articles = articleDao.findByNameLike("黑马程序员1");
        for (Article article : articles) {
            System.out.println(article);
        }
    }

    //根据标题查询
    @Test
    public void testFindByHitsGreaterThan() {
        List<Article> articles = articleDao.findByHitsGreaterThan(105);
        for (Article article : articles) {
            System.out.println(article);
        }
    }


}
