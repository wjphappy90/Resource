1、OGNL表达式的简单使用
	OGNL：对象图导航语言
	OGNL表达式不仅可以获取数据，还可以存数据。
	它可以调用java对象的方法。
	user.name 看上去是字符串，当它执行user对象的getName方法时，表示用OGNL表达式解释。
	使用OGNL表达式获取数据，是我们在开发中经常用的。
	使用OGNL表达式实现给对象的赋值，是struts2框架做的。

	学习完OGNL表达式之后，EL表达式还用不用？
		EL表达式的搜索范围：
			page	request	   session	application
		由小到大逐个搜索，只要找到就不再继续查找
		当使用了Struts2之后，它对request进行了增强，改变了EL表达式的搜索顺序。
		所以结论：我们以后还用EL表达式
2、OGNL上下文-ContextMap
	它是Struts2框架中封装数据最大的容器，封装了我们一次请求可能会用到的所有数据。
	它是一个Map结构。Map的key是String类型，Map的Value是Object类型。
	里面内容包括但不限于如下内容：
	     |
	     |--application	它是一个Map，里面存的是应用域中的所有数据
	     |
	     |--session		它是一个Map，里面存的是会话域中的所有数据
context map--|
	     |--request		它是一个Map，里面存的是请求域中的所有数据
	     |
	     |--value stack(root)	它是一个对象，List结构。（今天的难点）
	     |
	     |--action (the current action)	它是一个对象，表示的是当前执行的Action对象
	     |
	     |--parameters		它是一个Map，里面存的是请求参数。request.getParameterMap()
	     |
	     |--attr (searches page, request, session, then application scopes)
	     |它是一个Map，里面存的是四大域中的数据，并且查找是按照由小到大的顺序找

3、ActionContext以及它和ContextMap的关系
	它是一个工具类，里面提供可以便捷操作ContextMap的方法。
	ActionContext的创建时间点： 每次请求都会创建新的。放在了Struts2的核心过滤器中的doFilter方法
	由于java ee应用是多线的，它通过把ActionContext绑定到ThreadLocal上实现了线程同步。
	我们通过代码得知，要想获取该对象，需要调用ActionContext的静态方法getContext()从当前线程上获取
4、ValueStack对象的使用
	它也是一个工具类。它是一个List结构。
5、Struts2中EL表达式的使用

各种符号总结：
	%：
	  1、把OGNL表达式转成普通字符串 %{""}
	  2、把字符串转成OGNL表达式%{}
	#：
	  1、获取ContextMap中的数据。#key
	  2、在页面中可以创建Map集合。 #{}
	$：
	  1、EL表达式使用
	  2、可以在struts2的配置中使用OGNL表达式（配置可以是xml文件，也可以是注解）${}
6、案例：使用OGNL表达式获取客户列表展示