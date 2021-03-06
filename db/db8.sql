/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.4.13-MariaDB : Database - db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `db`;

/*Table structure for table `_like` */

DROP TABLE IF EXISTS `_like`;

CREATE TABLE `_like` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `date_created` date DEFAULT NULL,
  `like_status_id` bigint(20) unsigned DEFAULT NULL,
  `post_id` bigint(20) unsigned DEFAULT NULL,
  `comment_id` bigint(20) unsigned DEFAULT NULL,
  `user_id` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `like_ibfk_1` (`post_id`),
  KEY `like_ibfk_2` (`comment_id`),
  KEY `like_ibfk_3` (`user_id`),
  KEY `like_status_id` (`like_status_id`),
  CONSTRAINT `_like_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `_like_ibfk_2` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `_like_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `_like_ibfk_4` FOREIGN KEY (`like_status_id`) REFERENCES `like_status` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

/*Data for the table `_like` */

insert  into `_like`(`id`,`date_created`,`like_status_id`,`post_id`,`comment_id`,`user_id`) values (1,'2020-09-02',1,1,NULL,2),(2,'2020-07-13',2,2,NULL,1),(3,'2020-07-30',1,NULL,1,3),(8,'2020-08-18',2,NULL,1,2),(9,NULL,1,NULL,2,2);

/*Table structure for table `attachment` */

DROP TABLE IF EXISTS `attachment`;

CREATE TABLE `attachment` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `comment_id` bigint(20) unsigned DEFAULT NULL,
  `post_id` bigint(20) unsigned DEFAULT NULL,
  `user_id` bigint(20) unsigned DEFAULT NULL,
  `channel_id` bigint(20) unsigned DEFAULT NULL,
  `url` varchar(1000) DEFAULT NULL,
  `original_name` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `attachment_ibfk_1` (`comment_id`),
  KEY `attachment_ibfk_2` (`post_id`),
  KEY `attachment_ibfk_3` (`user_id`),
  KEY `attachment_ibfk_4` (`channel_id`),
  CONSTRAINT `attachment_ibfk_1` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `attachment_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `attachment_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `attachment_ibfk_4` FOREIGN KEY (`channel_id`) REFERENCES `channel` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;

/*Data for the table `attachment` */

insert  into `attachment`(`id`,`comment_id`,`post_id`,`user_id`,`channel_id`,`url`,`original_name`) values (16,14,NULL,2,NULL,'C:\\Users\\siux\\DiplomskiAplikacija\\comment\\14\\attachments\\Fo4_Gun_Nut (8) (1) (2) (1) (1).png','Fo4_Gun_Nut (8) (1) (2) (1) (1).png'),(17,NULL,2,2,NULL,'C:\\Users\\siux\\DiplomskiAplikacija\\post\\2\\attachments\\Fo4_Gun_Nut (8) (1) (2) (1) (1).png','Fo4_Gun_Nut (8) (1) (2) (1) (1).png'),(19,12,NULL,2,NULL,'C:\\Users\\siux\\DiplomskiAplikacija\\comment\\12\\attachments\\Fo4_Gun_Nut (8) (1) (2) (1) (1) (1).png','Fo4_Gun_Nut (8) (1) (2) (1) (1) (1).png'),(20,15,NULL,2,NULL,'C:\\Users\\siux\\DiplomskiAplikacija\\comment\\15\\attachments\\Fo4_Gun_Nut (8) (1) (2) (1).png','Fo4_Gun_Nut (8) (1) (2) (1).png'),(21,NULL,2,2,NULL,'C:\\Users\\siux\\DiplomskiAplikacija\\post\\2\\attachments\\vault-boy-login.jpg','vault-boy-login.jpg'),(22,NULL,4,2,NULL,'C:\\Users\\siux\\DiplomskiAplikacija\\post\\4\\attachments\\Fo4_Armorer.png','Fo4_Armorer.png'),(23,NULL,4,2,NULL,'C:\\Users\\siux\\DiplomskiAplikacija\\post\\4\\attachments\\Fo4_Gun_Nut.png','Fo4_Gun_Nut.png'),(24,16,NULL,2,NULL,'C:\\Users\\siux\\DiplomskiAplikacija\\comment\\16\\attachments\\Fo4_Cap_Collector.png','Fo4_Cap_Collector.png'),(26,17,NULL,2,NULL,'C:\\Users\\siux\\DiplomskiAplikacija\\comment\\17\\attachments\\Fo4_Gun_Nut.png','Fo4_Gun_Nut.png');

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `category` */

insert  into `category`(`id`,`name`) values (1,'Osnovne Studije'),(2,'Master');

/*Table structure for table `channel` */

DROP TABLE IF EXISTS `channel`;

