package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

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
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer createPropertySourcesPlaceholderConfigurer(){
		return  new PropertySourcesPlaceholderConfigurer();
	}
}
