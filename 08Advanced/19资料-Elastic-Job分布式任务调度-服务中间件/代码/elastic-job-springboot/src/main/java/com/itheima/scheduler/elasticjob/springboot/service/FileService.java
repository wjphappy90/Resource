package com.itheima.scheduler.elasticjob.springboot.service;

import com.itheima.scheduler.elasticjob.springboot.model.FileCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 **/
@Service
public class FileService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 获取某文件类型未备份的文件
     * @param fileType 文件类型
     * @param count 获取条数
     * @return
     */
    public List<FileCustom> fetchUnBackupFiles(String fileType, Integer count){
        String sql="select * from t_file where type = ? and backedUp = 0 limit 0,?";
        List<FileCustom> files = jdbcTemplate.query(sql, new Object[]{fileType, count}, new BeanPropertyRowMapper(FileCustom.class));
        return files;
    }

    /**
     * 备份文件
     * @param files 要备份的文件
     */
    public void backupFiles(List<FileCustom> files){
        for(FileCustom fileCustom:files){
            String sql="update t_file set backedUp = 1 where id = ?";
            jdbcTemplate.update(sql,new Object[]{fileCustom.getId()});
            System.out.println(String.format("线程 %d | 已备份文件:%s  文件类型:%s"
                    ,Thread.currentThread().getId()
                    ,fileCustom.getName()
                    ,fileCustom.getType()));
        }

    }
}
