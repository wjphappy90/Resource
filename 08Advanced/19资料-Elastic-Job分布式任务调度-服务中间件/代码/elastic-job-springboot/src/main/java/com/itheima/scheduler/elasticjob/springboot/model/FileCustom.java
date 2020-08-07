package com.itheima.scheduler.elasticjob.springboot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 * @version 1.0
 **/
@Data
@NoArgsConstructor
public class FileCustom {
    /**
     * 标识
     */
    private String id;

    /**
     * 文件名
     */
    private String name;

    /**
     * 文件类型，如text、image、radio、vedio
     */
    private String type;

    /**
     * 文件内容
     */
    private String content;

    /**
     * 是否已备份
     */
    private Boolean backedUp = false;

    public FileCustom(String id, String name, String type, String content){
        this.id = id;
        this.name = name;
        this.type = type;
        this.content = content;
    }
}
