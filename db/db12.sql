/*
SQLyog Community v13.1.6 (64 bit)
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

/*Data for the table `_like` */

insert  into `_like`(`id`,`date_created`,`like_status_id`,`post_id`,`comment_id`,`user_id`) values 
(1,'2020-09-10',2,1,NULL,2),
(2,'2020-07-13',2,2,NULL,1),
(3,'2020-07-30',1,NULL,1,3),
(8,'2020-08-18',2,NULL,1,2),
(9,NULL,1,NULL,2,2),
(13,'2020-09-12',1,10,NULL,2);

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
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8mb4;

/*Data for the table `attachment` */

insert  into `attachment`(`id`,`comment_id`,`post_id`,`user_id`,`channel_id`,`url`,`original_name`) values 
(43,NULL,2,2,NULL,'post\\2\\attachments\\Fo4_Cap_Collector.png','Fo4_Cap_Collector.png'),
(44,NULL,2,2,NULL,'post\\2\\attachments\\Fo4_Armorer.png','Fo4_Armorer.png'),
(45,NULL,2,2,NULL,'post\\2\\attachments\\Fo4_Gun_Nut.png','Fo4_Gun_Nut.png'),
(46,NULL,2,2,NULL,'post\\2\\attachments\\Fo4_Hacker.png','Fo4_Hacker.png'),
(47,NULL,7,2,NULL,'post\\7\\attachments\\maxresdefault.jpg','maxresdefault.jpg'),
(48,NULL,8,2,NULL,'post\\8\\attachments\\maxresdefault.jpg','maxresdefault.jpg'),
(49,NULL,9,3,NULL,'post\\9\\attachments\\logo3.png','logo3.png'),
(50,NULL,9,3,NULL,'post\\9\\attachments\\1200px-Typescript_logo_2020.svg.png','1200px-Typescript_logo_2020.svg.png'),
(51,NULL,9,3,NULL,'post\\9\\attachments\\javascript-1280x960.png','javascript-1280x960.png'),
(52,NULL,9,3,NULL,'post\\9\\attachments\\maxresdefault.jpg','maxresdefault.jpg'),
(53,NULL,9,3,NULL,'post\\9\\attachments\\2071611_petar-strugar_ls.jpg','2071611_petar-strugar_ls.jpg'),
(54,NULL,9,3,NULL,'post\\9\\attachments\\Aleksa_Nenadović.jpg','Aleksa_Nenadović.jpg'),
(55,NULL,9,3,NULL,'post\\9\\attachments\\1200px-Python.svg.png','1200px-Python.svg.png'),
(56,NULL,9,3,NULL,'post\\9\\attachments\\Avatar (1).jpeg','Avatar (1).jpeg'),
(57,NULL,9,3,NULL,'post\\9\\attachments\\Avatar.jpeg','Avatar.jpeg'),
(58,NULL,9,3,NULL,'post\\9\\attachments\\mgidarccontentnick.comc008fa9d_d.0.jpg','mgidarccontentnick.comc008fa9d_d.0.jpg'),
(59,NULL,10,2,NULL,'post\\10\\attachments\\2071611_petar-strugar_ls.jpg','2071611_petar-strugar_ls.jpg'),
(60,NULL,10,2,NULL,'post\\10\\attachments\\logo3.png','logo3.png'),
(61,NULL,10,2,NULL,'post\\10\\attachments\\1200px-Typescript_logo_2020.svg.png','1200px-Typescript_logo_2020.svg.png'),
(62,NULL,10,2,NULL,'post\\10\\attachments\\javascript-1280x960.png','javascript-1280x960.png'),
(63,NULL,10,2,NULL,'post\\10\\attachments\\maxresdefault.jpg','maxresdefault.jpg'),
(64,NULL,10,2,NULL,'post\\10\\attachments\\Aleksa_Nenadović.jpg','Aleksa_Nenadović.jpg'),
(65,NULL,10,2,NULL,'post\\10\\attachments\\1200px-Python.svg.png','1200px-Python.svg.png'),
(66,NULL,10,2,NULL,'post\\10\\attachments\\Avatar (1).jpeg','Avatar (1).jpeg'),
(67,NULL,10,2,NULL,'post\\10\\attachments\\mgidarccontentnick.comc008fa9d_d.0.jpg','mgidarccontentnick.comc008fa9d_d.0.jpg'),
(68,NULL,10,2,NULL,'post\\10\\attachments\\Avatar.jpeg','Avatar.jpeg'),
(69,NULL,11,2,NULL,'post\\11\\attachments\\OG-Spring.png','OG-Spring.png'),
(70,NULL,11,2,NULL,'post\\11\\attachments\\1200px-Typescript_logo_2020.svg.png','1200px-Typescript_logo_2020.svg.png'),
(71,NULL,11,2,NULL,'post\\11\\attachments\\2071611_petar-strugar_ls.jpg','2071611_petar-strugar_ls.jpg'),
(72,NULL,11,2,NULL,'post\\11\\attachments\\Aleksa_Nenadović.jpg','Aleksa_Nenadović.jpg'),
(73,NULL,11,2,NULL,'post\\11\\attachments\\maxresdefault.jpg','maxresdefault.jpg');

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `category` */

