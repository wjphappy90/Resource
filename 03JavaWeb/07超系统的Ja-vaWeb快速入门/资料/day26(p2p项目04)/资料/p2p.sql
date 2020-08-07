/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.5.49 : Database - p2p
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`p2p` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `p2p`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `total` double DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `interest` double DEFAULT NULL,
  `c_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `c_id` (`c_id`),
  CONSTRAINT `account_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `email_status` int(11) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;



/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proNum` varchar(20) DEFAULT NULL,
  `proName` varchar(20) DEFAULT NULL,
  `proLimit` int(11) DEFAULT NULL,
  `annualized` double DEFAULT NULL,
  `releaseDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;


/*Table structure for table `product_account` */

DROP TABLE IF EXISTS `product_account`;

CREATE TABLE `product_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pa_num` varchar(20) DEFAULT NULL,
  `pa_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `c_id` int(11) DEFAULT NULL,
  `p_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `c_id` (`c_id`),
  KEY `p_id` (`p_id`),
  CONSTRAINT `product_account_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `product_account_ibfk_2` FOREIGN KEY (`p_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product_account` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