CREATE TABLE `channel` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `date_created` date DEFAULT NULL,
  `category_id` bigint(20) unsigned DEFAULT NULL,
  `channel_status_id` bigint(20) unsigned DEFAULT NULL,
  `communication_direction_id` bigint(20) unsigned DEFAULT NULL,
  `channel_id` bigint(20) unsigned DEFAULT NULL,
  `profile_picture_url` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `channel_ibfk_1` (`channel_id`),
  KEY `channel_ibfk_2` (`communication_direction_id`),
  KEY `channel_ibfk_4` (`category_id`),
  KEY `channel_ibfk_3` (`channel_status_id`),
  CONSTRAINT `channel_ibfk_1` FOREIGN KEY (`channel_id`) REFERENCES `channel` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `channel_ibfk_2` FOREIGN KEY (`communication_direction_id`) REFERENCES `communication_direction` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `channel_ibfk_4` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `channel_ibfk_5` FOREIGN KEY (`channel_status_id`) REFERENCES `channel_status` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;

/*Data for the table `channel` */

insert  into `channel`(`id`,`name`,`date_created`,`category_id`,`channel_status_id`,`communication_direction_id`,`channel_id`,`profile_picture_url`) values (2,'Java','2020-07-13',1,1,2,NULL,'C:\\Users\\siux\\DiplomskiAplikacija\\channel\\1\\profile\\Fo4_Cap_Collector.png'),(3,'Swing','2020-07-13',1,3,1,2,'C:\\Users\\siux\\DiplomskiAplikacija\\channel\\2\\profile\\Fo4_Gun_Nut (8) (1) (2) (1).png');

/*Table structure for table `channel_role` */

DROP TABLE IF EXISTS `channel_role`;

CREATE TABLE `channel_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `channel_role` */

insert  into `channel_role`(`id`,`name`) values (1,'Participant'),(2,'Owner');

/*Table structure for table `channel_status` */

DROP TABLE IF EXISTS `channel_status`;

CREATE TABLE `channel_status` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `channel_status` */

insert  into `channel_status`(`id`,`name`) values (1,'Active'),(2,'Closed'),(3,'On Hold');

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `text` varchar(1000) DEFAULT NULL,
  `date_created` date DEFAULT NULL,
  `date_last_modified` date DEFAULT NULL,
  `user_id` bigint(20) unsigned DEFAULT NULL,
  `comment_status_id` bigint(20) unsigned DEFAULT NULL,
  `post_id` bigint(20) unsigned DEFAULT NULL,
  `comment_id` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `comment_id` (`comment_id`),
  KEY `comment_ibfk_1` (`user_id`),
  KEY `comment_ibfk_2` (`comment_status_id`),
  KEY `comment_ibfk_3` (`post_id`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`comment_status_id`) REFERENCES `comment_status` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `comment_ibfk_3` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_ibfk_4` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

/*Data for the table `comment` */

insert  into `comment`(`id`,`text`,`date_created`,`date_last_modified`,`user_id`,`comment_status_id`,`post_id`,`comment_id`) values (1,'Awesome!','2020-07-13','2020-08-18',2,3,1,NULL),(2,'Yes, so good!','2020-07-13','2020-08-18',1,3,1,NULL),(12,'asd sdadsadasdsa',NULL,'2020-09-02',2,3,1,NULL),(13,'replay1',NULL,NULL,2,3,NULL,NULL),(14,'Bravo','2020-09-02','2020-09-02',2,3,1,NULL),(15,'MMM','2020-09-02','2020-09-02',2,3,NULL,14),(16,'Rst aaaaaaaaa','2020-09-03','2020-09-03',2,3,4,NULL),(17,'aaaa Rst bbbbb','2020-09-03','2020-09-03',2,3,NULL,16);

/*Table structure for table `comment_status` */

DROP TABLE IF EXISTS `comment_status`;

CREATE TABLE `comment_status` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `comment_status` */

insert  into `comment_status`(`id`,`name`) values (1,'Deleted'),(2,'Modified'),(3,'Original');

/*Table structure for table `communication_direction` */

DROP TABLE IF EXISTS `communication_direction`;

CREATE TABLE `communication_direction` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `communication_direction` */

insert  into `communication_direction`(`id`,`name`) values (1,'Unidirectional'),(2,'Bidirectional');

/*Table structure for table `favorites` */

DROP TABLE IF EXISTS `favorites`;

