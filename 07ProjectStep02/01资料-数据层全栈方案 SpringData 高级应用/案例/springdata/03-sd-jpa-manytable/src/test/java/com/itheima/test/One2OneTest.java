package com.itheima.test;

import com.itheima.dao.ArticleDao;
import com.itheima.domain.Article;
import com.itheima.domain.ArticleData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-jpa.xml")
public class One2OneTest {

    @Autowired
    private ArticleDao articleDao;


    //保存
    @Test
    public void testSave() {
        //创建文章对象
        Article article = new Article();
        article.setTitle("黑马好文章");
        article.setAuthor("黑马");
        article.setCreateTime(new Date());

        //创建文章内容对象
        ArticleData articleData = new ArticleData();
        articleData.setContent("真是一篇好文章");


        //建立两个对象间的关系
        article.setArticleData(articleData);
        articleData.setArticle(article);

        //保存操作
        articleDao.save(article);
    }
}
