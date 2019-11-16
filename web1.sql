-- MySQL dump 10.15  Distrib 10.0.31-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: web1
-- ------------------------------------------------------
-- Server version	10.0.31-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键哦',
  `price` double DEFAULT NULL COMMENT '价目',
  `name` varchar(100) DEFAULT NULL COMMENT '书名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,26.31,'卡卡');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `financial_business_user`
--

DROP TABLE IF EXISTS `financial_business_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `financial_business_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `network_ip` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `age` varchar(10) DEFAULT NULL,
  `city` varchar(10) DEFAULT NULL,
  `question1` varchar(10) DEFAULT NULL,
  `question2` varchar(10) DEFAULT NULL,
  `question3` varchar(10) DEFAULT NULL,
  `question4` varchar(10) DEFAULT NULL,
  `question5` varchar(10) DEFAULT NULL,
  `question6` varchar(10) DEFAULT NULL,
  `result` varchar(100) DEFAULT NULL COMMENT '未来财富预测结果',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0',
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `financial_business_user_un` (`network_ip`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `financial_business_user`
--

LOCK TABLES `financial_business_user` WRITE;
/*!40000 ALTER TABLE `financial_business_user` DISABLE KEYS */;
INSERT INTO `financial_business_user` VALUES (55,'115.238.80.42','四季如春','men','33','2','C','B','E','B','B','B','80550000元 你问我有什么投资技巧？这么容易的事还用说吗？',0,'2019-07-24 11:25:46'),(56,'218.108.160.174','罗','men','33','2','B','C','C','B','C','C','41100000元 人民币，你已经是个成熟的钱了，要学会自己变多',0,'2019-07-25 09:46:38');
/*!40000 ALTER TABLE `financial_business_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(11) DEFAULT NULL,
  `password` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'wuzh','url123'),(2,'qq','url123'),(3,'wuzh','url321'),(4,'wuzh','url123'),(5,'wuzh','url321'),(6,'wuzh','url123'),(7,'qq','url123'),(8,'qq','url321'),(9,'wuzh','url321'),(10,'wuzh','url321'),(11,'qq','url123'),(12,'qq','url123'),(13,'qq','123');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repair_order`
--

DROP TABLE IF EXISTS `repair_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `repair_order` (
  `id` int(36) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `contact_name` varchar(20) DEFAULT NULL COMMENT '联系人名字',
  `contact_phone` varchar(50) DEFAULT NULL COMMENT '联系人电话，可以是多个号码',
  `contact_address` varchar(150) DEFAULT NULL COMMENT '维修的上门地址',
  `description` varchar(500) DEFAULT NULL COMMENT '故障描述',
  `remark` varchar(500) DEFAULT NULL COMMENT '用户备注',
  `is_deleted` tinyint(1) DEFAULT '0' COMMENT '0-未删除，1-已删除,,',
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repair_order`
--

LOCK TABLES `repair_order` WRITE;
/*!40000 ALTER TABLE `repair_order` DISABLE KEYS */;
INSERT INTO `repair_order` VALUES (1,'wzh','12345678910,10987654321','杭州','语音无声','上午别来',0,'2019-04-23 09:55:21',NULL);
/*!40000 ALTER TABLE `repair_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation_order`
--

DROP TABLE IF EXISTS `reservation_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation_order` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(64) DEFAULT NULL COMMENT '订单编号',
  `user_name` varchar(20) DEFAULT NULL COMMENT '用户姓名',
  `user_phone` char(11) DEFAULT NULL COMMENT '用户联系电话',
  `user_address` varchar(150) DEFAULT NULL COMMENT '安装地址',
  `sale_store` varchar(150) DEFAULT NULL COMMENT '购买店铺的信息',
  `door_panoramic` varchar(500) DEFAULT NULL COMMENT '门板正面图片的url',
  `door_thickness` varchar(20) DEFAULT NULL COMMENT '门板厚度',
  `edge_length` varchar(20) DEFAULT NULL COMMENT '边条长度',
  `remark` varchar(500) DEFAULT NULL COMMENT '用户备注',
  `is_deleted` tinyint(1) DEFAULT '0' COMMENT '0-未删除，1-已删除',
  `visit_date` datetime DEFAULT NULL COMMENT '预约安装时间',
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_id` (`order_id`,`user_phone`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8 COMMENT='预约安装单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation_order`
--

LOCK TABLES `reservation_order` WRITE;
/*!40000 ALTER TABLE `reservation_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservation_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(24) DEFAULT NULL,
  `course` varchar(24) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'刘备','语文',99),(2,'关羽','语文',56),(3,'刘备','数学',118),(4,'关羽','数学',100);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary_requirements`
--

DROP TABLE IF EXISTS `summary_requirements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `summary_requirements` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(25) NOT NULL COMMENT '姓名',
  `company` varchar(100) NOT NULL COMMENT '公司&职位',
  `description` varchar(100) NOT NULL COMMENT '需求描述',
  `phone` varchar(50) NOT NULL COMMENT '手机号或微信号',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '未删除-0，已删除-1',
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='需求汇总表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary_requirements`
--

LOCK TABLES `summary_requirements` WRITE;
/*!40000 ALTER TABLE `summary_requirements` DISABLE KEYS */;
INSERT INTO `summary_requirements` VALUES (1,'啊啊','阿萨科技是打开','卡死了房价案例拉丝机按实际啊，\r\n奥斯卡打开','32132131，asdgask2131231',0,'2019-07-31 17:43:05');
/*!40000 ALTER TABLE `summary_requirements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `id` int(11) NOT NULL,
  `sex` longtext,
  `rate` double(20,3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (2,'1',13.132);
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(24) DEFAULT NULL,
  `password` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'wuzh','123'),(2,'wuzh','321'),(3,'www','222');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'web1'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-16  8:49:16
