package com.itheima.rpc.protocol;

import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;

public class HttpServer {


    /**
     * tomcat服务启动
     * 参考tomcat配置
     * <Server port="8005" shutdown="SHUTDOWN">
     * 	<Service name="Catalina">
     * 		<Connector port="8080" protocol="HTTP/1.1"
     *                connectionTimeout="20000"
     *                redirectPort="8443"
     * 	       URIEncoding="UTF-8"/>
     * 		<Engine name="Catalina" defaultHost="localhost">
     * 			<Host name="localhost"  appBase="webapps"
     *             	unpackWARs="true" autoDeploy="true">
     *     		 	<Context path="" doBase="WORKDIR" reloadable="true"/>
     *      		</Host>
     *      </Engine>
     *   </Service>
     * </Server>
     */


    /**
     * 启动服务
     * @param hostname
     * @param port
     */
    public void start(String hostname,int port){
        // 实例一个tomcat
        Tomcat tomcat = new Tomcat();

        // 构建server
        Server server = tomcat.getServer();

        // 获取service
        Service service = server.findService("Tomcat");

        // 构建Connector
        Connector connector = new Connector();
        connector.setPort(port);
        connector.setURIEncoding("UTF-8");

        // 构建Engine
        Engine engine = new StandardEngine();
        engine.setDefaultHost(hostname);

        // 构建Host
        Host host = new StandardHost();
        host.setName(hostname);

        // 构建Context
        String contextPath = "";
        Context context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());// 生命周期监听器

        // 然后按照server.xml，一层层把子节点添加到父节点
        host.addChild(context);
        engine.addChild(host);
        service.setContainer(engine);
        service.addConnector(connector);
        // service在getServer时就被添加到server节点了

        // tomcat是一个servlet,设置路径与映射
        tomcat.addServlet(contextPath,"dispatcher",new DispatcherServlet());
        context.addServletMappingDecoded("/*","dispatcher");

        try {
            tomcat.start();// 启动tomcat
            tomcat.getServer().await();// 接受请求
        }catch (LifecycleException e){
            e.printStackTrace();
        }
    }


}
