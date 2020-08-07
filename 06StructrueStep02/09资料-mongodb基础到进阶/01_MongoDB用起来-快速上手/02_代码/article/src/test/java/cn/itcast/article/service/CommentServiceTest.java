package cn.itcast.article.service;

import cn.itcast.article.po.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTest {

    @Autowired
    private CommentService commentService;


    @Test
    public void testFindCommentList() {
        List<Comment> commentList = commentService.findCommentList();
        System.out.println(commentList);
    }

    @Test
    public void testFindCommentById() {
        Comment commentById = commentService.findCommentById("1");
        System.out.println(commentById);
    }

    @Test
    public void testSaveComment(){
        Comment comment=new Comment();
        comment.setArticleid("100000");
        comment.setContent("测试添加的数据");
        comment.setCreatedatetime(LocalDateTime.now());
        comment.setUserid("1003");
        comment.setNickname("凯撒大帝");
        comment.setState("1");
        comment.setLikenum(0);
        comment.setReplynum(0);

        commentService.saveComment(comment);

    }

    @Test
    public void testFindCommentListByParentid() {
        Page<Comment> page = commentService.findCommentListByParentid("3", 1, 2);
        System.out.println(page.getTotalElements());
        System.out.println(page.getContent());
    }

    @Test
    public void testUpdateCommentLikenum() {
        commentService.updateCommentLikenum("1");
    }



}
