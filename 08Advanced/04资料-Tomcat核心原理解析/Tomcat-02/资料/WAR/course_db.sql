/*
SQLyog v10.2 
MySQL - 5.5.40 : Database - db4
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`course_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `course_db`;

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `teacher_name` varchar(200) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `createuser` int(11) DEFAULT NULL,
  `updateuser` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`id`,`name`,`teacher_name`,`price`,`description`,`createtime`,`updatetime`,`createuser`,`updateuser`) values (3,'PHP从入门到精通','风清扬',199.00,'适合零基础的学员','2019-05-27 10:23:31','2019-05-28 18:52:21',1,5),(4,'Python从入门到精通','风清扬',199.00,'适合零基础的学员','2019-05-27 10:23:32','2019-05-27 13:23:00',1,5),(5,'PhotoShop从入门到精通','令狐冲',199.00,'适合零基础的学员','2019-05-27 10:23:32','2019-07-14 18:59:34',1,10000),(6,'Spring从入门到精通','令狐冲',199.00,'适合零基础的学员','2019-05-27 10:23:32','2019-07-14 18:59:46',1,10000),(7,'Solr从入门到精通','令狐冲',199.00,'适合零基础的学员','2019-05-27 10:23:32','2019-07-14 18:59:51',1,10000),(8,'Redis从入门到精通','田伯光',199.00,'适合零基础的学员','2019-05-27 10:23:32','2019-07-14 19:00:01',1,10000),(9,'ElasticSearch从入门到精通','田伯光',199.00,'适合零基础的学员','2019-05-27 10:23:33','2019-07-14 19:00:09',1,10000),(10,'MySQL从入门到精通','田伯光',199.00,'适合零基础的学员','2019-05-27 10:23:33','2019-07-14 19:00:14',1,10000),(11,'JVM从入门到精通','东方兄弟',199.00,'适合零基础的学员','2019-05-27 10:23:33','2019-07-14 19:00:29',1,10000),(12,'Linux从入门到精通','东方兄弟',199.00,'适合零基础的学员','2019-05-27 10:23:33','2019-07-14 19:00:33',1,10000),(13,'Shell从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:33','2019-05-27 10:23:33',1,1),(14,'Netty从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:34','2019-05-27 10:23:34',1,1),(15,'Mina从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:34','2019-05-27 10:23:34',1,1),(16,'SpringBoot从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:34','2019-05-27 10:23:34',1,1),(17,'SpringCloud从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:34','2019-05-27 10:23:34',1,1),(18,'Web从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:34','2019-05-27 10:23:34',1,1),(19,'HTML从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:35','2019-05-27 10:23:35',1,1),(20,'RocketMQ从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:35','2019-05-27 10:23:35',1,1),(21,'AcitveMQ从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:35','2019-05-27 10:23:35',1,1),(22,'RabbitMQ从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:35','2019-05-27 10:23:35',1,1),(23,'Kafka从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:35','2019-05-27 10:23:35',1,1),(24,'FastDFS从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:35','2019-05-27 10:23:35',1,1),(25,'Hive从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:36','2019-05-27 10:23:36',1,1),(26,'Lucene高级','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:36','2019-05-27 13:21:56',1,5),(27,'秒杀终极解决方案','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:36','2019-05-27 13:22:25',1,5),(28,'Java从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:36','2019-05-27 10:23:36',1,1),(29,'Java从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:36','2019-05-27 10:23:36',1,1),(30,'Java从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:37','2019-05-27 10:23:37',1,1),(31,'Java从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:37','2019-05-27 10:23:37',1,1),(32,'Java从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:37','2019-05-27 10:23:37',1,1),(33,'Java从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:37','2019-05-27 10:23:37',1,1),(34,'Java从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:37','2019-05-27 22:38:05',1,5),(35,'Java从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:37','2019-05-27 10:23:37',1,1),(36,'Java从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:38','2019-05-27 10:23:38',1,1),(37,'Java从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:38','2019-05-27 10:23:38',1,1),(38,'Java从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:38','2019-05-27 10:23:38',1,1),(39,'Java从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:38','2019-05-27 22:38:10',1,5),(40,'Java从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:38','2019-05-27 10:23:38',1,1),(41,'Java从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:39','2019-05-27 10:23:39',1,1),(42,'Java从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:39','2019-05-27 10:23:39',1,1),(43,'Java从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:39','2019-05-27 10:23:39',1,1),(44,'Java从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:39','2019-05-27 10:23:39',1,1),(45,'Java从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:39','2019-05-27 10:23:39',1,1),(46,'Java从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:40','2019-05-27 10:23:40',1,1),(47,'Java从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:40','2019-05-27 10:23:40',1,1),(48,'Java从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:40','2019-05-27 10:23:40',1,1),(49,'Java从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:40','2019-05-27 10:23:40',1,1),(50,'Java从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:40','2019-05-27 10:23:40',1,1),(51,'Java从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:40','2019-05-27 10:23:40',1,1),(52,'Java从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:41','2019-05-27 10:23:41',1,1),(53,'Java从入门到精通','Robin',199.00,'适合零基础的学员','2019-05-27 10:23:41','2019-05-27 10:23:41',1,1),(59,'深入浅出MYSQL','唐汉明',288.00,'本课程涵盖了MySQL的基础, 高级 , 运维方面的知识 .','2019-05-27 12:52:54','2019-05-27 12:52:54',5,5),(60,'Mybatis高级','田伯光',199.00,'适合Mybatis有一定基础的同学学习','2019-05-27 17:08:06','2019-05-27 17:08:06',5,5),(61,'JavaScript高级','Flum',899.00,'高级部分的JavaScript','2019-05-27 22:41:17','2019-05-27 22:41:17',5,5),(62,'CSS深入原理解析','Rose',199.00,'CSS深入原理解析','2019-05-27 22:53:17','2019-05-27 22:53:17',8,8);

/*Table structure for table `emp` */

