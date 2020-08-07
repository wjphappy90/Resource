package support.factory;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * 自定义yml文件解析的工厂类
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class YmlPropertySourceFactory implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        //1.创建yaml文件解析工厂
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        //2.设置要解析的内容
        factoryBean.setResources(resource.getResource());
        //3.把资源解析成properties文件
        Properties properties = factoryBean.getObject();
        //4.返回spring提供的PropertySource对象
        return  (name != null ? new PropertiesPropertySource(name,properties)
                             : new PropertiesPropertySource(resource.getResource().getFilename(),properties));
    }
}
