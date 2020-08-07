1、result标签
	作用及属性
	结果视图分类（全局结果视图/局部结果视图）
2、访问ServletAPI的两种方式（三种？ 一种？）
	ServletAPI：
		HttpServletRequest
		HttpServletResponse
		HttpSession
		ServletContext
3、Struts2中的请求参数封装
	三种封装方式
		属性驱动-没有实体类
		属性驱动-有实体
		模型驱动
	复杂数据类型的封装（集合类型List/Map）

4、案例：使用struts2实现客户的保存

5、请求参数封装失败后处理办法
	a、配置input结果视图，视图路径应该是从哪来回哪去
	b、提示错误信息
	c、把提交的数据回显回来（html标签和struts2标签都可以实现）

关于中文提示的问题：
	I18N ： 国际化   
	Internationalization

复习：
	四大域对象
	EL表达式的取值
	${name} 是怎么找的。调用的是哪个对象的什么方法