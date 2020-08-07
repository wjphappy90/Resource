package com.itheima.scheduler.elasticjob.quickstart.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.itheima.scheduler.elasticjob.quickstart.model.FileCustom;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件备份任务
 * @author Administrator
 * @version 1.0
 **/
public class FileBackupJob implements SimpleJob {

    //每次任务执行要备份文件的数量
    private final int FETCH_SIZE = 1;
    //文件列表（模拟）
    public static List<FileCustom> files = new ArrayList<>();

    //任务执行代码逻辑
    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println("作业分片："+shardingContext.getShardingItem());
        //获取未备份的文件
        List<FileCustom> fileCustoms = fetchUnBackupFiles(FETCH_SIZE);
        //进行文件备份
        backupFiles(fileCustoms);
    }

    /**
     * 获取未备份的文件
     * @param count   文件数量
     * @return
     */
    public List<FileCustom> fetchUnBackupFiles(int count){

        //获取的文件列表
        List<FileCustom> fileCustoms = new ArrayList<>();
        int num=0;
        for(FileCustom fileCustom:files){
            if(num >=count){
                break;
            }
            if(!fileCustom.getBackedUp()){
                fileCustoms.add(fileCustom);
                num ++;
            }

        }
        System.out.printf("time:%s,获取文件%d个\n", LocalDateTime.now(),num);
        return fileCustoms;

    }

    /**
     * 文件备份
     * @param files
     */
    public void backupFiles(List<FileCustom> files){
        for(FileCustom fileCustom:files){
            fileCustom.setBackedUp(true);
            System.out.printf("time:%s,备份文件，名称：%s，类型：%s\n", LocalDateTime.now(),fileCustom.getName(),fileCustom.getType());
        }
    }
}
