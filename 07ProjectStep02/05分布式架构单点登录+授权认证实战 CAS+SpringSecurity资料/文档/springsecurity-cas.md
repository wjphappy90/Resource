##1 构建一个安全的具备单点登录功能的分布式架构SpringSecurity+CAS


##2 课程引导语
互联网已经成为了我们生活一部分，但是安全问题频发，身份认证变得更为复杂。如何让这一部分更安全？如何让这一部分的身份验证变得更简单？

那么在此次课程中，大家会学习到一个全新的安全框架，通过他来做安全控制，同时使用CAS实现用户单点登录功能。


##3 课程介绍 ##
本课程介绍了Spring全家桶中的安全框架SpringSecurity快速入门及使用，介绍CAS的原理，CAS单点登录快速入门，SpringSecurity整合CAS，实现用户安全校验同时实现单点登录。

##4 课程知识点与大纲 ##
 - SpringSecurity CAS
 - SpringSecurity 介绍
 - SpringSecurity入门
 - CAS介绍
 - CAS实现单点登录
 - SpringSecurity+CAS集成实现单点登录

##5 SpringSecurity
###5.1 Spring Security介绍

> 是一个能够为基于Spring的企业应用系统提供声明式的安全访问控制解决方案的安全框架。它提供了一组可以在Spring应用上下文中配置的Bean，充分利用了Spring IoC，DI（控制反转Inversion of Control ,DI:Dependency Injection 依赖注入）和AOP（面向切面编程）功能，为应用系统提供声明式的安全访问控制功能，减少了为企业系统安全控制编写大量重复代码的工作。


###5.2 SpringSecurity入门
我们首先搭建一个web工程，然后引入spring和springsecurity相关依赖，然后基于它做一个入门案例。
####5.2.1 创建一个maven工程(war包)
#####5.2.1.1 导入pom依赖
    <!--Spring和SpringSecurity依赖-->
    <dependencies>
        <!--springmvc-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>4.3.12.RELEASE</version>
        </dependency>
    
        <!-- spring -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jms</artifactId>
            <version>4.3.12.RELEASE</version>
        </dependency>
    
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>4.3.12.RELEASE</version>
        </dependency>
    
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>4.3.12.RELEASE</version>
        </dependency>
    
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aop</artifactId>
            <version>4.3.12.RELEASE</version>
        </dependency>
    
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>4.3.12.RELEASE</version>
        </dependency>
    
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context-support</artifactId>
            <version>4.3.12.RELEASE</version>
        </dependency>
    
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjrt</artifactId>
            <version>1.8.6</version>
        </dependency>
    
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.8.6</version>
        </dependency>
    
        <!--SpringSecurity相关依赖-->
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-web</artifactId>
            <version>4.2.4.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-config</artifactId>
            <version>4.2.4.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-cas</artifactId>
            <version>4.2.4.RELEASE</version>
        </dependency>
    
        <!-- MySql -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.45</version>
        </dependency>
    
        <!--数据连接池-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.0.13</version>
        </dependency>
    </dependencies>

#####5.2.1.2 web.xml配置
    <?xml version="1.0" encoding="UTF-8"?>
    <web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xmlns="http://java.sun.com/xml/ns/javaee"
             xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
             id="WebApp_ID" version="3.0">
      <display-name>springsecurity-demo</display-name>
    
      <!-- 编码过滤器 -->
      <filter>
        <filter-name>characterEncoding</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
          <param-name>encoding</param-name>
          <param-value>UTF-8</param-value>
        </init-param>
        <init-param>
          <param-name>forceEncoding</param-name>
          <param-value>true</param-value>
        </init-param>
      </filter>
    
      <filter-mapping>
        <filter-name>characterEncoding</filter-name>
        <url-pattern>/*</url-pattern>
      </filter-mapping>
      <!--//End 编码过滤器 -->
      <!-- SpringMVC -->
      <servlet>
        <servlet-name>springmvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    
        <init-param>
          <param-name>contextConfigLocation</param-name>
          <param-value>classpath:spring/springmvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
      </servlet>
    
      <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <url-pattern>*.shtml</url-pattern>
      </servlet-mapping>
      <!-- //End SpringMVC -->
    
      <welcome-file-list>
        <welcome-file>index.html</welcome-file>
    	<welcome-file>index.jsp</welcome-file>
      </welcome-file-list>
    </web-app>



#####5.2.1.3 加入SpringSecurity配置
目前为止上面所有的配置只是单纯配置了一个SpringMVC，并没有将SpringSecurity整合进去，那如何整合SpringSecurity呢？首先需要配置一个过滤器，紧接着要配置SpringSecurity相关拦截规则和授权规则即可，我们来配置一次。

 - web.xml中加入SpringSecurity过滤器
   
	     <!--springsecurity过滤器，做资源权限的拦截和验证-->
	     <filter>
	     <filter-name>springSecurityFilterChain</filter-name>
	     <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
	     </filter>
	     <filter-mapping>
	         <filter-name>springSecurityFilterChain</filter-name>
	         <url-pattern>/*</url-pattern>
	     </filter-mapping>


 - spring-security.xml配置文件

	    <?xml version="1.0" encoding="UTF-8"?>
		<beans:beans xmlns="http://www.springframework.org/schema/security"
		             xmlns:beans="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		             xsi:schemaLocation="http://www.springframework.org/schema/beans
		      http://www.springframework.org/schema/beans/spring-beans.xsd
		      http://www.springframework.org/schema/security
		      http://www.springframework.org/schema/security/spring-security-4.2.xsd ">
		
		</beans:beans>

    此时不要忘了在springmvc.xml中引入spring-security.xml
	    
	    <!--引入spring-security.xml-->
	    <import resource="spring-security.xml" />




####5.2.2 Spring Security入门学习
#####5.2.2.1 案例介绍
一般后台管理系统，只有管理员登录之后才有权使用相关功能。例如用户管理，只有管理员登录后而且拥有用户管理的权限，才能对系统中的用户进行增删改查功能。用SpringSecurity如何实现呢？我们做这个案例。


######5.2.2.1.1 创建UserController
创建用户管理的Controller，并加入用户列表功能

    package cn.itcast.controller;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.RequestMapping;
    @Controller
    @RequestMapping(value = "/admin/user")
    public class UserController {
    
        /***
         * 用户管理
         * @return
         */
        @RequestMapping(value = "/list")
        public String list(){
            return "user_list";
        }
    }

