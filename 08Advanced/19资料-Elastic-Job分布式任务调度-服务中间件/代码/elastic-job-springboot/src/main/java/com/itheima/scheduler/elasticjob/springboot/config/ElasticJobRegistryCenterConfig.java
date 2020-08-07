package com.itheima.scheduler.elasticjob.springboot.config;

import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 * @version 1.0
 **/
@Configuration
public class ElasticJobRegistryCenterConfig {

    //zookeeper链接字符串 localhost:2181
    private  String ZOOKEEPER_CONNECTION_STRING = "localhost:2181" ;
    //定时任务命名空间
    private  String JOB_NAMESPACE = "elastic-job-example-java";

    //zk的配置及创建注册中心
    @Bean(initMethod = "init")
    public  CoordinatorRegistryCenter setUpRegistryCenter(){
        //zk的配置
        ZookeeperConfiguration zookeeperConfiguration = new ZookeeperConfiguration(ZOOKEEPER_CONNECTION_STRING, JOB_NAMESPACE);

        //创建注册中心
        CoordinatorRegistryCenter zookeeperRegistryCenter = new ZookeeperRegistryCenter(zookeeperConfiguration);
        return zookeeperRegistryCenter;

    }
}
