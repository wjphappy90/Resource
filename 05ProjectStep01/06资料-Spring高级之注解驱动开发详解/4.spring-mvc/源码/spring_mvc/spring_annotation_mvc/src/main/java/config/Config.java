package config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

/**
 * 初始化spring和springmvc ioc容器的配置类
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class Config extends AbstractDispatcherServletInitializer {

    /**
     * 注册字符集过滤器
     * @param servletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //触发父类的onStartup
        super.onStartup(servletContext);
        //1.创建字符集过滤器对象
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        //2.设置使用的字符集
        characterEncodingFilter.setEncoding("UTF-8");
        //3.添加到容器（它不是ioc容器，而是ServletContainer）
        FilterRegistration.Dynamic registration = servletContext.addFilter("characterEncodingFilter",characterEncodingFilter);
        //4.添加映射
        registration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST,DispatcherType.FORWARD,DispatcherType.INCLUDE),
                false,"/*");

        //解决跨域的过滤器
//        FilterRegistration.Dynamic registration1 = servletContext.addFilter("crossOriginFilter",new CrossOriginFilter());
//        registration1.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST,DispatcherType.FORWARD,DispatcherType.INCLUDE),
//                false,"/*");
    }

    /**
     * 用于创建springmvc的Ioc容器
     * @return
     */
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext acw = new AnnotationConfigWebApplicationContext();
        acw.register(SpringMvcConfiguration.class);
        return acw;
    }

    /**
     * 用于指定DispatcherServlet的请求映射
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 用于创建spring的ioc容器
     * @return
     */
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        AnnotationConfigWebApplicationContext acw = new AnnotationConfigWebApplicationContext();
        acw.register(SpringConfiguration.class);
        return acw;
    }
}
