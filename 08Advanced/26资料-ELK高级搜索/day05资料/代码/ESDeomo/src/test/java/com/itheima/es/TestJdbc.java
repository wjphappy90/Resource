package com.itheima.es;

import java.sql.*;

/**
 * creste by itheima.itcast
 */
//es sql功能
public class TestJdbc {
    public static void main(String[] args) {
        //1创建连接
        try {
            Connection connection = DriverManager.getConnection("jdbc:es://http://localhost:9200");
            //2创建statement
            Statement statement = connection.createStatement();
            //3执行sql语句
            ResultSet resultSet = statement.executeQuery("select * from tvs");
            //4获取结果
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println(resultSet.getString(4));
                System.out.println("======================================");
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }







    }




}
