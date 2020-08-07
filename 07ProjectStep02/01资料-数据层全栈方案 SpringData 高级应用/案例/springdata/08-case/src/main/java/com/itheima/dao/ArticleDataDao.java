package com.itheima.dao;

import com.itheima.domain.ArticleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ArticleDataDao extends JpaRepository<ArticleData, Integer> {

    //根据aid修改ArticleData中的content
    @Modifying//Jpa规定如果想使用JPQL进行更新或者删除操作,必须要使用@Modifying显示声明
    @Query("update ArticleData ad set ad.content = ?1 where ad.article.aid = ?2")
    void updateContentByAid(String content, Integer aid);

    @Modifying
    @Query("delete from ArticleData ad where ad.article.aid = ?1")
    void deleteByAid(Integer aid);

}
