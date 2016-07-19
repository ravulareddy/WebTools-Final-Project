-- MySQL dump 10.13  Distrib 5.6.24, for osx10.8 (x86_64)
--
-- Host: 127.0.0.1    Database: myhome
-- ------------------------------------------------------
-- Server version	5.6.26

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
-- Table structure for table `Features`
--

DROP TABLE IF EXISTS `Features`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Features` (
  `featureId` int(11) NOT NULL AUTO_INCREMENT,
  `featureDescription` varchar(255) DEFAULT NULL,
  `feature` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`featureId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Features`
--

LOCK TABLES `Features` WRITE;
/*!40000 ALTER TABLE `Features` DISABLE KEYS */;
INSERT INTO `Features` VALUES (1,'luxury home','Luxury House'),(2,'spacious house','MultiFamily Home'),(3,'Small and sweet family','SingleFamily House'),(4,'Condos','Condo'),(5,'Gorgeous Patio','Patio'),(6,'In Unit Laundry','In Unit Laundry'),(7,'Parking','Parking'),(8,'Seniors welcome','Assisted Community'),(9,'Pets allowed or not','Pets Allowed');
/*!40000 ALTER TABLE `Features` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `message` varchar(255) DEFAULT NULL,
  `msgDate` varchar(255) DEFAULT NULL,
  `msgFrom` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `personId` bigint(20) NOT NULL,
  PRIMARY KEY (`personId`),
  CONSTRAINT `FK39qt63ku2xmlqup68yho511kc` FOREIGN KEY (`personId`) REFERENCES `person` (`personId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (NULL,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agent`
--

DROP TABLE IF EXISTS `agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agent` (
  `agencyName` varchar(255) DEFAULT NULL,
  `agentType` varchar(255) DEFAULT NULL,
  `personId` bigint(20) NOT NULL,
  PRIMARY KEY (`personId`),
  CONSTRAINT `FKtfjh7s82ue555bnlaidbp6w8b` FOREIGN KEY (`personId`) REFERENCES `person` (`personId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent`
--

LOCK TABLES `agent` WRITE;
/*!40000 ALTER TABLE `agent` DISABLE KEYS */;
INSERT INTO `agent` VALUES ('tesjajkjhj','yrtdfsfds',3);
/*!40000 ALTER TABLE `agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `buyer`
--

DROP TABLE IF EXISTS `buyer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `buyer` (
  `maxPrice` int(11) DEFAULT NULL,
  `minPrice` int(11) DEFAULT NULL,
  `personId` bigint(20) NOT NULL,
  PRIMARY KEY (`personId`),
  CONSTRAINT `FKet6v92379u6atjyb19496mb2t` FOREIGN KEY (`personId`) REFERENCES `person` (`personId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buyer`
--

LOCK TABLES `buyer` WRITE;
/*!40000 ALTER TABLE `buyer` DISABLE KEYS */;
INSERT INTO `buyer` VALUES (0,0,7);
/*!40000 ALTER TABLE `buyer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (15),(15);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `home`
--

DROP TABLE IF EXISTS `home`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `home` (
  `homeId` bigint(20) NOT NULL,
  `imagePath` varchar(255) DEFAULT NULL,
  `listedBy` varchar(255) DEFAULT NULL,
  `noOfBaths` int(11) DEFAULT NULL,
  `noOfBedrooms` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `propType` bigint(20) NOT NULL,
  `yearBuilt` int(11) DEFAULT NULL,
  PRIMARY KEY (`homeId`),
  KEY `FK6ky9te4cto1mhpl6xekgwxiuv` (`propType`),
  CONSTRAINT `FK6ky9te4cto1mhpl6xekgwxiuv` FOREIGN KEY (`propType`) REFERENCES `propertyType` (`homeTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `home`
--

LOCK TABLES `home` WRITE;
/*!40000 ALTER TABLE `home` DISABLE KEYS */;
INSERT INTO `home` VALUES (1,'032650img1.jpeg','agent1',3,4,4500000,1,1999),(2,'/Users/tejageetla/Downloads/sts-bundle/pivotal-tc-server-developer-3.1.3.SR1/base-instance/wtpwebapps/FindYourHome/resources/images/150846img2.jpeg','sruthi',4,4,3,1,0),(3,'img3.jpeg','agent1',3,4,6500000,1,1999),(4,'/Users/tejageetla/Downloads/sts-bundle/pivotal-tc-server-developer-3.1.3.SR1/base-instance/wtpwebapps/FindYourHome/resources/images/155439img6.jpeg','sruthi',7,7,7,1,0),(5,'/Users/tejageetla/Downloads/sts-bundle/pivotal-tc-server-developer-3.1.3.SR1/base-instance/wtpwebapps/FindYourHome/resources/images/184646img8.jpg','sruthiteja',8,1,1,1,0),(6,'/Users/tejageetla/Downloads/sts-bundle/pivotal-tc-server-developer-3.1.3.SR1/base-instance/wtpwebapps/FindYourHome/resources/images/220836img7.jpeg','sruthiteja',7,7,99,6,0),(7,'img5.jpg','agent3',3,4,4506000,1,1999),(8,'/Users/tejageetla/Downloads/sts-bundle/pivotal-tc-server-developer-3.1.3.SR1/base-instance/wtpwebapps/FindYourHome/resources/images/021742img3.jpeg','sruthi',6,7,7,1,0),(9,'/Users/tejageetla/Downloads/sts-bundle/pivotal-tc-server-developer-3.1.3.SR1/base-instance/wtpwebapps/FindYourHome/resources/images/img3.jpeg','sruthiteja',9,9,9,1,0),(10,'/Users/tejageetla/Documents/workspace-sts-3.7.3.RELEASE/FindYourHome/src/main/webapp/resources/images/img2.jpeg','sruthiteja',8,8,898,1,0),(11,'032223img10.jpg','sruthiteja',8,9,89898,1,0),(12,'032650img1.jpeg','sruthiteja',89,8,8998,1,0),(13,'img6.jpeg','agent1',3,4,6500000,3,1999),(14,'img7.jpeg','agent3',3,4,4880000,3,1999),(15,'img4.jpg','agent4',3,4,4570000,4,1999),(16,'img5.jpg','agent2',3,4,4509000,4,1999),(17,'img8.jpg','agent3',3,4,4506000,4,1999),(18,'img9.jpg','agent2',3,4,4503000,5,1999),(19,'032650img1.jpeg','agent2',3,4,4500000,6,1999),(20,'032650img1.jpeg','agent2',3,4,7500000,7,1999);
/*!40000 ALTER TABLE `home` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `homeAddress`
--

DROP TABLE IF EXISTS `homeAddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `homeAddress` (
  `homeId` bigint(20) NOT NULL,
  `addressLine1` varchar(255) DEFAULT NULL,
  `addressLine2` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zipcode` int(11) DEFAULT NULL,
  PRIMARY KEY (`homeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homeAddress`
--

LOCK TABLES `homeAddress` WRITE;
/*!40000 ALTER TABLE `homeAddress` DISABLE KEYS */;
INSERT INTO `homeAddress` VALUES (1,'422Broadway','484Broadway','Somerville','MA',2145),(2,'broadway','433','somerville','ma',2145),(3,'444Broadway','484Broadway','Somerville','MA',2145),(4,'7','7','jghjg','hjj',78987),(5,'tsetyseye','tyesysety','ytesytse','ytesesy',58989),(6,'hj','hjk','hkj','jk',78777),(7,'484sycamore','sycamore','Malden','MA',2148),(8,'huiuiuii','yuttuy','tuuyyuyu','uuyttuyt',76767),(9,'yiui','ui','u','ghghgh',77777),(10,'hk','jkh','jhk','khjkh',89898),(11,'kjjk','hjkjhk','hjjkh','hj',987878),(12,'h','jh','kjkj','jkh',77878),(13,'484Broadway','484Broadway','boston','MA',2146),(14,'484Broadway','sycamore','brookline','MA',2138),(15,'484barlett','barlett','brookline','MA',2138),(16,'484barlett','Mainstreet','brookline','MA',2138),(17,'484barlett','sycamore','brookline','MA',2138),(18,'484barlett','Mainstreet','fenway','MA',2135),(19,'422Broadway','Mainstreet','fenway','MA',2135),(20,'422Broadway','Mainstreet','fenway','MA',2135),(21,'484barlett','Mainstreet','Somerville','MA',2145),(22,'453mainstrt','sycamore','Somerville','MA',2145),(23,'453mainstrt','Mainstreet','Somerville','MA',2145);
/*!40000 ALTER TABLE `homeAddress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listing`
--

DROP TABLE IF EXISTS `listing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `listing` (
  `homeId` bigint(20) NOT NULL,
  `category` bigint(20) NOT NULL,
  `endDate` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `startDate` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `agent` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`homeId`),
  KEY `FK5cc0xgj4svabvgs88nhma3a0h` (`agent`),
  KEY `FK8xa5mk3g2dwt3cbkov3yvngpl` (`category`),
  CONSTRAINT `FK5cc0xgj4svabvgs88nhma3a0h` FOREIGN KEY (`agent`) REFERENCES `agent` (`personId`),
  CONSTRAINT `FK8xa5mk3g2dwt3cbkov3yvngpl` FOREIGN KEY (`category`) REFERENCES `listingcategory` (`categoryid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listing`
--

LOCK TABLES `listing` WRITE;
/*!40000 ALTER TABLE `listing` DISABLE KEYS */;
INSERT INTO `listing` VALUES (2,2,'04962016','First','041162016','LuxuryHome',NULL),(4,1,'04962016','First','041162016','tuy',NULL),(5,2,'04972016','First','041162016','TestAgent',3),(6,2,'04972016','First','041162016','Test',3),(8,1,'04972016','First','041172016','TestAgent',NULL),(9,2,'04972016','First','041172016','TestAgent',3),(10,2,'04972016','First','041172016','TestAgent',3),(11,2,'04972016','First','041172016','TestAgent',3),(12,2,'04972016','First','041172016','sdsfsdf',3);
/*!40000 ALTER TABLE `listing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listingcategory`
--

DROP TABLE IF EXISTS `listingcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `listingcategory` (
  `categoryid` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`categoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listingcategory`
--

LOCK TABLES `listingcategory` WRITE;
/*!40000 ALTER TABLE `listingcategory` DISABLE KEYS */;
INSERT INTO `listingcategory` VALUES (1,'Rent'),(2,'Sale'),(3,'Test');
/*!40000 ALTER TABLE `listingcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `owner`
--

DROP TABLE IF EXISTS `owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `owner` (
  `personId` bigint(20) NOT NULL,
  PRIMARY KEY (`personId`),
  CONSTRAINT `FKboci6ndoxgcrc67w0ncljpql0` FOREIGN KEY (`personId`) REFERENCES `person` (`personId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner`
--

LOCK TABLES `owner` WRITE;
/*!40000 ALTER TABLE `owner` DISABLE KEYS */;
/*!40000 ALTER TABLE `owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `personId` bigint(20) NOT NULL,
  `emailId` varchar(255) NOT NULL,
  `firstName` varchar(30) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phoneNumber` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`personId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'sruthi.ravula@gmail.com','Sruthi','Ravula','sruthi','teja1@','7896785678','ADMIN'),(2,'sruthi.ravula@gmail.com','Sruthi','Reddy','agent','test1@','7675674567','AGENT'),(3,'sruthi.ravula@gmail.com','teja','sruthi','sruthiteja','teja1@','7896785678','AGENT'),(7,'sruthi.ravula@gmail.com','teja','teja','teja','teja1@','7856786756','BUYER');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `propertyType`
--

DROP TABLE IF EXISTS `propertyType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `propertyType` (
  `homeTypeId` bigint(20) NOT NULL AUTO_INCREMENT,
  `homeTypeName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`homeTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propertyType`
--

LOCK TABLES `propertyType` WRITE;
/*!40000 ALTER TABLE `propertyType` DISABLE KEYS */;
INSERT INTO `propertyType` VALUES (1,'Apartment'),(2,'Condo'),(3,'Single Family'),(4,'Multi Family'),(5,'Individual House'),(6,'Townhome'),(7,'Loft'),(8,'Lot/Land');
/*!40000 ALTER TABLE `propertyType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `property_features`
--

DROP TABLE IF EXISTS `property_features`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `property_features` (
  `homeId` bigint(20) NOT NULL,
  `featureId` int(11) NOT NULL,
  KEY `FK1lhn2x4931m9oxmnjko22g58w` (`featureId`),
  KEY `FKcgs2f19rxxy1li2sok6i9n4fm` (`homeId`),
  CONSTRAINT `FK1lhn2x4931m9oxmnjko22g58w` FOREIGN KEY (`featureId`) REFERENCES `Features` (`featureId`),
  CONSTRAINT `FKcgs2f19rxxy1li2sok6i9n4fm` FOREIGN KEY (`homeId`) REFERENCES `home` (`homeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property_features`
--

LOCK TABLES `property_features` WRITE;
/*!40000 ALTER TABLE `property_features` DISABLE KEYS */;
INSERT INTO `property_features` VALUES (2,1),(4,7),(5,3),(6,1),(6,2),(6,3),(6,4),(6,5),(6,6),(8,2),(9,2),(10,2),(11,2),(12,2);
/*!40000 ALTER TABLE `property_features` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'myhome'
--

--
-- Dumping routines for database 'myhome'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-26  7:30:18
