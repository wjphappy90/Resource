SSH整合：
	我们整合3个版本。
第一个版本：纯XML的整合，但是三个框架都保留自己的主配置文件
第二个版本：纯XML的整合，只保留Struts2和Spring的主配置文件，hibernate主配置文件中的配置都挪到spring中。
第三个版本：XML和注解的组合整合，保留Spring的主配置文件。（struts2的主配置文件，需要时可以加上，不需要的时候可以不写）

我们在CRM中：使用第三个版本作为开发环境。

整合步骤：
1、保证Spring的IOC容器能够在web工程中独立运行				OK
2、保证Hibernate框架能够在web工程中独立运行				OK
3、整合Spring和hibernate							OK
	思路必须清楚：如何才算整合到一起。
	Hibernate框架中的SessionFactory让spring接管创建。
4、保证struts2框架能够在web工程中独立运行
5、整合Struts2和Spring
	如何才算整合到一起？
	让spring接管Action的创建
6、整合优化
	配置优化