package com.itheima.jdbc.handler;

import java.sql.ResultSet;

/**
 * 结果集的处理器
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public interface ResultSetHandler {

    /**
     * 处理结果集
     * @param rs
     * @return
     */
    Object handle(ResultSet rs);
}
