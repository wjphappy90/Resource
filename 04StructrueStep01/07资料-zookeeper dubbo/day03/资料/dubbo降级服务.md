# dubbo降级服务

使用dubbo在进行服务调用时，可能由于各种原因（服务器宕机/网络超时/并发数太高等），调用中就会出现RpcException，调用失败。

服务降级就是指在由于非业务异常导致的服务不可用时（上面举得例子），可以返回默认值，避免异常影响主业务的处理。

# dubbo服务降级配置

### mock 配置方式

dubbo官方文档上使用一个mock配置，实现服务降级。mock只在出现非业务异常(比如超时，网络异常等)时执行。mock的配置支持两种，一种为boolean值，默认的为false。如果配置为true，则缺省使用mock类名，即类名+Mock后缀；另外一种则是配置”return  null”，可以很简单的忽略掉异常。

mock配置在调用方，服务降级不需要对服务方配置产生修改。下面举个例子说明，mock的配置

```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns:dubbo="http://code.alibabatech.com/schema/dubbo"
        xsi:schemaLocation="http://www.springframework.org/schema/beans        http://www.springframework.org/schema/beans/spring-beans.xsd        http://code.alibabatech.com/schema/dubbo        http://code.alibabatech.com/schema/dubbo/dubbo.xsd">
     
        <!-- 消费方应用名，用于计算依赖关系，不是匹配条件，不要与提供方一样 -->
        <dubbo:application name="dubbo-consumer"  />
     
        <dubbo:registry address="zookeeper://127.0.0.1:2181" />
     
        <!-- 生成远程服务代理，可以和本地bean一样使用demoService -->
        <dubbo:reference id="fooService" interface="com.test.service.FooService"  timeout="10000" check="false" mock="return null">
        </dubbo:reference>
     
    </beans>
```

测试在调用端调用服务两个方法，当服务端正常启动时，程序获得正常返回值；当服务提供方没有启动（模拟服务不可用状态）,调用方依然正常运行，调用doSomething2获取返回值时null。

### mock实现接口方式

上面在`<dubbuo:reference>` 中配置`mock="retrun null"` 的配置，在服务降级时会对service中的所有方法做统一处理，即都返回null。但是有的时候我们需要一些方法在服务不可用时告诉我们一些其他信息，以便做其他处理。如更新/删除等。

  配置`mock="true"` ,同时实现mock接口，类名要注意命名规范：接口名+Mock后缀。此时如果调用失败会调用Mock实现。mock实现需要保证有无参的构造方法。

## 整合hystrix 

Hystrix 旨在通过控制那些访问远程系统、服务和第三方库的节点，从而对延迟和故障提供更强大的容错能力。Hystrix具备拥有回退机制和断路器功能的线程和信号隔离，请求缓存和请求打包，以及监控和配置等功能 

1、springboot官方提供了对hystrix的集成，直接在pom.xml里加入依赖

![1571215220532](C:\Users\Szc.0713\AppData\Roaming\Typora\typora-user-images\1571215220532.png)

2、在主程序类上增加注解@EnableHystrix来开启hystrix功能

![1571215246623](C:\Users\Szc.0713\AppData\Roaming\Typora\typora-user-images\1571215246623.png)

3、在服务提供者Provider上增加@HystrixCommand注解，这样调用就会经过Hystrix代理

![1571215463694](C:\Users\Szc.0713\AppData\Roaming\Typora\typora-user-images\1571215463694.png)

4、在服务消费者增加@HystrixCommand注解并指定出错时的回调方法。当调用出错时，会调用fallbackMethod = "hello"里面的指定的hello方法

![1571215497616](C:\Users\Szc.0713\AppData\Roaming\Typora\typora-user-images\1571215497616.png)