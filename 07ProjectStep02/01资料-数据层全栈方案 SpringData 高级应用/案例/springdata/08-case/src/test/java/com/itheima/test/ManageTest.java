package com.itheima.test;

import com.itheima.domain.Article;
import com.itheima.domain.ArticleData;
import com.itheima.mongo.Comment;
import com.itheima.service.ArticleService;
import com.itheima.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ManageTest {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    //保存文章
    @Test
    public void testSaveArticle() {

        //准备测试数据
        ArticleData articleData = new ArticleData();
        articleData.setContent("4黑马程序员专注于IT培训,Java培训,人工智能培训,Python培训,大数据培训,区\n" +
                "块链培训,UI设计培训,PHP培训,Web前端培训,软件测试培训,产品经理培训，并提供Java培训,大数据培训,区块链培训,UI\n" +
                "设计培训,PHP培训,软件测试培训,产品经理培训等服务。");


        Article article = new Article();
        article.setTitle("4黑马程序员介绍");
        article.setAuthor("4黑马程序员");
        article.setCreateTime(new Date());

        //建立两者关系
        article.setArticleData(articleData);
        articleData.setArticle(article);

        articleService.saveArticle(article);
    }

    //更新文章
    @Test
    public void testUpdateArticle() {

        //准备测试数据
        ArticleData articleData = new ArticleData();
        articleData.setContent("1黑马程序员专注于IT培训,Java培训,人工智能培训,Python培训,大数据培训,区\n" +
                "块链培训,UI设计培训,PHP培训,Web前端培训,软件测试培训,产品经理培训，并提供Java培训,大数据培训,区块链培训,UI\n" +
                "设计培训,PHP培训,软件测试培训,产品经理培训等服务。");

        Article article = new Article();
        article.setAid(1);
        article.setTitle("1黑马程序员介绍");
        article.setAuthor("1黑马程序员");
        article.setCreateTime(new Date());
        article.setArticleData(articleData);

        articleService.updateArticle(article);
    }


    //删除文章
    @Test
    public void testDeleteArticle() {
        articleService.deleteByAid(2);
    }

    //添加评论
    @Test
    public void testSaveComment(){

        Comment comment = new Comment();
        comment.setCid(UUID.randomUUID().toString());
        comment.setAid(3);
        comment.setComment("2黑马程序员真棒!!!");
        comment.setNickname("2黑马程序员");
        commentService.saveComment(comment);
    }

    //删除评论
    @Test
    public void testDeleteComment(){
        commentService.deleteByCid("9c10f644-3301-4db1-b678-09539c1d5423");
    }
}
