package config;

import support.factory.YmlPropertySourceFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * spring的配置类
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Configuration
@ComponentScan("com.itheima")
@Import(JdbcConfig.class)
@PropertySource(value = "classpath:jdbc.yml",factory = YmlPropertySourceFactory.class)
public class SpringConfiguration{
}
