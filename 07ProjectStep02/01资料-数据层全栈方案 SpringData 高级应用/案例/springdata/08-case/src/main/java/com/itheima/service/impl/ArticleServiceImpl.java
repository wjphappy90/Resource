package com.itheima.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.itheima.dao.ArticleDao;
import com.itheima.dao.ArticleDataDao;
import com.itheima.domain.Article;
import com.itheima.es.EsArticle;
import com.itheima.es.EsArticleDao;
import com.itheima.mongo.Comment;
import com.itheima.mongo.CommentDao;
import com.itheima.service.ArticleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private ArticleDataDao articleDataDao;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private EsArticleDao esArticleDao;

    @Autowired
    private CommentDao commentDao;


    @Override
    public void saveArticle(Article article) {

        // 向mysql保存文章和文章详情
        articleDataDao.save(article.getArticleData());
        articleDao.save(article);


        // 清空redis缓存
        redisTemplate.delete("articles");


        // 向ES中保存数据
        EsArticle esArticle = new EsArticle();
        esArticle.setCreateTime(article.getCreateTime());
        esArticle.setContent(article.getArticleData().getContent());
        esArticle.setTitle(article.getTitle());
        esArticle.setAuthor(article.getAuthor());
        esArticle.setId(article.getAid());
        esArticleDao.save(esArticle);
    }

    @Override
    public void updateArticle(Article article) {
        //更新article
        Article articleParam = new Article();
        articleParam.setTitle(article.getTitle());
        articleParam.setAid(article.getAid());
        articleParam.setAuthor(article.getAuthor());
        articleParam.setCreateTime(article.getCreateTime());
        articleDao.save(articleParam);

        //更新articleData
        articleDataDao.updateContentByAid(article.getArticleData().getContent(), article.getAid());

        //清空redis缓存
        redisTemplate.delete("articles");

        //向ES中保存数据
        EsArticle esArticle = new EsArticle();
        esArticle.setId(article.getAid());
        esArticle.setCreateTime(article.getCreateTime());
        esArticle.setContent(article.getArticleData().getContent());
        esArticle.setTitle(article.getTitle());
        esArticle.setAuthor(article.getAuthor());
        esArticleDao.save(esArticle);
    }

    @Override
    public void deleteByAid(Integer aid) {
        //删除articleData
        articleDataDao.deleteByAid(aid);

        //删除article
        articleDao.deleteById(aid);

        //删除mongodb中相关的评论
        //1---先根据aid查询到一个comment列表
        List<Comment> comments = commentDao.findByAid(aid);

        //2---删除一个评论列表
        commentDao.deleteAll(comments);

        //清空redis
        redisTemplate.delete("articles");

        //删除ES中的数据
        esArticleDao.deleteById(aid);
    }

    @Override
    public List<Article> findNewArticleList() {
        //1 先从redis中获取
        String value = redisTemplate.opsForValue().get("articles");

        //2 如果redis中没有,去数据库中查询,查询到以后,要存入redis
        if (StringUtils.isEmpty(value)) {
            //设置分页排序条件
            Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Order.desc("createTime")));
            Page<Article> page = articleDao.findAll(pageable);
            List<Article> content = page.getContent();

            //将结果转成String,存入redis
            if (content != null && content.size() > 0) {
                value = JSONObject.toJSONString(content);
                redisTemplate.opsForValue().set("articles", value);
            }
        }

        //3 将结果转成List返回
        return JSONObject.parseArray(value, Article.class);
    }

    @Override
    public List<EsArticle> search(Integer pageNum, Integer pageSize, String keyword) {
        //设置分页条件
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return esArticleDao.findByTitleOrContent(keyword, keyword, pageable);
    }


}
