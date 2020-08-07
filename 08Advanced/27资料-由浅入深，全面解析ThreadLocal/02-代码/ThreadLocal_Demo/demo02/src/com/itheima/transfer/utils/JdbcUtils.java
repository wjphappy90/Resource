package com.itheima.transfer.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtils {
    static ThreadLocal<Connection> tl = new ThreadLocal<>();
    // c3p0 数据库连接池对象属性
    private static final ComboPooledDataSource ds = new ComboPooledDataSource();
    // 获取连接
    /*
    * 原本: 直接从连接池中获取连接
    * 现在:
    *       1. 直接获取当前线程绑定的连接对象
    *       2. 如果连接对象是空的
    *           2.1 再去连接池中获取连接
    *           2.2 将此连接对象跟当前线程进行绑定
    * */
    public static Connection getConnection() throws SQLException {
        Connection conn = tl.get();
        if(conn == null){
            conn = ds.getConnection();
            tl.set(conn);
        }
        return conn;
//        return ds.getConnection();
    }
    //释放资源
    public static void release(AutoCloseable... ios){
        for (AutoCloseable io : ios) {
            if(io != null){
                try {
                    io.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void commitAndClose(Connection conn) {
        try {
            if(conn != null){
                //提交事务
                conn.commit();
                //解绑当前线程绑定的连接对象
                tl.remove();
                //释放连接
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollbackAndClose(Connection conn) {
        try {
            if(conn != null){
                //回滚事务
                conn.rollback();
                //解绑当前线程绑定的连接对象
                tl.remove();
                //释放连接
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
