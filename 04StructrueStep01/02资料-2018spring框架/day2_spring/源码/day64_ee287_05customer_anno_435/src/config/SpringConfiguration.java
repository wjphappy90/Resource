package config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 一个spring的配置类
 * 	它的作用就相当于bean.xml
 * @author zhy
 */
@Configuration//它就是把当前类看成是spring的配置类
@ComponentScan({"com.itheima"})
@Import({JdbcConfig.class})//导入其他配置类
@PropertySource("classpath:config/jdbcConfig.properties")
public class SpringConfiguration {
	
	
}