######5.2.2.1.2 在/WEB-INF/view/下创建user_list.jsp
为了演示效果，我们这里整点假数据展示

    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>欢迎来到SpringSecurity的世界</title>
    </head>
    <body>
        欢迎来到SpringSecurity的世界!<br />
        <table>
            <tr>
                <td>用户ID</td>
                <td>姓名</td>
                <td>年龄</td>
            </tr>
            <tr>
                <td>1</td>
                <td>张三</td>
                <td>王五</td>
            </tr>
            <tr>
                <td>2</td>
                <td>张三2</td>
                <td>王五</td>
            </tr>
            <tr>
                <td>3</td>
                <td>张三3</td>
                <td>王五</td>
            </tr>
            <tr>
                <td>4</td>
                <td>张三4</td>
                <td>王五</td>
            </tr>
        </table>
    </body>
    </html>

######5.2.2.1.3 实现对/admin开始的请求拦截
在spring-security.xml中配置拦截信息和授权认证管理器


    <http auto-config="true" use-expressions="true">
        <!--所有带有admin的请求都需要ROLE_ADMIN权限-->
        <intercept-url pattern="/admin/**" access="hasRole('ROLE_ADMIN')" />
    </http>
    
    <!--授权认证管理器-->
    <authentication-manager>
    </authentication-manager>

http结点主要配置要拦截的url相关权限规则和处理方案。 <br/>
auto-config =true:默认会配置多个SpringSecurity相关过滤器，如果不配，就不能正常使用SpringSecurity相关功能。<br/>
use-expressions:是否使用SpELl表达式。<br/>
<intercept-url pattern="/**" access="hasRole('ROLE_ADMIN')" />，pattern表示要拦截的路径，可以用通配符表示, * * 表示所有路径。 access表示对应地址访问所需的权限，如果use-expressions="false"access="hasRole('ROLE_ADMIN')"这里的hasRole就可以去掉，我们后面都会设置成false，直接去掉这里的hasRole方便一点。ROLE_ADMIN表示ADMIN角色，这列角色自定义，可以随意定义什么角色，不过注意，这里必须得大写。<br/>



######5.2.2.1.4 发布测试
用tomcat发布测试，端口号根据你本机情况开放，我这里端口是18081
访问  localhost:18081/admin/user/list.shtml的时候跳转到了一个登陆界面，说明拦截配置生效了。

