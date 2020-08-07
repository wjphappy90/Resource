package com.itheima.scheduler.elasticjob.quickstart;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.itheima.scheduler.elasticjob.quickstart.job.FileBackupJob;
import com.itheima.scheduler.elasticjob.quickstart.model.FileCustom;

/**
 * 启动任务
 * @author Administrator
 * @version 1.0
 **/
public class JobMain {

    //zookeeper端口
    private static final int ZOOKEEPER_PORT = 2181;
    //zookeeper链接字符串 localhost:2181
    private static final String ZOOKEEPER_CONNECTION_STRING = "localhost:" + ZOOKEEPER_PORT;
    //定时任务命名空间
    private static final String JOB_NAMESPACE = "elastic-job-example-java";


    //执行启动任务
    public static void main(String[] args) {
        //制造一些测试数据
        generateTestFiles();
        //配置注册中心
        CoordinatorRegistryCenter registryCenter = setUpRegistryCenter();
        //启动任务
        startJob(registryCenter);
    }

    //zk的配置及创建注册中心
    private static CoordinatorRegistryCenter setUpRegistryCenter(){
        //zk的配置
        ZookeeperConfiguration zookeeperConfiguration = new ZookeeperConfiguration(ZOOKEEPER_CONNECTION_STRING, JOB_NAMESPACE);
        //减少zk超时时间
        zookeeperConfiguration.setSessionTimeoutMilliseconds(100);

        //创建注册中心
        CoordinatorRegistryCenter zookeeperRegistryCenter = new ZookeeperRegistryCenter(zookeeperConfiguration);
        zookeeperRegistryCenter.init();
        return zookeeperRegistryCenter;
    }

    //任务的配置和启动
    private static void startJob(CoordinatorRegistryCenter registryCenter){
        //String jobName 任务名称, String cron 调度表达式, int shardingTotalCount 作业分片数量
        JobCoreConfiguration jobCoreConfiguration = JobCoreConfiguration.newBuilder("fiels-job", "0/3 * * * * ?", 3).build();
        //创建SimpleJobConfiguration
        SimpleJobConfiguration simpleJobConfiguration = new SimpleJobConfiguration(jobCoreConfiguration, FileBackupJob.class.getCanonicalName());
        //创建new JobScheduler
        new JobScheduler(registryCenter, LiteJobConfiguration.newBuilder(simpleJobConfiguration).overwrite(true).build()).init();

    }

    //制造一些测试数据
    //生成测试文件
    private static void generateTestFiles(){
        for(int i=1;i<11;i++){
            FileBackupJob.files.add(new FileCustom(String.valueOf(i+10),"文件"+(i+10),"text","content"+ (i+10)));
            FileBackupJob.files.add(new FileCustom(String.valueOf(i+20),"文件"+(i+20),"image","content"+ (i+20)));
            FileBackupJob.files.add(new FileCustom(String.valueOf(i+30),"文件"+(i+30),"radio","content"+ (i+30)));
            FileBackupJob.files.add(new FileCustom(String.valueOf(i+40),"文件"+(i+40),"video","content"+ (i+40)));
        }
        System.out.println("生产测试数据完成");
    }
}
