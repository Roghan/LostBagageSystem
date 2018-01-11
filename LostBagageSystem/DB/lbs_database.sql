-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: lbs_database
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `bagage`
--

DROP TABLE IF EXISTS `bagage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bagage` (
  `BagageID` int(11) NOT NULL AUTO_INCREMENT,
  `State` varchar(45) NOT NULL,
  `Date` date DEFAULT NULL,
  `Time` time DEFAULT NULL,
  `Labelnumber` varchar(45) DEFAULT NULL,
  `Type` varchar(45) NOT NULL,
  `Brand` varchar(45) DEFAULT NULL,
  `Color1` int(11) NOT NULL,
  `Color2` int(11) DEFAULT NULL,
  `Characteristics` text,
  `IsReturned` tinyint(4) NOT NULL DEFAULT '0',
  `Airport` varchar(3) NOT NULL,
  `Location` varchar(45) DEFAULT NULL,
  `Initial` varchar(45) DEFAULT NULL,
  `Insertion` varchar(45) DEFAULT NULL,
  `Surname` varchar(45) DEFAULT NULL,
  `Street` varchar(45) DEFAULT NULL,
  `Housenumber` varchar(45) DEFAULT NULL,
  `Zipcode` varchar(45) DEFAULT NULL,
  `City` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Phone1` varchar(45) DEFAULT NULL,
  `Phone2` varchar(45) DEFAULT NULL,
  `Flightnumber` varchar(45) NOT NULL,
  `From` varchar(45) NOT NULL,
  `To` varchar(45) NOT NULL,
  `Vstreet` varchar(45) DEFAULT NULL,
  `Vhousenumber` varchar(45) DEFAULT NULL,
  `Vzipcode` varchar(45) DEFAULT NULL,
  `Vcity` varchar(45) DEFAULT NULL,
  `Hotelname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`BagageID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bagage`
--

LOCK TABLES `bagage` WRITE;
/*!40000 ALTER TABLE `bagage` DISABLE KEYS */;
INSERT INTO `bagage` VALUES (1,'Lost','2008-11-11','13:50:00',NULL,'Koffer',NULL,789465,NULL,'Stikkers',0,'AMS','Band1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','',NULL,NULL,NULL,NULL,NULL),(2,'Lost','2018-01-04','11:30:00','789456123','Koffer','Pokemon',6038,5002,'Stikkers',0,'AMS',NULL,'M','van','Wilgenburg','Klaproos','37','1211LL','Hilversum','Wilgenburg.Marcel@gmail.com','0683171158','','KX1771','Amsterdam','Hoorn',NULL,NULL,NULL,NULL,NULL),(3,'Lost','2018-01-04','11:30:00','123486798','tas','Pokemon',3000,1003,'Hamster Stikkers',0,'AMS',NULL,'B','van','Wilgenburg','Klaproos','37','1211LL','Hilversum','Wilgenburg.Marcel@gmail.com','068712357','','KX7897','Amsterdam','Barcelona','Okubay','112','9878KX','Barcelona','Internationale'),(4,'Lost','2018-01-03','12:40:00','123486798','Koffer','Pelican',5015,8002,'Heeft meerdere vakken aan de voor en achterkant voor extra spullen.\n',0,'ZTH',NULL,'R','','Visser','Klaproos','37','1211LL','Hilversum','Robin_Visser@gmail.com','0687812188','','TT7877','Amsterdam','Jumai Internationale','Maysonbay','1169','1212TT','Jumai','Rising Sun'),(5,'Lost','2018-01-03','12:40:00','123486798','Koffer','Pelican',5015,8002,'Heeft meerdere vakken aan de voor en achterkant voor extra spullen.\n',0,'ZTH',NULL,'R','','Visser','Klaproos','37','1211LL','Hilversum','Robin_Visser@gmail.com','0687812188','','TT7877','Amsterdam','Jumai Internationale','Maysonbay','1169','1212TT','Jumai','Rising Sun');
/*!40000 ALTER TABLE `bagage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gebruiker`
--

DROP TABLE IF EXISTS `gebruiker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gebruiker` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `acountnaam` text,
  `wachtwoord` text,
  `rol` int(11) DEFAULT NULL,
  `blok` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gebruiker`
--

LOCK TABLES `gebruiker` WRITE;
/*!40000 ALTER TABLE `gebruiker` DISABLE KEYS */;
INSERT INTO `gebruiker` VALUES (1,'YouriPel','123',1,0),(2,'Marcel','1234',2,0),(3,'Donovan','12345',3,0),(4,'Koenvd','Koenie',3,0);
/*!40000 ALTER TABLE `gebruiker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `klant`
--

DROP TABLE IF EXISTS `klant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `klant` (
  `Klantnummer` int(11) NOT NULL DEFAULT '0',
  `Voorletter` varchar(45) DEFAULT NULL,
  `Tussenvoegsel` varchar(45) DEFAULT NULL,
  `Achternaam` varchar(45) DEFAULT NULL,
  `Straat` varchar(45) DEFAULT NULL,
  `HuisNummer` varchar(45) DEFAULT NULL,
  `Postcode` varchar(45) DEFAULT NULL,
  `Woonplaats` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Telefoon1` varchar(45) DEFAULT NULL,
  `Telefoon2` varchar(45) DEFAULT NULL,
  `Vluchtgegevens_VluchtNummer` varchar(45) NOT NULL,
  PRIMARY KEY (`Klantnummer`,`Vluchtgegevens_VluchtNummer`),
  KEY `fk_Klant_Vluchtgegevens1_idx` (`Vluchtgegevens_VluchtNummer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `klant`
--

LOCK TABLES `klant` WRITE;
/*!40000 ALTER TABLE `klant` DISABLE KEYS */;
INSERT INTO `klant` VALUES (0,'B',NULL,'Kok','Klaproos','37','1211LL','Hilversum','Bernadette.Kok@gmail.com','03878154',NULL,'KX107'),(0,'R','','Visser','Klaproos','37','1211LL','Hilversum','Robin.Visser@gmail.com','0683171158','','KX109'),(156786167,'M','van','Wilgenburg','Klaproos','37','1211LL','Hilversum','Wilgenburg.Marcel@gmail.com','06897618',NULL,'KX107');
/*!40000 ALTER TABLE `klant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vluchtgegevens`
--

DROP TABLE IF EXISTS `vluchtgegevens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vluchtgegevens` (
  `VluchtNummer` varchar(45) NOT NULL,
  `From` varchar(45) NOT NULL,
  `To` varchar(45) NOT NULL,
  PRIMARY KEY (`VluchtNummer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vluchtgegevens`
--

LOCK TABLES `vluchtgegevens` WRITE;
/*!40000 ALTER TABLE `vluchtgegevens` DISABLE KEYS */;
INSERT INTO `vluchtgegevens` VALUES ('KX107','Amsterdam','Hoorn'),('KX108','Amsterdam','Hilversum'),('KX109','Amsterdam','Hoorn');
/*!40000 ALTER TABLE `vluchtgegevens` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-04 19:16:12
