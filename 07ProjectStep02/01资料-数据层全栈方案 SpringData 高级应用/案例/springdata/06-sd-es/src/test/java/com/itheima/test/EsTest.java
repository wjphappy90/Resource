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
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-es.xml")
public class EsTest {

    @Autowired
    private ElasticsearchTemplate template;

    @Autowired
    private ArticleDao articleDao;

    //通过SpringData ES技术向ElasticSearch数据库存储一条数据
    @Test
    public void testSave() {
        //创建索引
        template.createIndex(Article.class);

        //创建映射
        template.putMapping(Article.class);

        //创建文档
        Article article = new Article();
        article.setId(1);
        article.setTitle("sd-黑马程序员");
        article.setContext("sd-黑马程序员很棒");

        //保存文档
        articleDao.save(article);
    }

    //修改
    @Test
    public void testUpdate() {

        //判断数据库中是否有你指定的id的文档,如果没有,就进行保存,如果有,就进行更新
        Article article = new Article();
        article.setId(1);
        article.setTitle("sd-黑马程序员1");
        article.setContext("sd-黑马程序员很棒1");

        articleDao.save(article);
    }

    //删除
    @Test
    public void testDelete() {
        //根据主键删除
        articleDao.deleteById(1);
    }

    //重新构建数据
    @Test
    public void makeData() {
        //创建索引
        template.createIndex(Article.class);

        //创建映射
        template.putMapping(Article.class);

        for (int i = 1; i <= 10; i++) {
            //创建文档
            Article article = new Article();
            article.setId(i);
            article.setTitle("sd-黑马程序员" + i);
            article.setContext("sd-黑马程序员很棒" + i);
            article.setHits(100 + i);
            //保存文档
            articleDao.save(article);
        }
    }

    //查询所有
    @Test
    public void testFindAll() {
        Iterable<Article> all = articleDao.findAll();
        for (Article article : all) {
            System.out.println(article);
        }
    }

    //主键查询
    @Test
    public void testFindById() {
        Optional<Article> opt = articleDao.findById(1);
        System.out.println(opt.get());
    }

    //分页查询
    @Test
    public void testFindAllWithPage() {
        //设置分页条件
        Pageable pageable = PageRequest.of(1, 3);//page代表的页码,从0开始

        Page<Article> page = articleDao.findAll(pageable);

        for (Article article : page.getContent()) {
            System.out.println(article);
        }
    }

    //排序查询
    @Test
    public void testFindAllWithSort() {
        //设置排序条件
        Sort sort = Sort.by(Sort.Order.desc("hits"));

        Iterable<Article> all = articleDao.findAll(sort);
        for (Article article : all) {
            System.out.println(article);
        }
    }

    //分页+排序查询
    @Test
    public void testFindAllWithPageAndSort() {
        //设置排序条件
        Sort sort = Sort.by(Sort.Order.desc("hits"));

        //设置分页条件
        Pageable pageable = PageRequest.of(1, 3, sort);//page代表的页码,从0开始

        Page<Article> page = articleDao.findAll(pageable);

        for (Article article : page.getContent()) {
            System.out.println(article);
        }
    }

    //根据标题查询
    @Test
    public void testFindByTitle() {
        List<Article> articles = articleDao.findByTitle("员");
        for (Article article : articles) {
            System.out.println(article);
        }
    }


    //根据标题查询
    @Test
    public void testFindByTitleOrContext() {
        List<Article> articles = articleDao.findByTitleOrContext("程序员", "程序员");
        for (Article article : articles) {
            System.out.println(article);
        }
    }

    //根据标题查询
    @Test
    public void testFindByTitleOrContextWithPage() {

        //设置排序条件
        Sort sort = Sort.by(Sort.Order.desc("hits"));

        //设置分页条件
        Pageable pageable = PageRequest.of(1, 3, sort);//page代表的页码,从0开始

        List<Article> articles = articleDao.findByTitleOrContext("程序员", "程序员", pageable);
        for (Article article : articles) {
            System.out.println(article);
        }
    }


}
