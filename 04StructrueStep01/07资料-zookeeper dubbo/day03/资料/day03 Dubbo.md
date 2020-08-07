## day03 Dubbo

​     

Apache Dubbo是一款高性能的Java RPC框架。其前身是阿里巴巴公司开源的一个高性能、轻量级的开源Java RPC框架，可以和Spring框架无缝集成。

Dubbo提供了三大核心能力：面向接口的远程方法调用，智能容错和负载均衡，以及服务自动注册和发现。

官网：
http://dubbo.apache.org/

**什么是RPC？**

RPC全称为remote procedure call，即**远程过程调用**。比如两台服务器A和B，A服务器上部署一个应用，B服务器上部署一个应用，A服务器上的应用想调用B服务器上的应用提供的方法，由于两个应用不在一个内存空间，不能直接调用，所以需要通过网络来表达调用的语义和传达调用的数据。

需要注意的是RPC并不是一个具体的技术，而是指整个网络远程调用过程。 

而不需要了解底层网络技术的协议，在面向对象的编程语言中，远程过程调用即是 远程方法调用

![1570603288105](C:\Users\Szc.0713\AppData\Roaming\Typora\typora-user-images\1570603288105.png)

RPC调用过程

![1570603372462](C:\Users\Szc.0713\AppData\Roaming\Typora\typora-user-images\1570603372462.png)

java中RPC框架比较多，常见的有RMI、Hessian、gRPC、bRPC、Dubbo等，其实对
于RPC框架而言，核心模块就是通讯和序列化
接下来我们就分别看一下常见的RPC框架

RMI

1）RMI(remote method invocation)是java原生支持的远程调用，RMI采用JRMP（Java
RemoteMessageing Protocol）作为通信协议，可以认为是纯java版本的分布式远程调用解决方案。

2）RMI的核心概念

![1570611496558](C:\Users\Szc.0713\AppData\Roaming\Typora\typora-user-images\1570611496558.png)

3）RMI步骤

1. 创建远程接口， 并且继承java.rmi.Remote接口
2. 实现远程接口，并且继承：UnicastRemoteObject
3. 创建服务器程序： createRegistry()方法注册远程对象
4. 创建客户端程序 (获取注册信息，调用接口方法)

1.创建服务接口

```java
public interface UserService extends Remote {
 String sayHello(String name) throws RemoteException;
}
```

2.提供接口的实现类

```java
public class UserServiceImpl extends UnicastRemoteObject implements UserService
{
 public UserServiceImpl() throws RemoteException{}
 @Override
 public String sayHello(String name) throws RemoteException{
   return "hello"+name;
 }
}
```

3.将本地服务暴露出去，供外部调用

```java
try {
     UserService userService = new UserServiceImpl();
     LocateRegistry.createRegistry(8888);
     //暴露服务
     Naming.bind("rmi://localhost:8888/UserService", userService);
     System.out.println("提供userService服务。。。。");
   } catch (RemoteException e) {
     e.printStackTrace();
   } catch (AlreadyBoundException e) {
     e.printStackTrace();
   } catch (MalformedURLException e) {
     e.printStackTrace();
   }
```

客户端远程调用服务，客户端需要依赖服务接口

```java
userService = (UserService) Naming.lookup("rmi://localhost:8888/UserService");
//userService代理对象
System.out.println(userService);
System.out.println(userService.sayHello("传智小月"));
```

Hessian

Hessian使用C/S方式，基于HTTP协议传输，使用Hessian二进制序列化。

server端：

1.添加hessian的maven依赖

```xml
    <dependencies>
        <dependency>
            <groupId>com.caucho</groupId>
            <artifactId>hessian</artifactId>
            <version>4.0.7</version>
        </dependency>
    </dependencies>
```

2.创建接口UserService

```java
public interface UserService {
 String sayHello(String name);
}
```

3.实现类

```java
public class UserServiceImpl implements UserService {
 @Override
 public String sayHello(String name){
   return "hello"+name;
 }
}
```

4.web.xml中配置HessianServlet

```xml
<servlet>
 <servlet-name>HessianServlet</servlet-name>
 <servlet-class>com.caucho.hessian.server.HessianServlet</servlet-class>
 <init-param>
  <param-name>service-class</param-name>
  <param-value>com.itheima.demo.impl.UserServiceImpl</param-value>
 </init-param>
</servlet>
<servlet-mapping>
 <servlet-name>HessianServlet</servlet-name>
 <url-pattern>/api/service</url-pattern>
</servlet-mapping>
```

5.添加tomcat7插件启动服务

```xml
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <version>2.2</version>
                <configuration>
                    <port>8888</port>
                    <path>/</path>
                    <uriEncoding>UTF-8</uriEncoding>
                </configuration>
            </plugin>
        </plugins>
    </build>
```

客户端:

1.添加hessian的maven依赖

```xml
   <dependencies>
        <dependency>
            <groupId>com.caucho</groupId>
            <artifactId>hessian</artifactId>
            <version>4.0.7</version>
        </dependency>
    </dependencies>
```

2.创建跟server端相同的接口UserService(同上)

3.创建测试类测试

```java
public class ClientTest {
 public static void main(String[] args) throws MalformedURLException {
   String url = "http://localhost:8888/api/service";
   HessianProxyFactory factory = new HessianProxyFactory();
   UserService api = (UserService) factory.create(UserService.class, url);
   System.out.println(api.sayHello("黑马程序员"));
 }
}
```

