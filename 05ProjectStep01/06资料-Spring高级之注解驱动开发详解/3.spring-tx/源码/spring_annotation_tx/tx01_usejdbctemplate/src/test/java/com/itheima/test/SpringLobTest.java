package com.itheima.test;

import com.itheima.domain.Userinfo;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.FileCopyUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class SpringLobTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private LobHandler lobHandler;

    @Test
    public void testWrite(){
        try {
            //准备images的字节数组
            Resource resource = new FileSystemResource("C:\\Users\\zhy\\Desktop\\6.jpg");
            byte[] images = FileCopyUtils.copyToByteArray(resource.getFile());
            //准备description
            String description = "BLOB (binary large object)，二进制大对象，是一个可以存储二进制文件的容器。\n" +
                    "在计算机中，BLOB常常是数据库中用来存储二进制文件的字段类型。\n" +
                    "BLOB是一个大文件，典型的BLOB是一张图片或一个声音文件，\n" +
                    "由于它们的尺寸，必须使用特殊的方式来处理（例如：上传、下载或者存放到一个数据库）。\n" +
                    "根据Eric Raymond的说法，处理BLOB的主要思想就是让文件处理器（如数据库管理器）不去理会文件是什么，\n" +
                    "而是关心如何去处理它。但也有专家强调，这种处理大数据对象的方法是把双刃剑，\n" +
                    "它有可能引发一些问题，如存储的二进制文件过大，会使数据库的性能下降。\n" +
                    "在数据库中存放体积较大的多媒体对象就是应用程序处理BLOB的典型例子。";
            //1.创建Userinfo
            Userinfo userinfo = new Userinfo();
            userinfo.setImages(images);
            userinfo.setDescription(description);

            jdbcTemplate.execute("insert into userinfo(images,description)values(?,?)", new AbstractLobCreatingPreparedStatementCallback(lobHandler) {
                @Override
                protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException, DataAccessException {
                    lobCreator.setBlobAsBytes(ps, 1, userinfo.getImages());
                    lobCreator.setClobAsString(ps, 2, userinfo.getDescription());
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testRead(){
//        Userinfo userinfo = jdbcTemplate.queryForObject("select * from userinfo where id = ?",new BeanPropertyRowMapper<Userinfo>(Userinfo.class),1);
        Userinfo userinfo = jdbcTemplate.query("select * from userinfo where id = ?", new ResultSetExtractor<Userinfo>() {
            @Override
            public Userinfo extractData(ResultSet rs) throws SQLException, DataAccessException {
                Userinfo userinfo1 = null;
                if(rs.next()){
                    userinfo1 = new Userinfo();
                    userinfo1.setId(rs.getInt("id"));
                    userinfo1.setImages(lobHandler.getBlobAsBytes(rs,"images"));
                    userinfo1.setDescription(lobHandler.getClobAsString(rs,"description"));
                }
                return userinfo1;
            }
        }, 1);
        System.out.println(userinfo);
    }
}
