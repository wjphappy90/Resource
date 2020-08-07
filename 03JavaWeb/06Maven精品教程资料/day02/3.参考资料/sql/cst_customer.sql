/*
SQLyog v10.2 
MySQL - 5.1.72-community : Database - crm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `cst_customer` */

CREATE TABLE `cst_customer` (
  `cust_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
  `cust_name` varchar(32) NOT NULL COMMENT '客户名称(公司名称)',
  `cust_user_id` bigint(32) DEFAULT NULL COMMENT '负责人id',
  `cust_create_id` bigint(32) DEFAULT NULL COMMENT '创建人id',
  `cust_source` varchar(32) DEFAULT NULL COMMENT '客户信息来源',
  `cust_industry` varchar(32) DEFAULT NULL COMMENT '客户所属行业',
  `cust_level` varchar(32) DEFAULT NULL COMMENT '客户级别',
  `cust_linkman` varchar(64) DEFAULT NULL COMMENT '联系人',
  `cust_phone` varchar(64) DEFAULT NULL COMMENT '固定电话',
  `cust_mobile` varchar(16) DEFAULT NULL COMMENT '移动电话',
  `cust_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `cst_customer` */

LOCK TABLES `cst_customer` WRITE;

insert  into `cst_customer`(`cust_id`,`cust_name`,`cust_user_id`,`cust_create_id`,`cust_source`,`cust_industry`,`cust_level`,`cust_linkman`,`cust_phone`,`cust_mobile`,`cust_createtime`) values (1,'北京传智播客',NULL,NULL,'7',NULL,NULL,NULL,NULL,'1333333',NULL),(6,'北京黑马',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'郑州传智',NULL,NULL,'7','1','23','','','',NULL),(10,'西安黑马',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'哈尔宾黑马',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,'长沙黑马',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(13,'昆明黑马',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(14,'杭州黑马s',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(22,'上海传智播客',NULL,NULL,'6','2','22','黎活明','','',NULL),(23,'山东黑马程序员',NULL,NULL,'7','2','22','王总','','',NULL),(24,'重庆传智播客',NULL,NULL,'7','1','23','张总','43332222','144443333',NULL),(28,'test',NULL,NULL,'6','1','22','','','','2016-03-08 17:22:23'),(29,'重庆黑马',NULL,NULL,'6','2','22','张总','','','2016-03-10 15:22:48');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
