package com.itheima.jdbc;

import com.itheima.jdbc.handler.ResultSetHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 自定义JdbcTemplate
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class JdbcTemplate {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public JdbcTemplate(){

    }

    public JdbcTemplate(DataSource dataSource){
        setDataSource(dataSource);
    }

    /**
     * 用于执行增删改方法的
     * @param sql       执行的SQL语句
     * @param params    执行SQL所需的参数
     * @return          影响数据库记录的行数
     */
    public int update(String sql,Object... params){
        //1.验证数据源是否有值
        if(dataSource == null){
            throw new NullPointerException("DataSource can not be null!");
        }
        //2.定义jdbc操作的相关对象
        Connection conn = null;
        PreparedStatement pstm = null;
        int res = 0;
        try{
            //3.获取连接
            conn = dataSource.getConnection();
            //4.获取预处理对象
            pstm = conn.prepareStatement(sql);
            //5.获取参数的元信息
            ParameterMetaData pmd = pstm.getParameterMetaData();
            //6.获取sql域中参数的个数
            int parameterCount = pmd.getParameterCount();
            //7.判断sql语句中是否有参数
            if(parameterCount > 0){
                //判断是否提供了参数
                if(params == null){
                    throw new IllegalArgumentException("Parameter can not be null!");
                }
                //判断是否个数匹配
                if(parameterCount != params.length){
                    throw new IllegalArgumentException("Incorrect parameter size: expected "+String.valueOf(parameterCount)+", actual "+String.valueOf(params.length));
                }
                //参数校验通过，给占位符赋值
                for(int i=0;i<parameterCount;i++){
                    pstm.setObject(i+1,params[i]);
                }
            }
            //8.执行sql语句
            res = pstm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            release(null,pstm,conn);
        }
        return res;
    }

    /**
     * 执行查询方法
     * @param sql       执行的语句
     * @param rsh       处理结果集的封装，此处只是提供一个规范（接口），由使用者编写具体的实现
     * @param params    执行语句所需的参数
     * @return
     */
    public Object query(String sql, ResultSetHandler rsh, Object... params){
        //1.验证数据源是否有值
        if(dataSource == null){
            throw new NullPointerException("DataSource can not be null!");
        }
        //2.定义jdbc操作的相关对象
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try{
            //3.获取连接
            conn = dataSource.getConnection();
            //4.获取预处理对象
            pstm = conn.prepareStatement(sql);
            //5.获取参数的元信息
            ParameterMetaData pmd = pstm.getParameterMetaData();
            //6.获取sql域中参数的个数
            int parameterCount = pmd.getParameterCount();
            //7.判断sql语句中是否有参数
            if(parameterCount > 0){
                //判断是否提供了参数
                if(params == null){
                    throw new IllegalArgumentException("Parameter can not be null!");
                }
                //判断是否个数匹配
                if(parameterCount != params.length){
                    throw new IllegalArgumentException("Incorrect parameter size: expected "+String.valueOf(parameterCount)+", actual "+String.valueOf(params.length));
                }
                //参数校验通过，给占位符赋值
                for(int i=0;i<parameterCount;i++){
                    pstm.setObject(i+1,params[i]);
                }
            }
            //8.执行sql语句
            rs = pstm.executeQuery();
            //9.封装
            return rsh.handle(rs);
        }catch (Exception e){
           throw new RuntimeException(e);
        }finally {
            release(rs,pstm,conn);
        }
    }


    private void release(ResultSet rs,PreparedStatement pstm ,Connection conn){
        if(rs != null){
            try {
                rs.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        if(pstm != null){
            try {
                pstm.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        if(conn != null){
            try {
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
