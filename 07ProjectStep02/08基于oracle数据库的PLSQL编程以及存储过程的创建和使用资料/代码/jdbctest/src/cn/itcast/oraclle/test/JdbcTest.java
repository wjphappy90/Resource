package cn.itcast.oraclle.test;


import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcTest {

    public static void main(String[] args) throws  Exception {
 
        
        //1.加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        //2.获取连接对象
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user ="scott";
        String password = "tiger";

        Connection conn = DriverManager.getConnection(url, user, password);
        
        //3.获得语句对象

        String sql = "{call p_querysal_out(?,?)}";
        CallableStatement call = conn.prepareCall(sql);


        //4.设置输入参数
        call.setInt(1,7839);


        //5.注册输出参数
        call.registerOutParameter(2, OracleTypes.DOUBLE);


        //6.执行储存过程
        call.execute();

        //7.获取输出参数
        double sal = call.getDouble(2);

        System.out.println(sal);

        //8.释放资源
        call.close();
        conn.close();


    }
    
}
