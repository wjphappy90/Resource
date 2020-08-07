/*
SQLyog Ultimate v8.32 
MySQL - 5.5.27 : Database - jquerydatatable
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jquerydatatable` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jquerydatatable`;

/*Table structure for table `product` */

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`id`,`name`,`price`) values (1,'苹果','3.00');
insert  into `product`(`id`,`name`,`price`) values (2,'香蕉','3.00');
insert  into `product`(`id`,`name`,`price`) values (3,'葡萄','10.99');
insert  into `product`(`id`,`name`,`price`) values (4,'草莓','15.00');
insert  into `product`(`id`,`name`,`price`) values (5,'提子','8.0');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
