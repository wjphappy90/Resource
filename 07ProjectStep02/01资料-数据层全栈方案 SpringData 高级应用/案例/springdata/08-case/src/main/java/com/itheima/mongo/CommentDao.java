package com.itheima.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentDao extends MongoRepository<Comment, String> {

    //命名规则查询:按照aid查询到一个文章的所有评论
    List<Comment> findByAid(Integer aid);
}
