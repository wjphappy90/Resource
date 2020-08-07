package com.itheima.test;

import com.itheima.dao.ArticleDao;
import com.itheima.dao.CommentDao;
import com.itheima.dao.TypeDao;
import com.itheima.domain.Article;
import com.itheima.domain.Comment;
import com.itheima.domain.Type;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-jpa.xml")
public class Many2ManyTest {

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private TypeDao typeDao;

    //保存
    @Test
    public void testSave() {
        //创建文章对象
        Article article1 = new Article();
        article1.setTitle("黑马好文章11");
        article1.setAuthor("黑马11");
        article1.setCreateTime(new Date());

        Article article2 = new Article();
        article2.setTitle("黑马好文章22");
        article2.setAuthor("黑马22");
        article2.setCreateTime(new Date());


        //创建文章类型对象
        Type type1 = new Type();
        type1.setName("军事");
        Type type2 = new Type();
        type2.setName("民政");


        //建立两个对象间的关系
        Set<Type> types = new HashSet<>();
        types.add(type1);
        types.add(type2);
        article1.setTypes(types);
        article2.setTypes(types);

        Set<Article> articles = new HashSet<>();
        articles.add(article1);
        articles.add(article2);
        type1.setArticles(articles);
        type2.setArticles(articles);


        //保存操作
        articleDao.save(article1);
        articleDao.save(article2);
        typeDao.save(type1);
        typeDao.save(type2);
    }
}
