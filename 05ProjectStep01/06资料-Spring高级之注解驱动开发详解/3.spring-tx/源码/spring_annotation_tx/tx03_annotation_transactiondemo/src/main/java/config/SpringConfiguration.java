package config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring的配置类，代替applicationContext.xml
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Configuration
@ComponentScan("com.itheima")
@Import({JdbcConfig.class,TransactionManagerConfig.class})
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement//开启spring注解事务的支持
public class SpringConfiguration {
}
