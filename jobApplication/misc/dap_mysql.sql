/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.16 : Database - dap
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dap` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dap`;

/*Table structure for table `bug_info` */

DROP TABLE IF EXISTS `bug_info`;

CREATE TABLE `bug_info` (
  `bug_id` int(11) NOT NULL AUTO_INCREMENT,
  `bug_type_id` int(11) DEFAULT NULL,
  `bug_inf_id` int(11) NOT NULL,
  `product` varchar(100) DEFAULT NULL,
  `component` varchar(100) DEFAULT NULL,
  `assignee` varchar(100) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `resolution` varchar(500) DEFAULT NULL,
  `summary` varchar(200) DEFAULT NULL,
  `changed` varchar(100) DEFAULT NULL,
  `attach_1` varchar(200) DEFAULT NULL,
  `attach_2` varchar(200) DEFAULT NULL,
  `attach_3` varchar(200) DEFAULT NULL,
  `attach_4` varchar(200) DEFAULT NULL,
  `attach_5` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`bug_id`),
  KEY `FK_Reference_1` (`bug_type_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`bug_type_id`) REFERENCES `bug_type` (`bug_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bug_info` */

/*Table structure for table `bug_type` */

DROP TABLE IF EXISTS `bug_type`;

CREATE TABLE `bug_type` (
  `bug_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `bug_type_category` varchar(200) DEFAULT NULL,
  `changed` varchar(100) DEFAULT NULL,
  `attach_1` varchar(200) DEFAULT NULL,
  `attach_2` varchar(200) DEFAULT NULL,
  `attach_3` varchar(200) DEFAULT NULL,
  `bug_type_sub_category` varchar(200) DEFAULT NULL,
  `bug_type_sub_number` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`bug_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bug_type` */

/*Table structure for table `bug_type_sub` */

DROP TABLE IF EXISTS `bug_type_sub`;

CREATE TABLE `bug_type_sub` (
  `bug_type_sub_id` int(11) NOT NULL AUTO_INCREMENT,
  `bug_type_sub_category` varchar(200) DEFAULT NULL,
  `changed` varchar(100) DEFAULT NULL,
  `attach_1` varchar(200) DEFAULT NULL,
  `attach_2` varchar(200) DEFAULT NULL,
  `attach_3` varchar(200) DEFAULT NULL,
  `bug_type_id` int(11) DEFAULT NULL,
  `is_selected` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`bug_type_sub_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bug_type_sub` */

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) DEFAULT NULL,
  `user_pass` varchar(36) DEFAULT NULL,
  `user_role` varchar(100) DEFAULT NULL,
  `user_rights` varchar(100) DEFAULT NULL,
  `last_login_date` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `changed` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_info` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
