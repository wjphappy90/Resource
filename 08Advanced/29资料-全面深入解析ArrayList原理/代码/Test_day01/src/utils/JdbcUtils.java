package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * 获取连接池
 */
public class JdbcUtils {
    //定义一个数据源
    private static DataSource dataSource;

    //在静态代码块中为连接池进行初始化
    static {
        try {
            Properties p = new Properties();
            p.load(JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties"));

            //创建连接池
            dataSource = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //只要提供一个方法可以获取连接池即可
    public static DataSource getDataSource(){
        return dataSource;
    }
}
