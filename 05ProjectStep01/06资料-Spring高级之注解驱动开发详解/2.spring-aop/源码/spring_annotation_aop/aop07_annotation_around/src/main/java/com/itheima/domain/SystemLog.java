package com.itheima.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统日志的实体类
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class SystemLog implements Serializable {

    private String id;      //日志的主键
    private String method;  //当前执行的操作方法名称
    private String action;  //当前执行的操作方法说明
    private Date time;      //执行时间
    private String remoteIP;//来访者IP

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getRemoteIP() {
        return remoteIP;
    }

    public void setRemoteIP(String remoteIP) {
        this.remoteIP = remoteIP;
    }

    @Override
    public String toString() {
        return "SystemLog{" +
                "id='" + id + '\'' +
                ", method='" + method + '\'' +
                ", action='" + action + '\'' +
                ", time=" + time +
                ", remoteIP='" + remoteIP + '\'' +
                '}';
    }
}
