-- MySQL dump 10.13  Distrib 5.7.15, for Linux (x86_64)
--
-- Host: 192.168.43.138    Database: test
-- ------------------------------------------------------
-- Server version	5.7.15

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
-- Table structure for table `ITEM`
--

DROP TABLE IF EXISTS `ITEM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ITEM` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ITEM`
--

LOCK TABLES `ITEM` WRITE;
/*!40000 ALTER TABLE `ITEM` DISABLE KEYS */;
INSERT INTO `ITEM` VALUES (11,'item1'),(12,'item2'),(13,'item3'),(14,'item4'),(15,'item5'),(16,'item6'),(17,'item7'),(18,'item8'),(19,'item9'),(20,'item10');
/*!40000 ALTER TABLE `ITEM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LNK_ITEM`
--

DROP TABLE IF EXISTS `LNK_ITEM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LNK_ITEM` (
  `item_id` bigint(20) unsigned NOT NULL,
  `lnk_id` bigint(20) unsigned NOT NULL,
  KEY `LNK_ITEM_ITEM_FK` (`item_id`),
  KEY `LNK_ITEM_LNK_PRODUCT_PT_PRODUCER_FK` (`lnk_id`),
  CONSTRAINT `LNK_ITEM_ITEM_FK` FOREIGN KEY (`item_id`) REFERENCES `ITEM` (`id`),
  CONSTRAINT `LNK_ITEM_LNK_PRODUCT_PT_PRODUCER_FK` FOREIGN KEY (`lnk_id`) REFERENCES `LNK_PRODUCT_PT_PRODUCER` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LNK_ITEM`
--

LOCK TABLES `LNK_ITEM` WRITE;
/*!40000 ALTER TABLE `LNK_ITEM` DISABLE KEYS */;
INSERT INTO `LNK_ITEM` VALUES (11,1),(12,2),(13,3),(14,4),(15,5),(16,6),(17,7),(18,8),(19,9),(20,10);
/*!40000 ALTER TABLE `LNK_ITEM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LNK_PRODUCT_PT_PRODUCER`
--

DROP TABLE IF EXISTS `LNK_PRODUCT_PT_PRODUCER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LNK_PRODUCT_PT_PRODUCER` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) unsigned NOT NULL,
  `product_type_id` bigint(20) unsigned NOT NULL,
  `producer_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `LNK_PRODUCT_PT_PRODUCER_PRODUCT_FK` (`product_id`),
  KEY `LNK_PRODUCT_PT_PRODUCER_PRODUCT_TYPE_FK` (`product_type_id`),
  KEY `LNK_PRODUCT_PT_PRODUCER_PRODUCER_FK` (`producer_id`),
  CONSTRAINT `LNK_PRODUCT_PT_PRODUCER_PRODUCER_FK` FOREIGN KEY (`producer_id`) REFERENCES `PRODUCER` (`id`),
  CONSTRAINT `LNK_PRODUCT_PT_PRODUCER_PRODUCT_FK` FOREIGN KEY (`product_id`) REFERENCES `PRODUCT` (`id`),
  CONSTRAINT `LNK_PRODUCT_PT_PRODUCER_PRODUCT_TYPE_FK` FOREIGN KEY (`product_type_id`) REFERENCES `PRODUCT_TYPE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LNK_PRODUCT_PT_PRODUCER`
--

LOCK TABLES `LNK_PRODUCT_PT_PRODUCER` WRITE;
/*!40000 ALTER TABLE `LNK_PRODUCT_PT_PRODUCER` DISABLE KEYS */;
INSERT INTO `LNK_PRODUCT_PT_PRODUCER` VALUES (1,1,1,1),(2,1,1,2),(3,1,1,3),(4,1,2,1),(5,1,2,3),(6,2,3,1),(7,2,3,3),(8,2,4,1),(9,2,4,2),(10,2,4,3);
/*!40000 ALTER TABLE `LNK_PRODUCT_PT_PRODUCER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRODUCER`
--

DROP TABLE IF EXISTS `PRODUCER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PRODUCER` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODUCER`
--

LOCK TABLES `PRODUCER` WRITE;
/*!40000 ALTER TABLE `PRODUCER` DISABLE KEYS */;
INSERT INTO `PRODUCER` VALUES (1,'PHILIPS'),(2,'SAMSUNG'),(3,'LG');
/*!40000 ALTER TABLE `PRODUCER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRODUCT`
--

DROP TABLE IF EXISTS `PRODUCT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PRODUCT` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODUCT`
--

LOCK TABLES `PRODUCT` WRITE;
/*!40000 ALTER TABLE `PRODUCT` DISABLE KEYS */;
INSERT INTO `PRODUCT` VALUES (1,'уплотнитель'),(2,'расширитель');
/*!40000 ALTER TABLE `PRODUCT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRODUCT_TYPE`
--

DROP TABLE IF EXISTS `PRODUCT_TYPE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PRODUCT_TYPE` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `product_id` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `PRODUCT_TYPE_PRODUCT_FK` (`product_id`),
  CONSTRAINT `PRODUCT_TYPE_PRODUCT_FK` FOREIGN KEY (`product_id`) REFERENCES `PRODUCT` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODUCT_TYPE`
--

LOCK TABLES `PRODUCT_TYPE` WRITE;
/*!40000 ALTER TABLE `PRODUCT_TYPE` DISABLE KEYS */;
INSERT INTO `PRODUCT_TYPE` VALUES (1,'железный',1),(2,'резиновый',1),(3,'блочный',2),(4,'шарнирный',2);
/*!40000 ALTER TABLE `PRODUCT_TYPE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'test'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-10 12:28:35