CREATE TABLE `favorites` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) unsigned NOT NULL,
  `post_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `post_id` (`post_id`),
  CONSTRAINT `favorites_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `favorites_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4;

/*Data for the table `favorites` */

insert  into `favorites`(`id`,`user_id`,`post_id`) values (1,1,2),(21,2,2);

/*Table structure for table `like_status` */

DROP TABLE IF EXISTS `like_status`;

CREATE TABLE `like_status` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `like_status` */

insert  into `like_status`(`id`,`name`) values (1,'Like'),(2,'Dislike');

/*Table structure for table `post` */

DROP TABLE IF EXISTS `post`;

CREATE TABLE `post` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `body` varchar(1000) DEFAULT NULL,
  `date_created` date DEFAULT NULL,
  `user_id` bigint(20) unsigned DEFAULT NULL,
  `channel_id` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `channel_id` (`channel_id`),
  CONSTRAINT `post_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `post_ibfk_2` FOREIGN KEY (`channel_id`) REFERENCES `channel` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `post` */

insert  into `post`(`id`,`title`,`body`,`date_created`,`user_id`,`channel_id`) values (1,'TableModel','Table Model uses DefaultTableModel','2020-07-13',1,2),(2,'JOptionPane','One of many fucntion is showJOptionPane','2020-07-13',2,2),(3,'asd','asd',NULL,2,2),(4,'CCC','CCC','2020-09-03',2,2);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `date_created` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `is_account_non_expired` tinyint(1) DEFAULT NULL,
  `is_credentials_non_expired` tinyint(1) DEFAULT NULL,
  `is_enabled` tinyint(1) DEFAULT NULL,
  `is_account_non_locked` tinyint(1) DEFAULT NULL,
  `user_role_id` bigint(20) unsigned DEFAULT NULL,
  `profile_picture` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_role_id` (`user_role_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`first_name`,`last_name`,`date_created`,`email`,`phone`,`is_account_non_expired`,`is_credentials_non_expired`,`is_enabled`,`is_account_non_locked`,`user_role_id`,`profile_picture`) values (1,'marko','$2a$10$jR9dMkb0BHw9Q5f7aBDpn.v1hQ3wchIdSz3BOSjVY4O0D7ZSKPMAS','Marko','Smoljanovic','2020-07-13','marko@gmail.com','+381641261342',1,1,1,1,1,'C:\\Users\\siux\\DiplomskiAplikacija\\user\\1\\profile\\Fo4_Cap_Collector.png'),(2,'petar','$2a$10$6F3.9XCkruQ1OUi7kajAreWyZAznDYS1FrDGkMFQi4SzdTdgO3SQy','Petar','Jeremic','2020-07-13','petar@gmail.com','+381652134211',1,1,1,1,1,'C:\\Users\\siux\\DiplomskiAplikacija\\user\\2\\profile\\vault-boy-login.jpg'),(3,'aleksa','$2a$10$hH71kLoBXFn.KFTIQJFKfeLYQTwEy4Kyx55u082vZNU0cNAmrk542','Aleksa','Ivanovic','2020-07-13','aleksa@gmail.com','+381652134535',1,1,1,1,1,'C:\\Users\\siux\\DiplomskiAplikacija\\user\\3\\profile\\Fo4_Cap_Collector.png');

/*Table structure for table `user_channel` */

DROP TABLE IF EXISTS `user_channel`;

CREATE TABLE `user_channel` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) unsigned DEFAULT NULL,
  `channel_id` bigint(20) unsigned DEFAULT NULL,
  `channel_role_id` bigint(20) unsigned DEFAULT NULL,
  `date_joined` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_channel_ibfk_2` (`user_id`),
  KEY `user_channel_ibfk_3` (`channel_id`),
  KEY `user_channel_ibfk_1` (`channel_role_id`),
  CONSTRAINT `user_channel_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_channel_ibfk_3` FOREIGN KEY (`channel_id`) REFERENCES `channel` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_channel_ibfk_4` FOREIGN KEY (`channel_role_id`) REFERENCES `channel_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4;

/*Data for the table `user_channel` */

insert  into `user_channel`(`id`,`user_id`,`channel_id`,`channel_role_id`,`date_joined`) values (2,1,2,2,'2020-07-13'),(4,2,2,1,'2020-07-13'),(5,3,3,2,'2020-07-13'),(33,2,3,1,'2020-09-11');

/*Table structure for table `user_permission` */

DROP TABLE IF EXISTS `user_permission`;

CREATE TABLE `user_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `user_permission` */

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `user_role` */

insert  into `user_role`(`id`,`name`) values (1,'Student'),(2,'Admin'),(3,'Professor');

/*Table structure for table `user_role_user_permission` */

DROP TABLE IF EXISTS `user_role_user_permission`;

CREATE TABLE `user_role_user_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_role_id` bigint(20) unsigned NOT NULL,
  `user_permission_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_role_id` (`user_role_id`),
  KEY `user_permission_id` (`user_permission_id`),
  CONSTRAINT `user_role_user_permission_ibfk_1` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`id`),
  CONSTRAINT `user_role_user_permission_ibfk_3` FOREIGN KEY (`user_permission_id`) REFERENCES `user_permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `user_role_user_permission` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
