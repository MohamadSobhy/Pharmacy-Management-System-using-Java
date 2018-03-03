-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: pharmacy
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `اسم الموظف` varchar(50) NOT NULL,
  `العنوان` varchar(70) NOT NULL,
  `الموبايل` varchar(11) NOT NULL,
  `وقت الوصول` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (2,'Mohamad Sobhy','Toukh','1274959043',''),(3,'Ahmed','Toukh','1155861582','');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expired`
--

DROP TABLE IF EXISTS `expired`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expired` (
  `الباركود` varchar(50) NOT NULL,
  `الاسم العلمى` varchar(50) NOT NULL,
  `الاسم التجارى` varchar(50) NOT NULL,
  `اسم الشركة` varchar(50) NOT NULL,
  `السنة` int(11) NOT NULL,
  `الشهر` int(11) NOT NULL,
  `اليوم` int(11) NOT NULL,
  `الكمية` double NOT NULL,
  `سعر الشراء` double NOT NULL,
  `سعر البيع` double NOT NULL,
  PRIMARY KEY (`الباركود`),
  CONSTRAINT `الباركود` FOREIGN KEY (`الباركود`) REFERENCES `medicine` (`الباركود`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expired`
--

LOCK TABLES `expired` WRITE;
/*!40000 ALTER TABLE `expired` DISABLE KEYS */;
INSERT INTO `expired` VALUES ('12','vncnvjc','cxvm,cx','vcmxv',2017,1,11,30,20,25),('5152','cdjic','udskfuh','fuiefj',2019,1,9,120,12,42),('6221032310897','EPICOCILLIN','إبيكوسيللين','الشركة المصرية الدولية',2018,4,1,30,15,20),('6223003991906','Novaldol','Novaldol','Novaldol',2018,1,31,30,10,12);
/*!40000 ALTER TABLE `expired` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicine` (
  `الباركود` varchar(50) NOT NULL,
  `الاسم العلمى` varchar(50) NOT NULL,
  `الاسم التجارى` varchar(50) NOT NULL,
  `اسم الشركة` varchar(50) NOT NULL,
  `تاريخ الصلاحية` varchar(10) NOT NULL,
  `الكمية` int(11) NOT NULL,
  `سعر الشراء` double NOT NULL,
  `سعر البيع` double NOT NULL,
  PRIMARY KEY (`الباركود`,`الاسم التجارى`,`الاسم العلمى`),
  UNIQUE KEY `Barcode` (`الباركود`),
  UNIQUE KEY `الاسم التجارى_UNIQUE` (`الاسم التجارى`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine`
--

LOCK TABLES `medicine` WRITE;
/*!40000 ALTER TABLE `medicine` DISABLE KEYS */;
INSERT INTO `medicine` VALUES ('12','vncnvjc','cxvm,cx','vcmxv','11/01/2017',27,20,25),('5152','cdjic','udskfuh','fuiefj','09/01/2019',113,12,42),('6221032310897','EPICOCILLIN','إبيكوسيللين','الشركة المصرية الدولية','01/04/2018',30,15,20),('6223003991906','Novaldol','Novaldol','Novaldol','31/01/2018',30,10,12);
/*!40000 ALTER TABLE `medicine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales` (
  `رقم الفاتورة` int(11) NOT NULL AUTO_INCREMENT,
  `اسم الدواء` varchar(50) NOT NULL,
  `الكمية` int(11) NOT NULL,
  `تاريخ البيع` varchar(10) NOT NULL,
  `تاريخ الصلاحية` varchar(10) NOT NULL,
  `سعر الدواء` double NOT NULL,
  `الخصم` double DEFAULT NULL,
  `الثمن قبل الخصم` double DEFAULT NULL,
  `الثمن بعد الخصم` double NOT NULL,
  `ثمن المنتج` double NOT NULL,
  PRIMARY KEY (`رقم الفاتورة`,`اسم الدواء`),
  KEY `اسم الدواء_idx` (`اسم الدواء`),
  CONSTRAINT `اسم الدواء` FOREIGN KEY (`اسم الدواء`) REFERENCES `medicine` (`الاسم التجارى`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES (3,'udskfuh',2,'31/01/2017','09/01/2019',42,10,84,75.6,84),(4,'udskfuh',2,'31/01/2017','09/01/2019',42,0,104,104,84),(5,'cxvm,cx',3,'31/01/2017','11/01/2017',25,5,201,190.95,75),(5,'udskfuh',3,'31/01/2017','09/01/2019',42,5,201,190.95,126);
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`username`,`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('Mohamad','Sobhy');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-20 10:56:37
