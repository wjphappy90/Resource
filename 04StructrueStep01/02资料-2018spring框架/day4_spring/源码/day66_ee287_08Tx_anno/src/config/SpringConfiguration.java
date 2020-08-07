package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring的配置类，作用就是当bean.xml用
 * @author zhy
 *
 */
@Configuration
@ComponentScan("com.itheima")
@Import({JdbcConfig.class,TransactionManager.class})
@EnableTransactionManagement
public class SpringConfiguration {

}