insert  into `category`(`id`,`name`) values 
(1,'Osnovne Studije'),
(2,'Master');

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
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4;

/*Data for the table `channel` */

insert  into `channel`(`id`,`name`,`date_created`,`category_id`,`channel_status_id`,`communication_direction_id`,`channel_id`,`profile_picture_url`) values 
(1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
(2,'Java','2020-07-13',1,1,2,NULL,'channel\\2\\profile\\Fo4_Armorer.png'),
(3,'Swing','2020-07-13',1,3,1,2,'channel\\3\\profile\\communication.png'),
(38,'Panel','2020-09-08',1,1,1,3,NULL),
(39,'JOptionPane','2020-09-08',1,1,1,3,NULL),
(56,'Python','2020-09-11',2,1,2,NULL,'channel\\56\\profile\\1200px-Python.svg.png'),
(57,'JavaScript','2020-09-11',2,1,2,NULL,'channel\\57\\profile\\javascript-1280x960.png'),
(59,'Angular Material','2020-09-11',1,1,2,NULL,'channel\\59\\profile\\logo3.png'),
(66,'TypeScript','2020-09-12',1,1,2,NULL,'channel\\66\\profile\\1200px-Typescript_logo_2020.svg.png'),
(67,'Classes','2020-09-12',1,1,1,66,'channel\\67\\profile\\profile-image'),
(68,'Spring','2020-09-12',1,1,1,NULL,'channel\\68\\profile\\OG-Spring.png'),
(69,'Marko\'s Channel','2020-09-16',1,1,2,NULL,'channel\\69\\profile\\channel-default-image.png'),
(70,'sadfdsafafddfsaasfddsfasfdsdfafsadfsad','2020-09-16',1,1,1,NULL,'channel\\70\\profile\\channel-default-image.png');

/*Table structure for table `channel_role` */

DROP TABLE IF EXISTS `channel_role`;

CREATE TABLE `channel_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `channel_role` */

insert  into `channel_role`(`id`,`name`) values 
(1,'Participant'),
(2,'Owner');

/*Table structure for table `channel_status` */

DROP TABLE IF EXISTS `channel_status`;

CREATE TABLE `channel_status` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `channel_status` */

insert  into `channel_status`(`id`,`name`) values 
(1,'Active'),
(2,'Closed'),
(3,'On Hold');

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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;

/*Data for the table `comment` */

insert  into `comment`(`id`,`text`,`date_created`,`date_last_modified`,`user_id`,`comment_status_id`,`post_id`,`comment_id`) values 
(1,'Awesome!','2020-07-13','2020-08-18',2,3,1,NULL),
(2,'Yes, so good!','2020-07-13','2020-08-18',1,3,1,NULL),
(14,'Bravo','2020-09-02','2020-09-02',2,3,1,NULL),
(19,'well done','2020-09-12','2020-09-12',2,3,1,NULL),
(21,'niceee','2020-09-12','2020-09-12',2,3,10,NULL),
(22,'ok..','2020-09-12','2020-09-12',2,3,10,NULL);

/*Table structure for table `comment_status` */

DROP TABLE IF EXISTS `comment_status`;

CREATE TABLE `comment_status` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `comment_status` */

insert  into `comment_status`(`id`,`name`) values 
(1,'Deleted'),
(2,'Modified'),
(3,'Original');

/*Table structure for table `communication_direction` */

DROP TABLE IF EXISTS `communication_direction`;

CREATE TABLE `communication_direction` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `communication_direction` */

insert  into `communication_direction`(`id`,`name`) values 
(1,'Unidirectional'),
(2,'Bidirectional');

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
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4;

/*Data for the table `favorites` */

insert  into `favorites`(`id`,`user_id`,`post_id`) values 
(1,1,2),
(45,2,10),
(46,2,1),
(47,2,2);

/*Table structure for table `like_status` */

DROP TABLE IF EXISTS `like_status`;

CREATE TABLE `like_status` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `like_status` */

insert  into `like_status`(`id`,`name`) values 
(1,'Like'),
(2,'Dislike');

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

/*Data for the table `post` */

insert  into `post`(`id`,`title`,`body`,`date_created`,`user_id`,`channel_id`) values 
(1,'TableModel','Table Model uses DefaultTableModel','2020-07-13',1,2),
(2,'JOptionPane','One of many fucntion is showJOptionPane','2020-07-13',2,2),
(6,'List','Lists are vary handy!','2020-09-11',2,56),
(7,'JavaScript Closure','Vary tricky','2020-09-12',2,66),
(8,'Test','sadfasdfsaf','2020-09-12',2,66),
(9,'Events','cool i like it','2020-09-12',3,3),
(10,'IoC','so happy to learn dependency injection and inversion of control','2020-09-12',2,2),
(11,'RestController','REST api @RestController','2020-09-12',2,68),
(12,'Hello','Hey everyone','2020-09-16',1,69);

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
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`first_name`,`last_name`,`date_created`,`email`,`phone`,`is_account_non_expired`,`is_credentials_non_expired`,`is_enabled`,`is_account_non_locked`,`user_role_id`,`profile_picture`) values 
(1,'marko','{bcrypt}$2y$12$lbYAvhizYIv3gxkXdqkvTOIzrgPKLezd11Tj5crfUdsiETQQbxiYa','Marko','Smoljanovic','2020-07-13','marko@gmail.com','+381641261342',1,1,1,1,2,'user\\1\\profile\\Fo4_Hacker.png'),
(2,'petar','{bcrypt}$2y$12$3Xq3l2Bqxqf6klk.qZAPRefkO.HnGB/jh2xcPMe1SanjuC/WOPTtC','Petar','Jeremic','2020-07-13','petar@gmail.com','+381652134211',1,1,1,1,3,'user\\2\\profile\\profile-image'),
(3,'aleksa','{bcrypt}$2y$12$m/G5pFYKUJkQtBCjLB5SJuZ8AWIx99qlI.nuf4QxU40JL22hTkSea','Aleksa','Ivanovic','2020-07-13','aleksa@gmail.com','+381652134535',1,1,1,1,1,'user\\3\\profile\\Aleksa_Nenadović.jpg'),
(14,'example1@mail.com','{bcrypt}$2a$10$Nsr1XAhkp2EPIldJLUg0C.C9qYKCIWN7JzilkvzXOH4Ni0HLGIJbe',NULL,NULL,'2020-09-08','example1@mail.com',NULL,1,1,1,1,1,NULL),
(15,'example2@mail.com','{bcrypt}$2a$10$xUAeNVz6EX25rD5uYDp9ruPQZ5NbFnnLYPoxuR4KR.QWufqSuXaCi',NULL,NULL,'2020-09-08','example2@mail.com',NULL,1,1,1,1,1,NULL),
(16,'example3@mail.com','{bcrypt}$2a$10$jxOw/WMyLjWYIGb/Y/giB.TvIwuNK1pKBp0S8BOSFckneNhcWUNO.',NULL,NULL,'2020-09-08','example3@mail.com',NULL,1,1,1,1,1,NULL),
(17,'example4@mail.com','{bcrypt}$2a$10$HMPKb8hB4McMT7I8s5B3wujU9Ty.gWWo5Ft4hgQBR4LIls8t7c4zS',NULL,NULL,'2020-09-08','example4@mail.com',NULL,1,1,1,1,1,NULL),
(18,'example5@mail.com','{bcrypt}$2a$10$F5z5fCilqcwGOzzrckr/veWPcD4zfm7ZghGh5p.azdj5HhXmppn7m',NULL,NULL,'2020-09-08','example5@mail.com',NULL,1,1,1,1,1,NULL),
(19,'example6@mail.com','{bcrypt}$2a$10$8Z1c7EVXQMqeIUADg9eIN.z8zUwbmAmWRXPd4GKitkg3ybNAZ53I6',NULL,NULL,'2020-09-08','example6@mail.com',NULL,1,1,1,1,1,NULL),
(20,'example7@mail.com','{bcrypt}$2a$10$oF7SC3OE3bi3ywH3Gt3kk.2yOqEJlaTAy8b5S9UIdTu/wSwCK9p5e',NULL,NULL,'2020-09-08','example7@mail.com',NULL,1,1,1,1,1,NULL),
(21,'example8@mail.com','{bcrypt}$2a$10$W2VDFFjb9.76AzQTytPn4uMn04nkrqpNpg.KdTJS32WDpYudI7Gsu',NULL,NULL,'2020-09-08','example8@mail.com',NULL,1,1,1,1,1,NULL),
(22,'example9@mail.com','{bcrypt}$2a$10$m34mey27e3EFiMGuiXeJC.hncHusKBtos8Rte1JY.VB3sbdgwb0au',NULL,NULL,'2020-09-08','example9@mail.com',NULL,1,1,1,1,1,NULL),
(23,'example10@mail.com','{bcrypt}$2a$10$8oJGTFCNlc3toUzdPGXsyeJxroDJ7ddD7ACjBDuCb0FCZqQTpauoi',NULL,NULL,'2020-09-08','example10@mail.com',NULL,1,1,1,1,1,NULL),
(24,'example11@mail.com','{bcrypt}$2a$10$xl9xTdx08KdCyAwb7XEb8ueE9k0uSvfOyAYuBs2erXqt39A3Ig1.a',NULL,NULL,'2020-09-08','example11@mail.com',NULL,1,1,1,1,1,NULL),
(25,'example12@mail.com','{bcrypt}$2a$10$zFElvFzShJ1d/Wg3iq0QveNZxMQeR6jL0mWkTy7YibU4.y8ZVjoNm',NULL,NULL,'2020-09-08','example12@mail.com',NULL,1,1,1,1,1,NULL),
(26,'example13@mail.com','{bcrypt}$2a$10$7Q.YFDPQwelSGb7GzVwaeO1RihnAFbCkenzKoOd7RZ.JDsOgFMXdy',NULL,NULL,'2020-09-08','example13@mail.com',NULL,1,1,1,1,1,NULL),
(27,'example14@mail.com','{bcrypt}$2a$10$mM1/T4U//wrQEotncOdF../ZzDRXT.8dKij1hGWIdwlrS5w.vaCu2',NULL,NULL,'2020-09-08','example14@mail.com',NULL,1,1,1,1,1,NULL),
(28,'example15@mail.com','{bcrypt}$2a$10$f1m4Z2OzjPxC5Tu2W.bh1.WwLCFRyAj5UySSDyYxjZJPDDkYWFhxC',NULL,NULL,'2020-09-08','example15@mail.com',NULL,1,1,1,1,1,NULL),
(34,'example16@mail.com','{bcrypt}$2a$10$L63rUpLGK2uTMSkGPzLxeuhW3Q35S4UX0HPz1Rs6VlHLQXxcKOjEO','First_name','Last_name','2020-09-12','example16@mail.com',NULL,1,1,1,1,1,'user\\34\\profile\\default-user-profile-image.png'),
(35,'example17@mail.com','{bcrypt}$2a$10$XoBYqXHfXZW.YOBDSjGNj.KB.ywG5/bzhSfXpwSQb1nZXVuvg8HS2','First_name','Last_name','2020-09-12','example17@mail.com',NULL,1,1,1,1,1,'user\\35\\profile\\default-user-profile-image.png'),
(36,'example18@mail.com','{bcrypt}$2a$10$qdiB1jonuAgaUnLlkRzlj.pdJfdyefahTutgo3dW..muPNiqPNo..','First_name','Last_name','2020-09-12','example18@mail.com',NULL,1,1,1,1,1,'user\\36\\profile\\default-user-profile-image.png'),
(37,'example19@mail.com','{bcrypt}$2a$10$txrvccNjvRj4e7lco.zkuu4nrUwBG/bjrbZNMDFSmopvBxqWM2oRu','First_name','Last_name','2020-09-12','example19@mail.com',NULL,1,1,1,1,1,'user\\37\\profile\\default-user-profile-image.png'),
(38,'examsafdple19@mail.com','{bcrypt}$2a$10$h0hatsBBHCZCIgcO5heB0e4on9ZSBn.NVfUb0ORmsXizAnMB3WCP6','First_name','Last_name','2020-09-12','examsafdple19@mail.com',NULL,1,1,1,1,1,'user\\38\\profile\\default-user-profile-image.png'),
(39,'examsa24fdple19@mail.com','{bcrypt}$2a$10$7tlQC8Q1oDU66pv66HV7JOViuMhh5aYv.GUYboDOqnJQUznzTZt.y','First_name','Last_name','2020-09-12','examsa24fdple19@mail.com',NULL,1,1,1,1,1,'user\\39\\profile\\default-user-profile-image.png'),
(40,'exa2msa24fdple19@mail.com','{bcrypt}$2a$10$TXVYNCm.6xuwZf5RNVPj6u7Wt6gXR8HzKczBD/HIFyTG5fA9NvA7C','First_name','Last_name','2020-09-12','exa2msa24fdple19@mail.com',NULL,1,1,1,1,1,'user\\40\\profile\\default-user-profile-image.png'),
(41,'exa2ms2a24fdple19@mail.com','{bcrypt}$2a$10$/TxlJAFv.B8I3gI.ZeHcmeDfcaUYD4x//OwzCQxQCU4cxwvWMB6GC','First_name','Last_name','2020-09-12','exa2ms2a24fdple19@mail.com',NULL,1,1,1,1,1,'user\\41\\profile\\default-user-profile-image.png'),
(42,'exa2ms2a24fd4ple19@mail.com','{bcrypt}$2a$10$vsDFrPsoALO6S6MKMQg.5OafsVcIjdAnQABiSf0eWe17WIquHtxTa','First_name','Last_name','2020-09-12','exa2ms2a24fd4ple19@mail.com',NULL,1,1,1,1,1,'user\\42\\profile\\default-user-profile-image.png'),
(43,'exa2ms2a2214fd4ple19@mail.com','{bcrypt}$2a$10$skG1zTajUJuWrrV2viPlKuN9.fwyyPBiDVbaMsPN/qAC.sqf07CH2','First_name','Last_name','2020-09-12','exa2ms2a2214fd4ple19@mail.com',NULL,1,1,1,1,1,'user\\43\\profile\\default-user-profile-image.png'),
(44,'exaafdle19@mail.com','{bcrypt}$2a$10$d6U5GA//BTWvFAg0eq1M8eDZcdmi.RyMXkGWb1MI/s4C.pL/ZvseW','First_name','Last_name','2020-09-12','exaafdle19@mail.com',NULL,1,1,1,1,1,'user\\44\\profile\\default-user-profile-image.png'),
(45,'e24fdle19@mail.com','{bcrypt}$2a$10$Lq3uu5iYWGSqC7Qrnc.l0eQp5yvJBDD28tIQI6QbKZR5zWA2fEVzm','First_name','Last_name','2020-09-12','e24fdle19@mail.com',NULL,1,1,1,1,1,'user\\45\\profile\\default-user-profile-image.png'),
(46,'e24fdsafdfd9@mail.com','{bcrypt}$2a$10$BunTb2qVLSgU2JeUilB2P.KZ8du2yqX.Z9qsGpB4szmww2Or19zhy','First_name','Last_name','2020-09-12','e24fdsafdfd9@mail.com',NULL,1,1,1,1,1,'user\\46\\profile\\default-user-profile-image.png'),
(47,'e24fd24314safsafdfd9@mail.com','{bcrypt}$2a$10$fBrf2Asu41v.xP0tutoKb.kFkETySUjwBuPKvGWeeiUxiBb4kWEvu','First_name','Last_name','2020-09-12','e24fd24314safsafdfd9@mail.com',NULL,1,1,1,1,1,'user\\47\\profile\\default-user-profile-image.png'),
(48,'e24fd4321423asfafsafdfd9@mail.com','{bcrypt}$2a$10$62BRvZBMWvO.iHiX7K7LuuVJEchvLpHjfs7V5PI7//x.lUnIWArIi','First_name','Last_name','2020-09-12','e24fd4321423asfafsafdfd9@mail.com',NULL,1,1,1,1,1,'user\\48\\profile\\default-user-profile-image.png'),
(49,'e24fd4321423asfasdfd9@mail.com','{bcrypt}$2a$10$2l4aGE.860D.NRmhfStJ6.G4nezUPpPAO373G8K62lsX312YArt76','First_name','Last_name','2020-09-12','e24fd4321423asfasdfd9@mail.com',NULL,1,1,1,1,1,'user\\49\\profile\\default-user-profile-image.png'),
(50,'afdas14@mail.com','{bcrypt}$2a$10$QXq3VNCF7k97pJXI.9wXfeKG2fXBIuAo8ebvA7c/PtiV61K4LuG8y','First_name','Last_name','2020-09-12','afdas14@mail.com',NULL,1,1,1,1,1,'user\\50\\profile\\default-user-profile-image.png');

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
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8mb4;

/*Data for the table `user_channel` */

insert  into `user_channel`(`id`,`user_id`,`channel_id`,`channel_role_id`,`date_joined`) values 
(2,1,2,2,'2020-07-13'),
(4,2,2,1,'2020-07-13'),
(5,3,3,2,'2020-07-13'),
(73,2,3,1,'2020-09-10'),
(74,2,56,1,'2020-09-11'),
(75,2,57,1,'2020-09-11'),
(77,2,59,1,'2020-09-11'),
(81,15,57,NULL,NULL),
(82,15,59,NULL,NULL),
(83,15,56,NULL,NULL),
(84,20,59,NULL,NULL),
(85,24,2,NULL,NULL),
(89,2,66,1,'2020-09-12'),
(90,2,67,1,'2020-09-12'),
(91,2,68,1,'2020-09-12'),
(92,34,2,NULL,NULL),
(93,35,2,NULL,NULL),
(94,36,2,NULL,NULL),
(95,37,2,NULL,NULL),
(96,38,2,NULL,NULL),
(97,39,2,NULL,NULL),
(98,40,2,NULL,NULL),
(99,41,2,NULL,NULL),
(100,42,2,NULL,NULL),
(101,43,2,NULL,NULL),
(102,44,2,NULL,NULL),
(103,45,2,NULL,NULL),
(104,46,2,NULL,NULL),
(105,47,2,NULL,NULL),
(106,48,2,NULL,NULL),
(107,34,3,NULL,NULL),
(108,35,3,NULL,NULL),
(109,36,1,NULL,NULL),
(110,37,1,NULL,NULL),
(111,38,1,NULL,NULL),
(112,39,1,NULL,NULL),
(113,40,1,NULL,NULL),
(114,41,1,NULL,NULL),
(115,42,1,NULL,NULL),
(116,43,1,NULL,NULL),
(117,44,3,NULL,NULL),
(118,1,69,1,'2020-09-16'),
(119,2,70,1,'2020-09-16');

/*Table structure for table `user_permission` */

DROP TABLE IF EXISTS `user_permission`;

CREATE TABLE `user_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

/*Data for the table `user_permission` */

insert  into `user_permission`(`id`,`name`) values 
(1,'channel:read'),
(2,'channel:write'),
(3,'channel:delete'),
(4,'user:read'),
(5,'user:write'),
(6,'user:delete'),
(7,'post:read'),
(8,'post:write'),
(9,'post:delete');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `user_role` */

insert  into `user_role`(`id`,`name`) values 
(1,'Student'),
(2,'Admin'),
(3,'Professor');

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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4;

/*Data for the table `user_role_user_permission` */

insert  into `user_role_user_permission`(`id`,`user_role_id`,`user_permission_id`) values 
(1,1,1),
(2,1,7),
(3,1,8),
(4,1,9),
(5,2,1),
(7,2,2),
(8,2,3),
(9,2,4),
(10,2,5),
(11,2,6),
(12,2,7),
(13,2,8),
(14,2,9),
(15,3,1),
(16,3,2),
(17,3,4),
(18,3,5),
(19,3,7),
(20,3,8),
(21,3,9);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
