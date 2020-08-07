package config;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Jdbc的配置类
 * @author zhy
 *
 */
public class JdbcConfig {
	
	@Value("${jdbc.driver}")
	private String driver;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;

	@Bean(name="runner")//它是把方法的返回值存入spring容器中。该注解有一个属性，name：用于指定bean的id。当不指定时它有默认值，默认值是方法的名称。
	public QueryRunner createQueryRunner(@Qualifier("ds1")DataSource dataSource){
		return new QueryRunner(dataSource);
	}
	
	@Bean(name="ds")
	public DataSource createDataSource(){
		try {
			System.out.println(driver);//com.mysql.jdbc.Driver  
			ComboPooledDataSource ds = new ComboPooledDataSource();
			ds.setDriverClass(driver);
			ds.setJdbcUrl(url);
			ds.setUser(username);
			ds.setPassword(password);
			return ds;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Bean(name="ds1")
	public DataSource createDataSource1(){
		try {
			System.out.println(url);
			ComboPooledDataSource ds = new ComboPooledDataSource();
			ds.setDriverClass(driver);
			ds.setJdbcUrl(url);
			ds.setUser(username);
			ds.setPassword(password);
			return ds;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