DROP TABLE IF EXISTS `emp`;

CREATE TABLE `emp` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `job_id` int(11) DEFAULT NULL,
  `mgr` int(11) DEFAULT NULL,
  `joindate` date DEFAULT NULL,
  `salary` decimal(7,2) DEFAULT NULL,
  `bonus` decimal(7,2) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `emp` */

insert  into `emp`(`id`,`name`,`job_id`,`mgr`,`joindate`,`salary`,`bonus`,`dept_id`) values (1001,'孙悟空',4,1004,'2000-12-17','8000.00',NULL,20),(1002,'卢俊义',3,1006,'2001-02-20','16000.00','3000.00',30),(1003,'林冲',3,1006,'2001-02-22','12500.00','5000.00',30),(1004,'唐僧',2,1009,'2001-04-02','29750.00',NULL,20),(1005,'李逵',4,1006,'2001-09-28','12500.00','14000.00',30),(1006,'宋江',2,1009,'2001-05-01','28500.00',NULL,30),(1007,'刘备',2,1009,'2001-09-01','24500.00',NULL,10),(1008,'猪八戒',4,1004,'2007-04-19','30000.00',NULL,20),(1009,'罗贯中',1,NULL,'2001-11-17','50000.00',NULL,10),(1010,'吴用',3,1006,'2001-09-08','15000.00','0.00',30),(1011,'沙僧',4,1004,'2007-05-23','11000.00',NULL,20),(1012,'李逵',4,1006,'2001-12-03','9500.00',NULL,30),(1013,'小白龙',4,1004,'2001-12-03','30000.00',NULL,20),(1014,'关羽',4,1007,'2002-01-23','13000.00',NULL,10);

/*Table structure for table `operation_log` */

DROP TABLE IF EXISTS `operation_log`;

