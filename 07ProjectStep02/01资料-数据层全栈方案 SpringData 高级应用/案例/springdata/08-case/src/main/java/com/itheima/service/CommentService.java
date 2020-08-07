package com.itheima.service;

import com.itheima.mongo.Comment;

import java.util.List;

public interface CommentService {

    //保存
    void saveComment(Comment comment);

    //删除
    void deleteByCid(String cid);

    //根据文章标识查询评论数据
    List<Comment> findCommentsByAid(Integer aid);
}
