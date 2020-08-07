package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.itheima.utils.HibernateUtil;

/**
 * spring的配置类，相当于bean.xml
 * @author zhy
 *
 */
@Configuration
@ComponentScan("com.itheima")
@EnableAspectJAutoProxy
@Import(HibernateUtil.class)
public class SpringConfiguration {

}
