package com.itheima.service.impl;

import com.itheima.mongo.Comment;
import com.itheima.mongo.CommentDao;
import com.itheima.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public void saveComment(Comment comment) {
        commentDao.save(comment);
    }

    @Override
    public void deleteByCid(String cid) {
        commentDao.deleteById(cid);
    }

    @Override
    public List<Comment> findCommentsByAid(Integer aid) {
        return commentDao.findByAid(aid);
    }


}
