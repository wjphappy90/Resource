package com.itheima.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comment")
public class Comment {

    @Id
    private String cid;//主键
    private Integer aid;//文章标识
    private String comment;//评论
    private String nickname;//评论者昵称

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "cid=" + cid +
                ", aid=" + aid +
                ", comment='" + comment + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
