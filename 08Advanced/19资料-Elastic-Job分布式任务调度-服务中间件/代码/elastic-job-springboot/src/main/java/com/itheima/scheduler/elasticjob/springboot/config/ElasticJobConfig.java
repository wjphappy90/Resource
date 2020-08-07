package com.itheima.scheduler.elasticjob.springboot.config;

import com.dangdang.ddframe.job.api.ElasticJob;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.dataflow.DataflowJobConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.event.rdb.JobEventRdbConfiguration;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.itheima.scheduler.elasticjob.springboot.job.FileBackupJobDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

/**
 * @author Administrator
 * @version 1.0
 **/
@Configuration
public class ElasticJobConfig {

    @Autowired
    private DataSource dataSource; //数据源已经存在，直接引入

//    @Autowired
//    SimpleJob fileBackupJob;

    @Autowired
    FileBackupJobDb fileBackupJob;

//    @Autowired
//    FileBackupJobDataFlow fileBackupJob;

    @Autowired
    CoordinatorRegistryCenter registryCenter;

    /**
     * 配置任务详细信息
     * @param jobClass 任务执行类
     * @param cron  执行策略
     * @param shardingTotalCount 分片数量
     * @param shardingItemParameters 分片个性化参数
     * @return
     */
    private LiteJobConfiguration createJobConfiguration(final Class<? extends SimpleJob> jobClass,
                                                        final String cron,
                                                        final int shardingTotalCount,
                                                        final String shardingItemParameters){
        //JobCoreConfigurationBuilder
        JobCoreConfiguration.Builder JobCoreConfigurationBuilder = JobCoreConfiguration.newBuilder(jobClass.getName(), cron, shardingTotalCount);
        //设置shardingItemParameters
        if(!StringUtils.isEmpty(shardingItemParameters)){
            JobCoreConfigurationBuilder.shardingItemParameters(shardingItemParameters);
        }
        JobCoreConfiguration jobCoreConfiguration = JobCoreConfigurationBuilder.build();
        //创建SimpleJobConfiguration
        SimpleJobConfiguration simpleJobConfiguration = new SimpleJobConfiguration(jobCoreConfiguration, jobClass.getCanonicalName());
        //创建LiteJobConfiguration
        LiteJobConfiguration liteJobConfiguration = LiteJobConfiguration.newBuilder(simpleJobConfiguration).overwrite(true)
                .monitorPort(9888)//设置dump端口
                .build();
        return liteJobConfiguration;
    }

    //创建支持dataFlow类型的作业的配置信息
    private LiteJobConfiguration createFlowJobConfiguration(final Class<? extends ElasticJob> jobClass,
                                                        final String cron,
                                                        final int shardingTotalCount,
                                                        final String shardingItemParameters){
        //JobCoreConfigurationBuilder
        JobCoreConfiguration.Builder JobCoreConfigurationBuilder = JobCoreConfiguration.newBuilder(jobClass.getName(), cron, shardingTotalCount);
        //设置shardingItemParameters
        if(!StringUtils.isEmpty(shardingItemParameters)){
            JobCoreConfigurationBuilder.shardingItemParameters(shardingItemParameters);
        }
        JobCoreConfiguration jobCoreConfiguration = JobCoreConfigurationBuilder.build();
        // 定义数据流类型任务配置
        DataflowJobConfiguration jobConfig = new DataflowJobConfiguration(jobCoreConfiguration, jobClass.getCanonicalName(),true);
        //创建LiteJobConfiguration
        LiteJobConfiguration liteJobConfiguration = LiteJobConfiguration.newBuilder(jobConfig).overwrite(true)
                .monitorPort(9888)//设置dump端口
                .build();
        return liteJobConfiguration;
    }
    @Bean(initMethod = "init")
    public SpringJobScheduler initSimpleElasticJob() {
        // 增加任务事件追踪配置
        JobEventConfiguration jobEventConfig = new JobEventRdbConfiguration(dataSource);
        //创建SpringJobScheduler

        SpringJobScheduler springJobScheduler = new SpringJobScheduler(fileBackupJob, registryCenter,
                createJobConfiguration(fileBackupJob.getClass(), "0/10 * * * * ?", 4, "0=text,1=image,2=radio,3=vedio")
                ,jobEventConfig);
        return springJobScheduler;
    }
}