Thrift：FaceBook开源RPC框架，典型的CS架构，支持跨语言，客户端和服务端可以使用不同的
语言开发，thrift通过IDL(Interface Description Language)来关联客户端和服务端。

gRPC  google

google
dubbo

### 2、手写RPC框架

基本实现思路：![1570678340244](../AppData/Roaming/Typora/typora-user-images/1570678340244.png)

provider服务提供

consumer服务消费

registry注册

protocol协议



服务提供者：

1、定义服务接口

接口HelloService

```java
public interface HelloService {
 String sayHello(String message);
}
```

2、实现类HelloServiceImpl

```java
public class HelloServiceImpl implements HelloService {
 @Override
 public String sayHello(String name) {
        
        return name+ "调用了myRPC的服务";
    }
}
```

3、服务注册：注册中心

此处注册中心我们将服务注册在map集合中，结构:Map<String,Map<URL,Class>> 外边map的key存储
服务接口的全类名,URL封装了调用服务的ip和port,里边value指定指定具体实现类
注册中心类提供注册服务并暴露服务和发现服务功能：



```java
public class URL {

    private String hostname;
    private Integer port;
    
    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        }
        if(!(obj instanceof  URL)){
            return false;
        }
        URL url = (URL) obj;
        if(hostname.equals(((URL) obj).getHostname())  && port.intValue() == url.port.intValue()){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return hostname.hashCode();
    }
}

```

```java
public class NativeRegistry {


    private static Map<String, Map<URL,Class>> registCenter = new HashMap<>();


    /**
     * 注册服务
     * @param url
     * @param interfaceName
     * @param implClass
     */
    public static void regist(URL url,String interfaceName,Class implClass){

        Map<URL,Class> map = new HashMap<>();
        map.put(url,implClass);
        registCenter.put(interfaceName,map);
    }

    /**
     * 从注册中心获取服务
     * @param url
     * @param interfaceName
     * @return
     */
    public static Class get(URL url,String interfaceName){
        return registCenter.get(interfaceName).get(url);
    }


}
```

注册服务

```java
public class ServiceProvider {

    public static void main(String[] args) {

        //创建URL
        URL url = new URL("localhost", 8080);

        //注册中心中注册服务
        NativeRegistry.regist(url, HelloService.class.getName(), HelloServiceImpl.class);

        //启动并暴露服务
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostname(),url.getPort());

    }
}
```

4、暴露服务

服务之间调用的通信协议采用http协议，所以在服务provider中启动tomcat暴露服务

添加内嵌tomcat的依赖

```xml
  <!--内嵌tomcat-->
    <dependencies>
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-core</artifactId>
            <version>9.0.12</version>
        </dependency>
    </dependencies>
```

创建HttpServer

```java
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

```

DispatcherServlet

```
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new HttpServerHandler().handle(req,resp);
    }
}
```

HttpServerHandler处理远程调用请求

```java
public class HttpServerHandler {


    /**
     *  服务的处理
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void handle(HttpServletRequest req, HttpServletResponse resp){
        try {
            //服务请求的处理逻辑

            //1 通过请求流获取请求服务调用的参数
            InputStream inputStream = req.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            Invocation invocation = (Invocation) objectInputStream.readObject();

            //2 从注册中心获取服务的列表
            Class implCass = NativeRegistry.get(new URL("localhost", 8080), invocation.getInterfaceName());

            //3 调用服务 反射
            Method method = implCass.getMethod(invocation.getMethodName(),invocation.getParamTypes());

            String result = (String) method.invoke(implCass.newInstance(), invocation.getParams());

            //4 结果返回
            IOUtils.write(result,resp.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

}
```

封装调用参数Invocation

```
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invocation implements Serializable {

    private String interfaceName;
    private String methodName;
    private Object[] params;
    private Class[] paramTypes;

}
```

启动服务

```java
public class ServiceProvider {

    public static void main(String[] args) {

        //创建URL
        URL url = new URL("localhost", 8080);

        //注册中心中注册服务
        NativeRegistry.regist(url, HelloService.class.getName(), HelloServiceImpl.class);

        //启动并暴露服务
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostname(),url.getPort());

    }
}
```



4、consumer服务消费端

封装HttpClient对象，发起远程调用j

```java
public class HttpClient {

    /**
     * 远程方法调用
     * @param hostname :远程主机名
     * @param port ：远程端口号
     * @param invocation ：封装远程调用的信息
     */
    public String post(String hostname, int port, Invocation invocation) {


        try {
            URL url = new URL("http", hostname, port, "/client/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);// 必填项

            //发送调用的信息
            OutputStream os = connection.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(invocation);
            oos.flush();
            oos.close();

            // 将输入流转为字符串（此处可是java对象） 获取远程调用的结果
            InputStream is = connection.getInputStream();
            return IOUtils.toString(is);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

}
```

调用测试

```java
public class Consumer {
    

    
    public static void main(String[] args) {

        //封装一个invocation
        Invocation invocation = new Invocation(HelloService.class.getName(), "sayHello2",
                new Object[]{"学IT,来黑马"}, new Class[]{String.class});

        //远程调用服务
        String result = new HttpClient().post("localhost", 8080, invocation);

        System.out.println("远程调用执行的结果result="+result);
    }
}
```

