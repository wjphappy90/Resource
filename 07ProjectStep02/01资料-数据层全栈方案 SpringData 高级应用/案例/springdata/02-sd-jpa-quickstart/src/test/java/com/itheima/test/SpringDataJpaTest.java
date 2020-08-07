package com.itheima.test;

import com.itheima.dao.ArticleDao;
import com.itheima.domain.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-jpa.xml")
public class SpringDataJpaTest {

    @Autowired
    private ArticleDao articleDao;

    //保存
    @Test
    public void testSave() {
        Article article = new Article();
        article.setTitle("黑马程序员1");
        article.setAuthor("黑马2");
        article.setCreateTime(new Date());

        articleDao.save(article);
    }


    //查询主键
    @Test
    public void testFindByAid() {
        Optional<Article> optional = articleDao.findById(1);
        System.out.println(optional.get());
    }

    //查询所有
    @Test
    public void testFindAll() {
        List<Article> articles = articleDao.findAll();
        for (Article article : articles) {
            System.out.println(article);
        }
    }

    //修改
    @Test
    public void testUpdate() {
        Article article = new Article();
        article.setAuthor("黑马3");
        article.setAid(2);

        //Spingdata Jpa的保存和修改使用的都是save方法
        //关键来看传入的实体是否有主键
        //---如果有主键,代表要修改
        //---如果没有主键,代表要保存
        articleDao.save(article);
    }

    //删除
    @Test
    public void testDelete() {
        articleDao.deleteById(2);
    }
}
