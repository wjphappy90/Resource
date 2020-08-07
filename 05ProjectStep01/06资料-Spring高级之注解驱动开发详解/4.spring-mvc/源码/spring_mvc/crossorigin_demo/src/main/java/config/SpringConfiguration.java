package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Spring的配置类，它替代了applicationContext.xml
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Configuration
@ComponentScan(value="com.itheima",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class))
public class SpringConfiguration {
}
