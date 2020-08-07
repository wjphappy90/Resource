package com.itheima.test;

import com.itheima.dao.ArticleDao;
import com.itheima.domain.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-jpa.xml")
public class SpringDataJpaCUDTest {

    @Autowired
    private ArticleDao articleDao;

    //保存
    @Test
    public void testSave() {
        Article article = new Article();
        article.setTitle("黑马程序员1");
        article.setAuthor("黑马2");
        article.setCreateTime(new Date());

        //保存一个实体
        articleDao.save(article);

        //保存一个实体,并且立即刷新缓存
        //articleDao.saveAndFlush(article);
    }

    //保存多个
    @Test
    public void testSaveAll() {
        Article article1 = new Article();
        article1.setTitle("黑马程序员1");
        article1.setAuthor("黑马1");
        article1.setCreateTime(new Date());

        Article article2 = new Article();
        article2.setTitle("黑马程序员2");
        article2.setAuthor("黑马2");
        article2.setCreateTime(new Date());

        Article article3 = new Article();
        article3.setTitle("黑马程序员3");
        article3.setAuthor("黑马3");
        article3.setCreateTime(new Date());

        List list = new ArrayList();
        list.add(article1);
        list.add(article2);
        list.add(article3);

        //保存多个实体
        articleDao.saveAll(list);
    }


    //删除
    @Test
    public void testDeleteOne(){

        //1  根据主键删除
        //articleDao.deleteById(13);

        //2 根据实体删除,但是这个实体必须要有主键
        Article article = new Article();
        article.setAid(13);

        articleDao.delete(article);
    }


    //删除
    @Test
    public void testDeleteAll(){
        //1 删除所有  先查询--再一条条的删除
        //articleDao.deleteAll();

        //2 删除所有  一下子删除所有记录
        //articleDao.deleteAllInBatch();

        Article article1 = new Article();
        article1.setAid(24);

        Article article2 = new Article();
        article2.setAid(22);

        List list = new ArrayList();
        list.add(article1);
        list.add(article2);

        //3 批量删除指定数据  一条语句搞定
        //articleDao.deleteInBatch(list);

        //4 先一条条的查,然后再一条条的删除
        articleDao.deleteAll(list);
    }
}