CREATE TABLE `operation_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `operate_class` varchar(200) DEFAULT NULL COMMENT '操作类',
  `operate_method` varchar(200) DEFAULT NULL COMMENT '操作方法',
  `param_and_value` varchar(500) DEFAULT NULL COMMENT '请求参数名及参数值',
  `return_class` varchar(200) DEFAULT NULL COMMENT '返回值类型',
  `return_value` text COMMENT '返回值',
  `cost_time` bigint(20) DEFAULT NULL COMMENT '执行方法耗时, 单位 ms',
  `operate_user` int(11) DEFAULT NULL COMMENT '操作用户',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;

/*Data for the table `operation_log` */

insert  into `operation_log`(`id`,`operate_class`,`operate_method`,`param_and_value`,`return_class`,`return_value`,`cost_time`,`operate_user`,`operate_time`) values (1,'cn.itcast.controller.CourseController','findOne','[3]','cn.itcast.pojo.Course','Course(id=3, name=PHP从入门到精通, teacherName=风清扬, price=199.0, description=适合零基础的学员, createtime=Mon May 27 10:23:31 CST 2019, updatetime=Mon May 27 13:22:52 CST 2019, createuser=1, updateuser=5)',12,5,'2019-05-28 18:51:48'),(2,'cn.itcast.controller.CourseController','update','[Course(id=3, name=PHP从入门到精通, teacherName=风清扬, price=199.0, description=适合零基础的学员, createtime=Mon May 27 10:23:31 CST 2019, updatetime=Mon May 27 13:22:52 CST 2019, createuser=1, updateuser=5)]','cn.itcast.common.Result','Result(success=true, message=操作成功)',21,5,'2019-05-28 18:52:21'),(3,'cn.itcast.controller.CourseController','findOne','[3]','cn.itcast.pojo.Course','Course(id=3, name=PHP从入门到精通, teacherName=风清扬, price=199.0, description=适合零基础的学员, createtime=Mon May 27 10:23:31 CST 2019, updatetime=Tue May 28 18:52:21 CST 2019, createuser=1, updateuser=5)',11,5,'2019-07-14 18:40:37'),(4,'cn.itcast.controller.CourseController','findOne','[3]','cn.itcast.pojo.Course','Course(id=3, name=PHP从入门到精通, teacherName=风清扬, price=199.0, description=适合零基础的学员, createtime=Mon May 27 10:23:31 CST 2019, updatetime=Tue May 28 18:52:21 CST 2019, createuser=1, updateuser=5)',10,5,'2019-07-14 18:40:39'),(5,'cn.itcast.controller.CourseController','findOne','[5]','cn.itcast.pojo.Course','Course(id=5, name=PhotoShop从入门到精通, teacherName=Robin, price=199.0, description=适合零基础的学员, createtime=Mon May 27 10:23:32 CST 2019, updatetime=Mon May 27 10:23:32 CST 2019, createuser=1, updateuser=1)',10,10000,'2019-07-14 18:59:26'),(6,'cn.itcast.controller.CourseController','update','[Course(id=5, name=PhotoShop从入门到精通, teacherName=令狐冲, price=199.0, description=适合零基础的学员, createtime=Mon May 27 10:23:32 CST 2019, updatetime=Mon May 27 10:23:32 CST 2019, createuser=1, updateuser=1)]','cn.itcast.common.Result','Result(success=true, message=操作成功)',18,10000,'2019-07-14 18:59:34'),(7,'cn.itcast.controller.CourseController','findOne','[6]','cn.itcast.pojo.Course','Course(id=6, name=Spring从入门到精通, teacherName=Robin, price=199.0, description=适合零基础的学员, createtime=Mon May 27 10:23:32 CST 2019, updatetime=Mon May 27 10:23:32 CST 2019, createuser=1, updateuser=1)',8,10000,'2019-07-14 18:59:37'),(8,'cn.itcast.controller.CourseController','update','[Course(id=6, name=Spring从入门到精通, teacherName=令狐冲, price=199.0, description=适合零基础的学员, createtime=Mon May 27 10:23:32 CST 2019, updatetime=Mon May 27 10:23:32 CST 2019, createuser=1, updateuser=1)]','cn.itcast.common.Result','Result(success=true, message=操作成功)',15,10000,'2019-07-14 18:59:46'),(9,'cn.itcast.controller.CourseController','findOne','[7]','cn.itcast.pojo.Course','Course(id=7, name=Solr从入门到精通, teacherName=Robin, price=199.0, description=适合零基础的学员, createtime=Mon May 27 10:23:32 CST 2019, updatetime=Mon May 27 10:23:32 CST 2019, createuser=1, updateuser=1)',8,10000,'2019-07-14 18:59:49'),(10,'cn.itcast.controller.CourseController','update','[Course(id=7, name=Solr从入门到精通, teacherName=令狐冲, price=199.0, description=适合零基础的学员, createtime=Mon May 27 10:23:32 CST 2019, updatetime=Mon May 27 10:23:32 CST 2019, createuser=1, updateuser=1)]','cn.itcast.common.Result','Result(success=true, message=操作成功)',10,10000,'2019-07-14 18:59:51'),(11,'cn.itcast.controller.CourseController','findOne','[8]','cn.itcast.pojo.Course','Course(id=8, name=Redis从入门到精通, teacherName=Jerry, price=199.0, description=适合零基础的学员, createtime=Mon May 27 10:23:32 CST 2019, updatetime=Mon May 27 13:23:16 CST 2019, createuser=1, updateuser=5)',9,10000,'2019-07-14 18:59:55'),(12,'cn.itcast.controller.CourseController','update','[Course(id=8, name=Redis从入门到精通, teacherName=田伯光, price=199.0, description=适合零基础的学员, createtime=Mon May 27 10:23:32 CST 2019, updatetime=Mon May 27 13:23:16 CST 2019, createuser=1, updateuser=5)]','cn.itcast.common.Result','Result(success=true, message=操作成功)',12,10000,'2019-07-14 19:00:01'),(13,'cn.itcast.controller.CourseController','findOne','[8]','cn.itcast.pojo.Course','Course(id=8, name=Redis从入门到精通, teacherName=田伯光, price=199.0, description=适合零基础的学员, createtime=Mon May 27 10:23:32 CST 2019, updatetime=Sun Jul 14 19:00:01 CST 2019, createuser=1, updateuser=10000)',7,10000,'2019-07-14 19:00:04'),(14,'cn.itcast.controller.CourseController','findOne','[9]','cn.itcast.pojo.Course','Course(id=9, name=ElasticSearch从入门到精通, teacherName=Jerry, price=199.0, description=适合零基础的学员, createtime=Mon May 27 10:23:33 CST 2019, updatetime=Mon May 27 13:23:22 CST 2019, createuser=1, updateuser=5)',7,10000,'2019-07-14 19:00:07'),(15,'cn.itcast.controller.CourseController','update','[Course(id=9, name=ElasticSearch从入门到精通, teacherName=田伯光, price=199.0, description=适合零基础的学员, createtime=Mon May 27 10:23:33 CST 2019, updatetime=Mon May 27 13:23:22 CST 2019, createuser=1, updateuser=5)]','cn.itcast.common.Result','Result(success=true, message=操作成功)',13,10000,'2019-07-14 19:00:09'),(16,'cn.itcast.controller.CourseController','findOne','[10]','cn.itcast.pojo.Course','Course(id=10, name=MySQL从入门到精通, teacherName=Robin, price=199.0, description=适合零基础的学员, createtime=Mon May 27 10:23:33 CST 2019, updatetime=Mon May 27 10:23:33 CST 2019, createuser=1, updateuser=1)',7,10000,'2019-07-14 19:00:12'),(17,'cn.itcast.controller.CourseController','update','[Course(id=10, name=MySQL从入门到精通, teacherName=田伯光, price=199.0, description=适合零基础的学员, createtime=Mon May 27 10:23:33 CST 2019, updatetime=Mon May 27 10:23:33 CST 2019, createuser=1, updateuser=1)]','cn.itcast.common.Result','Result(success=true, message=操作成功)',15,10000,'2019-07-14 19:00:14'),(18,'cn.itcast.controller.CourseController','findOne','[10]','cn.itcast.pojo.Course','Course(id=10, name=MySQL从入门到精通, teacherName=田伯光, price=199.0, description=适合零基础的学员, createtime=Mon May 27 10:23:33 CST 2019, updatetime=Sun Jul 14 19:00:14 CST 2019, createuser=1, updateuser=10000)',7,10000,'2019-07-14 19:00:16'),(19,'cn.itcast.controller.CourseController','findOne','[11]','cn.itcast.pojo.Course','Course(id=11, name=JVM从入门到精通, teacherName=Robin, price=199.0, description=适合零基础的学员, createtime=Mon May 27 10:23:33 CST 2019, updatetime=Mon May 27 10:23:33 CST 2019, createuser=1, updateuser=1)',7,10000,'2019-07-14 19:00:18'),(20,'cn.itcast.controller.CourseController','update','[Course(id=11, name=JVM从入门到精通, teacherName=东方兄弟, price=199.0, description=适合零基础的学员, createtime=Mon May 27 10:23:33 CST 2019, updatetime=Mon May 27 10:23:33 CST 2019, createuser=1, updateuser=1)]','cn.itcast.common.Result','Result(success=true, message=操作成功)',15,10000,'2019-07-14 19:00:29'),(21,'cn.itcast.controller.CourseController','findOne','[12]','cn.itcast.pojo.Course','Course(id=12, name=Linux从入门到精通, teacherName=Robin, price=199.0, description=适合零基础的学员, createtime=Mon May 27 10:23:33 CST 2019, updatetime=Mon May 27 10:23:33 CST 2019, createuser=1, updateuser=1)',7,10000,'2019-07-14 19:00:31'),(22,'cn.itcast.controller.CourseController','update','[Course(id=12, name=Linux从入门到精通, teacherName=东方兄弟, price=199.0, description=适合零基础的学员, createtime=Mon May 27 10:23:33 CST 2019, updatetime=Mon May 27 10:23:33 CST 2019, createuser=1, updateuser=1)]','cn.itcast.common.Result','Result(success=true, message=操作成功)',12,10000,'2019-07-14 19:00:33'),(23,'cn.itcast.controller.CourseController','findOne','[3]','cn.itcast.pojo.Course','Course(id=3, name=PHP从入门到精通, teacherName=风清扬, price=199.0, description=适合零基础的学员, createtime=Mon May 27 10:23:31 CST 2019, updatetime=Tue May 28 18:52:21 CST 2019, createuser=1, updateuser=5)',6,10000,'2019-07-14 19:00:42');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(32) NOT NULL,
  `salt` varchar(10) DEFAULT NULL,
  `gender` char(1) DEFAULT '1' COMMENT '1 男 , 2 女',
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`salt`,`gender`,`createtime`) values (5,'itcast','8a709df95c82857b40724b41f7532f20','Q','1','2019-05-22 18:16:27'),(6,'itcast1','6c550abb3e82ac166aeb3a45646c10e9','f7zs','1','2019-05-22 18:24:26'),(7,'tom','46f1543367a86f4bac8af1002de63ddd','j1p','1','2019-05-24 20:33:47'),(8,'itheima','c647d0875ae54210b3b4838133c4cda9','ffl','1','2019-05-27 22:52:33');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