![](https://i.imgur.com/uSwtU1m.png)


######5.2.2.1.5 添加授权用户
接着我们为上面登陆那里添加授权用于，允许他们登陆。修改spring-security.xml，在authentication-manager结点下加入如下代码：

    <authentication-provider>
        <!--硬编码方式提供账号密码-->
        <user-service>
            <user name="admin" authorities="ROLE_ADMIN" password="123456" disabled="false" />
        </user-service>
    </authentication-provider>

这里提供了用户名为admin 密码123456 角色为ROLE_ADMIN的用户，这里的角色必须和上面http里配置的角色保持一致，否则仍然五权限访问。disabled=false表示不禁用也就是启用。这时候我们就可以通过该账号登录访问了。

登录后我们就可以访问http://localhost:18081/admin/user/list.shtml了

![](https://i.imgur.com/ZxBfpSr.png)


#####5.2.2.2 Spring Security常用配置
基于上面的案例我们继续学习SpringSecurity相关知识。


######5.2.2.2.1 取消安全校验
我们网站中常常会有一些静态资源或者不需要校验权限的地址，例如注册和登录，我们在webapp下创建一个images文件夹，在里面放一张图片1.png。像这些地址或者静态资源我们如何取消权限校验呢？在spring-security.xml中加入如下代码：

    <!--不需要过滤的静态资源和开放连接-->
    <http pattern="/images/**" security="none" />
    <http pattern="/login.shtml" security="none" />
    <http pattern="/login/fail.shtml" security="none" />

这时候 http://localhost:18081/images/1.png 就可以访问了。
这时候 http://localhost:18081/images/1.png 就可以访问了。

######5.2.2.2.2 自定义登录页面
刚才那个登录页面不太美观，我们能不能让登录地址跳转到指定页面呢？<br/>
首先我们创建一个登录页面

/WEB-INF/view/login.jsp

    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head><title>登录</title></head>
    <body>
    欢迎登录！
    <form name='f' action='/login' method='POST'>
        <table>
            <tr>
                <td>用户名:</td>
                <td><input type='text' name='username' value=''></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type='password' name='password'/></td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit" value="Login"/></td>
            </tr>
        </table>
    </form>
    </body>
    </html>

LoginController
LoginController

    package cn.itcast.controller;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.RequestMapping;
    @Controller
    public class LoginController {
    
        /***
         * 登录
         * @return
         */
        @RequestMapping(value = "/login")
        public String login(){
            return  "login";
        }
    }

修改spring-security.xml 在http结点中加入如下代码：
修改spring-security.xml 在http结点中加入如下代码：

    <!--自定义登录-->
    <form-login login-page="/login.shtml"
                default-target-url="/admin/user/list.shtml"
                authentication-failure-url="/login/fail.shtml?error"
                username-parameter="username"
                password-parameter="password"
                always-use-default-target="true" />

login-page:自定义登录页url,默认为/login <br/>
default-target-url:默认登录成功后跳转的url<br/>
authentication-failure-url: 登录失败后跳转的url<br/>
username-parameter:用户名的请求字段 默认为userName<br/>
password-parameter:密码的请求字段 默认为password<br/>
always-use-default-target:是否始终使用默认的地址，即登录成功后是否总是跳转到默认地址<br />

再次登录，发现报403错误（如下），是因为SpringSecurity这里做了防csrf攻击校验，我们禁用csrf校验即可。

    HTTP Status 403 – Forbidden
    Type Status Report
    Message Invalid CSRF Token 'null' was found on the request parameter '_csrf' or header 'X-CSRF-TOKEN'.
    Description The server understood the request but refuses to authorize it.
    Apache Tomcat/8.5.16

在http结点加入

    <!--禁用CSRF-->
    <csrf disabled="true" />

######5.2.2.2.3 登录错误信息处理
在LoginController中加一个错误处理方法

    /***
     * 登录失败
     * @return
     */
    @RequestMapping(value = "/login/fail")
    public String loginfail(@RequestParam(value = "error",required = false)String error, Model model){
        if(error!=null){
            model.addAttribute("msg","账号或者密码不对！");
        }
        return  "login";
    }

在登录的jsp回显错误

    <tr>
        <td colspan='2'>
            ${msg}<br />
            <input name="submit" type="submit" value="Login"/>
        </td>
    </tr>


######5.2.2.2.4 数据库中的用户账号密码登录
前面我们一直是写死的用户账号和密码，而真实环境中基本都是从数据库获取账号密码，这个如何实现？

首先创建一个数据库叫springsecurity，接着创建两张表，一张是users表，存放用户信息，另一张是authorities表，存放用户角色信息。


    CREATE TABLE `users` (
      `username` varchar(50) NOT NULL,
      `password` varchar(60) NOT NULL,
      `enabled` varchar(50) NOT NULL,
      PRIMARY KEY (`username`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
    INSERT INTO users(username,password,enabled)VALUES('itcast','123456','true');
    


    CREATE TABLE `authorities` (
	  `username` varchar(50) NOT NULL,
	  `authority` varchar(50) NOT NULL,
	  PRIMARY KEY (`username`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;

	INSERT INTO authorities(username,authority)VALUES('itcast','ROLE_ADMIN');

在spring-security.xml中配置数据源

    <!-- 数据库连接池 -->
    <beans:bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource"
          destroy-method="close">
        <beans:property name="url" value="jdbc:mysql://127.0.0.1:3306/springsecurity?characterEncoding=utf8" />
        <beans:property name="username" value="root" />
        <beans:property name="password" value="123456" />
        <beans:property name="driverClassName" value="com.mysql.jdbc.Driver" />
        <beans:property name="maxActive" value="10" />
        <beans:property name="minIdle" value="5" />
    </beans:bean>


修改springsecurity.xml

    <!--授权认证管理器-->
    <authentication-manager>
        <!--授权提供信息-->
        <authentication-provider>
            <jdbc-user-service data-source-ref="dataSource" users-by-username-query="select username, password, enabled from users where username=?" />
        </authentication-provider>
    </authentication-manager>

这里需要根据用户名去数据库找对应的数据，如果找到了，springsecurity会根据查询的用户账号和密码与用登录输入的账号密码匹配，如果正确，则登录成功，否则失败。


######5.2.2.2.5 加密密码匹配
相对我们开发而言，数据库中的账号密码一般都是密文，刚才我们用的明文，name密文如何处理呢？

配置加密Bean

	<beans:bean id="encoder" class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder">
	        <beans:constructor-arg name="strength" value="9" />
	</beans:bean>

指定加密对象

    <!--授权认证管理器-->
    <authentication-manager>
        <!--授权提供信息-->
        <authentication-provider>
            <!--指定加密算法-->
            <password-encoder ref="encoder" />
            <jdbc-user-service data-source-ref="dataSource" users-by-username-query="select username, password, enabled from users where username=?" />
        </authentication-provider>
    </authentication-manager>

######5.2.2.2.6 登出
登出也就是注销、退出的意思。默认退出地址是/logout，然后跳转到了登录页，但有时候我们希望登出之后跳转到其他页面去，如何实现？

修改spring-security.xml，在http结点加入如下代码

    <!--退出-->
    <logout logout-success-url="/logout.shtml" />

在LoginController加入如下方法

    /***
     * 退出
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(){
        return  "redirect:/images/1.png";
    }

这样用户退出后访问的将是1.png图片。


######5.2.2.2.7 自定义用户登录校验规则
有时候我们的校验规则并非这么简单，当我们需要自定义校验规则时，可以创建一个类，实现UserDetailsService接口来实现。

    package cn.itcast.service;
    import org.springframework.security.core.GrantedAuthority;
    import org.springframework.security.core.authority.SimpleGrantedAuthority;
    import org.springframework.security.core.userdetails.User;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.core.userdetails.UsernameNotFoundException;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import java.util.ArrayList;
    import java.util.List;
    public class UserDetailsServiceImpl implements UserDetailsService {
    
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            //获取密文,这里可以从数据库获取
            String password = new BCryptPasswordEncoder().encode("123456");
    
            //用户授权，可以创建多个角色
            List<GrantedAuthority> grantlist = new ArrayList<GrantedAuthority>();
            grantlist.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            grantlist.add(new SimpleGrantedAuthority("ROLE_USER"));
    
            //第一个参数是用户名，方法直接传入了。
            //第二个参数是数据库查询出的密码，这里我们直接模拟了。
            //第三个参数是用户角色授权信息
            User user = new User(username, password, grantlist);
            return user;
        }
    }

修改spring-security.xml

    <!--自定义校验类-->
    <beans:bean class="cn.itcast.service.UserDetailsServiceImpl" id="userDetailsServiceImpl" />
    
    <!--授权认证管理器-->
    <authentication-manager>
        <!--授权提供信息-->
        <authentication-provider user-service-ref="userDetailsServiceImpl">
            <!--指定加密算法-->
            <password-encoder ref="encoder" />
        </authentication-provider>
    </authentication-manager>
    

##6. CAS

###6.1 CAS介绍

> CAS是一个单点登录框架，由耶鲁大学的一个组织开发。CAS是一个开源项目，代码目前是在github上管理。

> 
单点登录：Single Sign On,简称SSO，SSO使得在多个应用系统中，用户只需要登录一次就可以访问所有相互信任的应用系统。通俗理解为一个应用登录了，其他被授权的应用不用再登录。

> 下载地址：https://github.com/apereo/cas/releases或者https://casinitializr.herokuapp.com

![](https://i.imgur.com/El5o9cW.jpg)


###6.2 CAS服务端搭建
我们案例下载使用的是CAS4.2,采用HTTPS协议处理用户请求。搭建HTTPS需要咱们生成对应的证书信息。流程如下：


####6.2.1 HTTPS搭建
####6.2.1.1 生成秘钥库

我们这里采用JDK自带的工具生成秘钥库。为了方便记，我这里所有口令均输入123456.  其他信息均输入itcast.cn 。


    keytool -genkey -alias itcast -keyalg RSA -keystore D:/workspace/cas/keystory/itcast
    输入密钥库口令:123456
    再次输入新口令:123456
    您的名字与姓氏是什么?
      [Unknown]:  itcast.cn
    您的组织单位名称是什么?
      [Unknown]:  itcast.cn
    您的组织名称是什么?
      [Unknown]:  itcast.cn
    您所在的城市或区域名称是什么?
      [Unknown]:  itcast.cn
    您所在的省/市/自治区名称是什么?
      [Unknown]:  gd
    该单位的双字母国家/地区代码是什么?
      [Unknown]:  zh
    CN=itcast.cn, OU=itcast.cn, O=itcast.cn, L=itcast.cn, ST=gd, C=zh是否正确?
      [否]:  y
    输入 <itcast> 的密钥口令123456
            (如果和密钥库口令相同, 按回车):
    再次输入新口令:123456

导出证书
刚才把秘钥库生成了，紧接着依据秘钥库导出证书。

    C:\Users\Administrator>keytool -export -trustcacerts -alias itcast -file D:/workspace/cas/keystory/itcast.cer -keystore D:/workspace/cas/keystory/itcast
    输入密钥库口令:123456
    存储在文件 <D:/workspace/cas/keystory/itcast.cer> 中的证书
    
    C:\Users\Administrator>

将证书导入到JDK证书库

刚才的操作会根据我们的秘钥库生成一个证书，紧接着我们需要将该证书导入到JDK的证书库里才能使用。

    C:\Users\Administrator>keytool -import -trustcacerts -alias itcast -file D:/workspace/cas/keystory/itcast.cer -keystore "C:/Program Files/Java/jdk1.8.0_91/jre/lib/security/cacerts"
    输入密钥库口令:
    所有者: CN=itcast.cn, OU=itcast.cn, O=itcast.cn, L=sz, ST=gd, C=zh
    发布者: CN=itcast.cn, OU=itcast.cn, O=itcast.cn, L=sz, ST=gd, C=zh
    序列号: 5714b941
    有效期开始日期: Wed Mar 21 14:44:00 CST 2018, 截止日期: Tue Jun 19 14:44:00 CST 2018
    证书指纹:
             MD5: 33:4E:86:6A:91:17:4B:7E:82:26:8F:FD:09:34:EF:CF
             SHA1: CD:EE:46:D3:E7:04:E0:44:23:28:BF:81:84:53:57:0C:DC:59:D3:37
             SHA256: E7:A1:C6:66:02:A1:C5:0F:EA:23:E5:C1:06:55:8E:00:71:6D:E9:E5:21:73:9B:C6:BE:C6:69:71:7A:B8:86:3B
             签名算法名称: SHA256withRSA
             版本: 3
    
    扩展:
    
    #1: ObjectId: 2.5.29.14 Criticality=false
    SubjectKeyIdentifier [
    KeyIdentifier [
    0000: 72 10 76 0A 97 97 5F 90   64 D4 85 2E 81 0E DF A7  r.v..._.d.......
    0010: 8C 1E EE 83                                        ....
    ]
    ]
    
    是否信任此证书? [否]:  y
    证书已添加到密钥库中
    
    C:\Users\Administrator>

####6.2.1.2 tomcat发布CAS服务端项目

1. 解压一个tomcat，放到D:\workspace\cas\目录下，把刚才我们下载的cas解压打开target目录下有个cas.war  拷贝到tomcat的webapps目录并解压，删除war包。 

1. 下载的cas解压目录下还有一个文件target\war\work\org.jasig.cas\cas-server-webapp\WEB-INF\cas.properties，把他拷贝到webapps\cas\WEB-INF目录下。

1. 修改spring-configuration\propertyFileConfigurer.xml，把location="file:/etc/cas/cas.properties"换成刚才cas.properties的绝对路径。

    <util:properties id="casProperties" location="file:D:/workspace/cas/apache-tomcat-8.5.16/webapps/cas/WEB-INF/cas.properties" />



修改tomcat的conf/server.xml，加入如下代码

    <Connector port="443" protocol="org.apache.coyote.http11.Http11NioProtocol"
    	   maxThreads="150" SSLEnabled="true" scheme="https" secure="true"
    	   clientAuth="false" sslProtocol="TLS"
    	   keystoreFile="D:\workspace\cas\keystory\itcast" 
    	   keystorePass="123456" />

启动tomcat

访问https://localhost  出现如下界面说明大功告成！

![](https://i.imgur.com/tHw0LYk.png)

为了让https://itcast.cn  也能正常访问，我们把C:\Windows\System32\drivers\etc\hosts 打开，添加一行代码，让访问itcast.cn时访问本机。

    127.0.0.1 itcast.cn

我们访问https://itcast.cn/cas/login  此时是访问https不是http

![](https://i.imgur.com/Deadive.png)



输入用户名：casuser&nbsp;&nbsp;&nbsp;密码：Mellon &nbsp;登录。

![](https://i.imgur.com/eOGlTyK.png)



####6.2.1.3 配置数据库连接
1. 打开webapps\cas\WEB-INF\deployerConfigContext.xml
2. 把32行的`<alias name="acceptUsersAuthenticationHandler" alias="primaryAuthenticationHandler" />` 注释掉。
3. 将如下代码拷贝到deployerConfigContext.xml中

     	


		<!--配置加密算法-->
		<bean id="MD5PasswordEncoder" class="org.jasig.cas.authentication.handler.DefaultPasswordEncoder" autowire="byName">
			<constructor-arg  value="MD5"/>
		</bean>
		
		<!--查询数据所采用什么加密方式-->
		<bean id="queryDatabaseAuthenticationHandler" name="primaryAuthenticationHandler" class="org.jasig.cas.adaptors.jdbc.QueryDatabaseAuthenticationHandler">
			<property name="passwordEncoder" ref="MD5PasswordEncoder"/>
		</bean>
		
		<!--名字叫dataSource的Bean取别名叫queryDatabaseDataSource-->
		<alias name="dataSource" alias="queryDatabaseDataSource"/>
		
		<!--配置数据源-->
		<bean id="dataSource"
				class="com.mchange.v2.c3p0.ComboPooledDataSource"
				p:driverClass="com.mysql.jdbc.Driver"
				p:jdbcUrl="jdbc:mysql://127.0.0.1:3306/springsecurity?useUnicode=true&amp;characterEncoding=UTF-8&amp;zeroDateTimeBehavior=convertToNull"
				p:user="root"
				p:password="123456"
				p:initialPoolSize="6"
				p:minPoolSize="6"
				p:maxPoolSize="18"
				p:maxIdleTimeExcessConnections="120"
				p:checkoutTimeout="10000"
				p:acquireIncrement="6"
				p:acquireRetryAttempts="5"
				p:acquireRetryDelay="2000"
				p:idleConnectionTestPeriod="30"
				p:preferredTestQuery="select 1"/>
		<!--end  从数据库中的用户表中读取 -->



4. 把如下jar包拷贝到lib下

![](https://i.imgur.com/5NlyuNz.png)

5.配置查询语句

修改cas.properties 220行，去掉注释，修改如下：

    cas.jdbc.authn.query.sql=select password from users where username=?

由于此时我们指定的加密算法为md5了，所以我们需要重新增加一条md5加密的数据到数据库去。
由于此时我们指定的加密算法为md5了，所以我们需要重新增加一条md5加密的数据到数据库去。

    INSERT INTO users(username,password,enabled)VALUES('itheima',(SELECT MD5('123456')),'true');

重启tomcat，用itheima登录成功。



####6.2.2 CSA实现单点登录功能
新建一个maven工程，配置一下CAS相关过滤器，然后访问首页。

pom依赖

    <dependency>
      <groupId>org.jasig.cas.client</groupId>
      <artifactId>cas-client-core</artifactId>
      <version>3.3.3</version>
    </dependency>

web.xml

    <?xml version="1.0" encoding="UTF-8"?>
    <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
             version="3.1">
      <!-- 用于单点退出，该过滤器用于实现单点登出功能，可选配置 -->
      <listener>
        <listener-class>org.jasig.cas.client.session.SingleSignOutHttpSessionListener</listener-class>
      </listener>
      <!-- 该过滤器用于实现单点登出功能，可选配置。 -->
      <filter>
        <filter-name>CAS Single Sign Out Filter</filter-name>
        <filter-class>org.jasig.cas.client.session.SingleSignOutFilter</filter-class>
      </filter>
      <filter-mapping>
        <filter-name>CAS Single Sign Out Filter</filter-name>
        <url-pattern>/*</url-pattern>
      </filter-mapping>
    
      <!-- 该过滤器负责用户的认证工作，必须启用它 -->
      <filter>
        <filter-name>CASFilter</filter-name>
        <filter-class>org.jasig.cas.client.authentication.AuthenticationFilter</filter-class>
        <init-param>
          <param-name>casServerLoginUrl</param-name>
          <param-value>https://itcast.cn/cas/login</param-value>
          <!--这里的server是服务端的IP -->
        </init-param>
        <init-param>
          <param-name>serverName</param-name>
          <param-value>http://localhost:18082</param-value>
        </init-param>
      </filter>
      <filter-mapping>
        <filter-name>CASFilter</filter-name>
        <url-pattern>/*</url-pattern>
      </filter-mapping>
      <!-- 该过滤器负责对Ticket的校验工作，必须启用它 -->
      <filter>
    
        <filter-name>CAS Validation Filter</filter-name>
        <filter-class>org.jasig.cas.client.validation.Cas20ProxyReceivingTicketValidationFilter</filter-class>
        <init-param>
          <param-name>casServerUrlPrefix</param-name>
          <param-value>https://itcast.cn/cas</param-value>
        </init-param>
        <init-param>
          <param-name>serverName</param-name>
          <param-value>http://localhost:18082</param-value>
        </init-param>
      </filter>
      <filter-mapping>
        <filter-name>CAS Validation Filter</filter-name>
        <url-pattern>/*</url-pattern>
      </filter-mapping>
      <!-- 该过滤器负责实现HttpServletRequest请求的包裹， 比如允许开发者通过HttpServletRequest的getRemoteUser()方法获得SSO登录用户的登录名，可选配置。 -->
      <filter>
        <filter-name>CAS HttpServletRequest Wrapper Filter</filter-name>
        <filter-class>
          org.jasig.cas.client.util.HttpServletRequestWrapperFilter
        </filter-class>
      </filter>
      <filter-mapping>
        <filter-name>CAS HttpServletRequest Wrapper Filter</filter-name>
        <url-pattern>/*</url-pattern>
      </filter-mapping>
    
      <!-- 该过滤器使得开发者可以通过org.jasig.cas.client.util.AssertionHolder来获取用户的登录名。 比如AssertionHolder.getAssertion().getPrincipal().getName()。 -->
      <filter>
        <filter-name>CAS Assertion Thread Local Filter</filter-name>
        <filter-class>org.jasig.cas.client.util.AssertionThreadLocalFilter</filter-class>
      </filter>
      <filter-mapping>
        <filter-name>CAS Assertion Thread Local Filter</filter-name>
        <url-pattern>/*</url-pattern>
      </filter-mapping>
    
      <welcome-file-list>
        <welcome-file>index.jsp</welcome-file>
      </welcome-file-list>
    </web-app>

tomcat运行，端口18082

访问报错

![](https://i.imgur.com/LDwd4EQ.png)

上面错误的原因是因为CAS默认值接受HTTPS有IMAPS协议请求的认证，我们需要把HTTP也给加上去。

打开cas\WEB-INF\classes\services\HTTPSandIMAPS-10000001.json，修改第3行

    "serviceId" : "^(https|imaps)://.*",

改成

    "serviceId" : "^(https|imaps|http)://.*",

保存，并重新启动即可。


####6.2.3 拷贝casclient-demo1 进行单点测试
拷贝casclien-demo1  改名casclient-demo2 部署，tomcat端口18083，进行单点测试。一个站点登录后另外一个站点就不需要登录了。


如果运营一旦出现如下错误，请调整tomcat的JDK，和生成秘钥的JDK保持一致，不要用SDK即可。

    java.lang.RuntimeException: javax.net.ssl.SSLHandshakeException: sun.security.validator.ValidatorException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
	org.jasig.cas.client.util.CommonUtils.getResponseFromServer(CommonUtils.java:407)
	org.jasig.cas.client.validation.AbstractCasProtocolUrlBasedTicketValidator.retrieveResponseFromServer(AbstractCasProtocolUrlBasedTicketValidator.java:45)
	org.jasig.cas.client.validation.AbstractUrlBasedTicketValidator.validate(AbstractUrlBasedTicketValidator.java:200)
	org.jasig.cas.client.validation.AbstractTicketValidationFilter.doFilter(AbstractTicketValidationFilter.java:206)
	org.jasig.cas.client.authentication.AuthenticationFilter.doFilter(AuthenticationFilter.java:161)
	org.jasig.cas.client.session.SingleSignOutFilter.doFilter(SingleSignOutFilter.java:100)

	Root Cause
	
	javax.net.ssl.SSLHandshakeException: sun.security.validator.ValidatorException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
		sun.security.ssl.Alerts.getSSLException(Alerts.java:192)
		sun.security.ssl.SSLSocketImpl.fatal(SSLSocketImpl.java:1949)
		sun.security.ssl.Handshaker.fatalSE(Handshaker.java:302)
		sun.security.ssl.Handshaker.fatalSE(Handshaker.java:296)
		sun.security.ssl.ClientHandshaker.serverCertificate(ClientHandshaker.java:1509)
		sun.security.ssl.ClientHandshaker.processMessage(ClientHandshaker.java:216)
		sun.security.ssl.Handshaker.processLoop(Handshaker.java:979)
		sun.security.ssl.Handshaker.process_record(Handshaker.java:914)
		sun.security.ssl.SSLSocketImpl.readRecord(SSLSocketImpl.java:1062)
		sun.security.ssl.SSLSocketImpl.performInitialHandshake(SSLSocketImpl.java:1375)
		sun.security.ssl.SSLSocketImpl.startHandshake(SSLSocketImpl.java:1403)
		sun.security.ssl.SSLSocketImpl.startHandshake(SSLSocketImpl.java:1387)
		sun.net.www.protocol.https.HttpsClient.afterConnect(HttpsClient.java:559)
		sun.net.www.protocol.https.AbstractDelegateHttpsURLConnection.connect(AbstractDelegateHttpsURLConnection.java:185)
		sun.net.www.protocol.http.HttpURLConnection.getInputStream0(HttpURLConnection.java:1513)
		sun.net.www.protocol.http.HttpURLConnection.getInputStream(HttpURLConnection.java:1441)
		sun.net.www.protocol.https.HttpsURLConnectionImpl.getInputStream(HttpsURLConnectionImpl.java:254)
		org.jasig.cas.client.util.CommonUtils.getResponseFromServer(CommonUtils.java:393)
		org.jasig.cas.client.validation.AbstractCasProtocolUrlBasedTicketValidator.retrieveResponseFromServer(AbstractCasProtocolUrlBasedTicketValidator.java:45)
		org.jasig.cas.client.validation.AbstractUrlBasedTicketValidator.validate(AbstractUrlBasedTicketValidator.java:200)
		org.jasig.cas.client.validation.AbstractTicketValidationFilter.doFilter(AbstractTicketValidationFilter.java:206)
		org.jasig.cas.client.authentication.AuthenticationFilter.doFilter(AuthenticationFilter.java:161)
		org.jasig.cas.client.session.SingleSignOutFilter.doFilter(SingleSignOutFilter.java:100)
	
	Root Cause
	
	sun.security.validator.ValidatorException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
		sun.security.validator.PKIXValidator.doBuild(PKIXValidator.java:387)
		sun.security.validator.PKIXValidator.engineValidate(PKIXValidator.java:292)
		sun.security.validator.Validator.validate(Validator.java:260)
		sun.security.ssl.X509TrustManagerImpl.validate(X509TrustManagerImpl.java:324)
		sun.security.ssl.X509TrustManagerImpl.checkTrusted(X509TrustManagerImpl.java:229)
		sun.security.ssl.X509TrustManagerImpl.checkServerTrusted(X509TrustManagerImpl.java:124)
		sun.security.ssl.ClientHandshaker.serverCertificate(ClientHandshaker.java:1491)
		sun.security.ssl.ClientHandshaker.processMessage(ClientHandshaker.java:216)
		sun.security.ssl.Handshaker.processLoop(Handshaker.java:979)
		sun.security.ssl.Handshaker.process_record(Handshaker.java:914)
		sun.security.ssl.SSLSocketImpl.readRecord(SSLSocketImpl.java:1062)
		sun.security.ssl.SSLSocketImpl.performInitialHandshake(SSLSocketImpl.java:1375)
		sun.security.ssl.SSLSocketImpl.startHandshake(SSLSocketImpl.java:1403)
		sun.security.ssl.SSLSocketImpl.startHandshake(SSLSocketImpl.java:1387)
		sun.net.www.protocol.https.HttpsClient.afterConnect(HttpsClient.java:559)
		sun.net.www.protocol.https.AbstractDelegateHttpsURLConnection.connect(AbstractDelegateHttpsURLConnection.java:185)
		sun.net.www.protocol.http.HttpURLConnection.getInputStream0(HttpURLConnection.java:1513)
		sun.net.www.protocol.http.HttpURLConnection.getInputStream(HttpURLConnection.java:1441)
		sun.net.www.protocol.https.HttpsURLConnectionImpl.getInputStream(HttpsURLConnectionImpl.java:254)
		org.jasig.cas.client.util.CommonUtils.getResponseFromServer(CommonUtils.java:393)
		org.jasig.cas.client.validation.AbstractCasProtocolUrlBasedTicketValidator.retrieveResponseFromServer(AbstractCasProtocolUrlBasedTicketValidator.java:45)
		org.jasig.cas.client.validation.AbstractUrlBasedTicketValidator.validate(AbstractUrlBasedTicketValidator.java:200)
		org.jasig.cas.client.validation.AbstractTicketValidationFilter.doFilter(AbstractTicketValidationFilter.java:206)
		org.jasig.cas.client.authentication.AuthenticationFilter.doFilter(AuthenticationFilter.java:161)
		org.jasig.cas.client.session.SingleSignOutFilter.doFilter(SingleSignOutFilter.java:100)



####6.2.4 获取登录名
<%=request.getRemoteUser()%>即可获取登录名。

![](https://i.imgur.com/bhUUziD.png)


##7 Spring Security集成CAS
把刚才的springsecurity-demo复制一份改名springsecurity-cas

pom.xml加入servlet依赖

    <!-- JSP相关 -->
    <dependency>
        <groupId>jstl</groupId>
        <artifactId>jstl</artifactId>
        <version>1.2</version>
    </dependency>
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>servlet-api</artifactId>
        <version>2.5</version>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>jsp-api</artifactId>
        <version>2.0</version>
        <scope>provided</scope>
    </dependency>

修改spring-security.xml

    <?xml version="1.0" encoding="UTF-8"?>
    <beans:beans xmlns="http://www.springframework.org/schema/security"
                 xmlns:beans="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                 xsi:schemaLocation="http://www.springframework.org/schema/beans
          http://www.springframework.org/schema/beans/spring-beans.xsd
          http://www.springframework.org/schema/security
          http://www.springframework.org/schema/security/spring-security-4.2.xsd ">
    
        <!--不需要过滤的静态资源和开放连接-->
        <http pattern="/images/**" security="none" />
    
        <!--   entry-point-ref  入口点引用 -->
        <http use-expressions="false" entry-point-ref="casProcessingFilterEntryPoint">
            <intercept-url pattern="/**" access="ROLE_ADMIN"/>
            <csrf disabled="true"/>
            <!-- custom-filter为过滤器， position 表示将过滤器放在指定的位置上，before表示放在指定位置之前  ，after表示放在指定的位置之后  -->
            <custom-filter ref="casAuthenticationFilter"  position="CAS_FILTER" />
            <custom-filter ref="requestSingleLogoutFilter" before="LOGOUT_FILTER"/>
            <custom-filter ref="singleLogoutFilter" before="CAS_FILTER"/>
        </http>
    
        <!-- CAS入口点 开始 -->
        <beans:bean id="casProcessingFilterEntryPoint" class="org.springframework.security.cas.web.CasAuthenticationEntryPoint">
            <!-- 单点登录服务器登录URL -->
            <beans:property name="loginUrl" value="https://itcast.cn/cas/login"/>
            <beans:property name="serviceProperties" ref="serviceProperties"/>
        </beans:bean>
        <beans:bean id="serviceProperties" class="org.springframework.security.cas.ServiceProperties">
            <!--service 配置自身工程的根地址+/login/cas   -->
            <beans:property name="service" value="http://localhost:18084/login/cas"/>
        </beans:bean>
        <!-- CAS入口点 结束 -->
    
    
        <!-- 认证过滤器 开始 -->
        <beans:bean id="casAuthenticationFilter" class="org.springframework.security.cas.web.CasAuthenticationFilter">
            <beans:property name="authenticationManager" ref="authenticationManager"/>
        </beans:bean>
        <!-- 认证管理器 -->
        <authentication-manager alias="authenticationManager">
            <authentication-provider  ref="casAuthenticationProvider">
            </authentication-provider>
        </authentication-manager>
    
        <!-- 认证提供者 -->
        <beans:bean id="casAuthenticationProvider"     class="org.springframework.security.cas.authentication.CasAuthenticationProvider">
            <beans:property name="authenticationUserDetailsService">
                <beans:bean class="org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper">
                    <beans:constructor-arg ref="userDetailsService" />
                </beans:bean>
            </beans:property>
            <beans:property name="serviceProperties" ref="serviceProperties"/>
            <!-- ticketValidator 为票据验证器 -->
            <beans:property name="ticketValidator">
                <beans:bean class="org.jasig.cas.client.validation.Cas20ServiceTicketValidator">
                    <beans:constructor-arg index="0" value="https://itcast.cn/cas"/>
                </beans:bean>
            </beans:property>
            <beans:property name="key" value="an_id_for_this_auth_provider_only"/>
        </beans:bean>
    
        <!-- 认证类 -->
        <beans:bean id="userDetailsService" class="cn.itcast.service.UserDetailsServiceImpl"/>
        <!-- 认证过滤器 结束 -->
    
    
        <!-- 单点登出  开始  -->
        <beans:bean id="singleLogoutFilter" class="org.jasig.cas.client.session.SingleSignOutFilter"/>
        <!-- 经过此配置，当用户在地址栏输入本地工程 /logout/cas  -->
        <beans:bean id="requestSingleLogoutFilter" class="org.springframework.security.web.authentication.logout.LogoutFilter">
            <beans:constructor-arg value="https://itcast.cn/cas/logout?service=http://localhost:18084/images/1.png"/>
            <beans:constructor-arg>
                <beans:bean class="org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler"/>
            </beans:constructor-arg>
            <beans:property name="filterProcessesUrl" value="/logout/cas"/>
        </beans:bean>
        <!-- 单点登出  结束 -->
    </beans:beans>

获取登录名字

    SecurityContextHolder.getContext().getAuthentication().getName()
