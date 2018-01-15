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
  `Type` varchar(45) DEFAULT NULL,
  `Brand` varchar(45) DEFAULT NULL,
  `Color1` int(11) DEFAULT NULL,
  `Color2` int(11) DEFAULT NULL,
  `Characteristics` text,
  `IsReturned` tinyint(4) DEFAULT '0',
  `Airport` varchar(3) DEFAULT NULL,
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
  `Flightnumber` varchar(45) DEFAULT NULL,
  `From` varchar(45) DEFAULT NULL,
  `To` varchar(45) DEFAULT NULL,
  `Vstreet` varchar(45) DEFAULT NULL,
  `Vhousenumber` varchar(45) DEFAULT NULL,
  `Vzipcode` varchar(45) DEFAULT NULL,
  `Vcity` varchar(45) DEFAULT NULL,
  `Hotelname` varchar(45) DEFAULT NULL,
  `RegistrationNr` varchar(45) DEFAULT NULL,
  `Passnameandcity` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`BagageID`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bagage`
--

LOCK TABLES `bagage` WRITE;
/*!40000 ALTER TABLE `bagage` DISABLE KEYS */;
INSERT INTO `bagage` VALUES (2,'Lost','2018-01-04','11:30:00','789456123','Suitcase','Pokemon',6038,5002,'Stikkers',0,'AMS',NULL,'M','van','Wilgenburg','Klaproos','37','1211LL','Hilversum','Wilgenburg.Marcel@gmail.com','0683171158','','KX1771','Amsterdam','Hoorn',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'Lost','2018-01-04','11:30:00','123486798','Bag','Pokemon',3000,1003,'Hamster Stikkers',0,'AMS',NULL,'B','van','Wilgenburg','Klaproos','37','1211LL','Hilversum','Wilgenburg.Marcel@gmail.com','068712357','','KX7897','Amsterdam','Barcelona','Okubay','112','9878KX','Barcelona','Internationale',NULL,NULL),(4,'Lost','2018-01-03','12:40:00','123486798','Suitcase','Pelican',5015,8002,'Heeft meerdere vakken aan de voor en achterkant voor extra spullen.\n',0,'ZTH',NULL,'R','','Visser','Klaproos','37','1211LL','Hilversum','Robin_Visser@gmail.com','0687812188','','TT7877','Amsterdam','Jumai Internationale','Maysonbay','1169','1212TT','Jumai','Rising Sun',NULL,NULL),(5,'Found','2018-01-03','12:40:00','123486798','Suitcase','Pelican',5015,8002,'Heeft meerdere vakken aan de voor en achterkant voor extra spullen.\n',0,'ZTH',NULL,'R','','Visser','Klaproos','37','1211LL','Hilversum','Robin_Visser@gmail.com','0687812188','','TT7877','Amsterdam','Jumai Internationale','Maysonbay','1169','1212TT','Jumai','Rising Sun',NULL,NULL),(6,'Lost','2018-01-06','14:46:00','123654789','Suitcase','Samsom',7000,6038,'',1,'AMS',NULL,'Dennis','','Sodergren','Sodergrenshal','1124','1245LT','Malmo','Dennis.Sodergren@hotmail.com','063807158','','KX9877','Malmo','Amsterdam','Klaproos','37','1211','Hilversum','Sweet home alabama',NULL,NULL),(7,'Lost','2018-01-07','02:15:00','','','',6022,NULL,'',1,'AMS',NULL,'M','van','Wilgenburg','3e Oosterstraat','1','1211LL','Hilversum','','0683171158','','KX7777','AYT','BJV','','','','','',NULL,NULL),(8,'Found','2018-01-13','09:04:00','1297047756','Suitcase','Perry Mackin',6004,6004,'holywood sticker',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/25439','R. Hauer, Bussum'),(9,'Found','2018-01-13','19:05:00','1321391290','Business Case','Eastsport',3017,3017,'red-bull sticker',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CAI020',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/23923','M. Verstappen, Monaco'),(10,'Found','2018-01-13','12:18:00','1557534916','Sports Bag','Baggallini',1024,1024,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CAI724',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/26269','S. Appelmans, De Panne'),(11,'Found','2018-01-13','11:00:00','1688722916','Bag','Baggallini',9005,9005,'Orange stripes',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CAI1828',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/22445','A. van Buren, Wassenaar'),(12,'Found','2018-01-13','15:30:00','1957629307','Suitcase','Ivy',2004,2004,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/27004','D. Kuyt, Rotterdam'),(13,'Found','2018-01-13','10:56:00','1963627893','Suitcase','Nautica',1003,1003,'many scratches',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/26092','C. van Houten, Naarden'),(14,'Found','2018-01-13','10:50:00','2147483647','Business Case','Ivy',5002,5002,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'TK2414',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/22309','M. Messi, Barcelona'),(16,'Found','2018-01-13','06:30:00','2147483647','Suitcase','Travel Gear',8023,8023,'ajax stickers',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/24729','M. van Basten, Alkmaar'),(17,'Found','2018-01-13','18:23:00','2147483647','Bagpack','Hedgren',3000,3000,'football stickers',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'TK2430',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/22909','F. van der Elst, Brussel'),(18,'Found','2018-01-13','08:25:00','2147483647','Sports Bag','Fjallraven',8023,8023,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'HV799',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/25105',''),(19,'Found','2018-01-13','13:13:00','2147483647','Suitcase','Glove It',4010,4010,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CAI724',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/22713','R. van Persie, Rotterdam'),(20,'Found','2018-01-13','08:40:00','2147483647','Business Case','Glove It',4005,4005,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CAI1828',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/25293','M. Rutte, den Haag'),(21,'Found','2018-01-13','07:10:00','2147483647','Bag','Fjallraven',7015,7015,'Orange stripes',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'HV649',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/24845','W.A. van Buren, Wassenaar'),(22,'Found','2018-01-13','07:11:00','2147483647','Bagpack','Travel Gear',9001,9001,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/24988',''),(23,'Found','2018-01-13','20:05:00','2147483647','Bag','Samsonite',8002,8002,'Bicycle stickers',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/24230',''),(24,'Found','2018-01-13','22:00:00','2147483647','Business Case','Baggallini',5022,5022,'red-bull sticker',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CAI040',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/24544','J. Verstappen, Oss'),(25,'Found','2018-01-13','21:00:00','2147483647','Box','',6038,6038,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CAI806',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/24318',''),(26,'Found','2018-01-13','19:35:00','2147483647','Suitcase','Everest',5015,5015,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'TK2430',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/24133','A. Gerritse, Ilpendam'),(27,'Found','2018-01-13','21:15:00','2147483647','Sports Bag','Samsonite',8011,8011,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/24422','D. de Munck, Amsterdam'),(28,'Found','2018-01-13','09:17:00','2147483647','Bagpack','Perry Mackin',6002,6002,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/25677',''),(29,'Found','2018-01-13','15:00:00','2147483647','Business Case','Everest',5015,5015,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CAI806',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/26923','R. de Boer, Southhampton'),(30,'Found','2018-01-13','18:40:00','2147483647','Sports Bag','Briggs',3005,3005,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'HV649',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/23844',''),(31,'Found','2018-01-13','17:44:00','2147483647','Suitcase','Hedgren',1015,1015,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CAI806',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/23561','S. Kramer, Heerenveen'),(32,'Found','2018-01-13','13:28:00','2147483647','Bag','AmeriLeather',5022,5022,'Olympic rings',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'HV799',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/26563',''),(33,'Found','2018-01-13','16:17:00','2147483647','Bag','Delsey',5002,5002,'Olympic rings',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CAI524',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/23033','I. de Bruijn, Leiden'),(34,'Found','2018-01-13','14:50:00','2147483647','Sports Bag','AmeriLeather',8011,8011,'BRT television sticker',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CAI524',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/26833',''),(35,'Found','2018-01-13','08:10:00','0','Box','',3017,3017,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'HV649',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/25028',''),(36,'Found','2018-01-13','08:58:00','0','Case','',6038,6038,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/25365',''),(37,'Found','2018-01-13','09:13:00','0','Bag','Eastsport',9011,9011,'Orange stripes',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CAI724',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/25559','M. van Buren, Wassenaar'),(38,'Found','2018-01-14','10:43:00','0','Sports Bag','Eastsport',9001,9001,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CAI040',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/25897','E. Gruyaert, Antwerpen'),(39,'Found','2018-01-14','10:54:00','0','Case','',7015,7015,'red name tag',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/25934',''),(40,'Found','2018-01-14','11:01:00','0','Bagpack','Nautica',1024,1024,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/26139','Mw. Hollande, Paris'),(41,'Found','2018-01-14','11:04:00','0','Box','',7000,7000,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'TK2430',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/22587','G. d\'Esting, Paris'),(42,'Found','2018-01-14','12:21:00','0','Business Case','Hedgren',8002,8002,'ajax stickers',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CAI020',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/26397','F. de Boer, Amsterdam'),(43,'Found','2018-01-14','12:37:00','0','Case','',4005,4005,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CAI020',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/26438',''),(44,'Found','2018-01-14','14:31:00','0','Bagpack','Glove It',6004,6004,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CAI040',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/26638','Mw. Zoetemelk, Lyon'),(45,'Found','2018-01-14','14:40:00','0','Box','',9011,9011,'frech national flag sticker',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/26755','F. Mitterand, Paris'),(46,'Found','2018-01-14','15:22:00','0','Case','',7000,7000,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/22860',''),(47,'Found','2018-01-14','16:34:00','0','Bagpack','Ivy',3000,3000,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/23177','L.. Van Moortsel, Breda'),(48,'Found','2018-01-14','16:44:00','0','Box','',9005,9005,'broken lock',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/23278',''),(49,'Found','2018-01-14','17:09:00','0','Sports Bag','Delsey',6002,6002,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CAI1828',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/22638','E. Leyers, Turnhout'),(50,'Found','2018-01-14','17:10:00','0','Business Case','Fjallraven',2004,2004,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CAI524',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/23320',''),(51,'Found','2018-01-14','17:37:00','0','Case','',6022,6022,'duvel sticker',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/23455',''),(52,'Found','2018-01-14','18:20:00','0','Bag','Briggs',1003,1003,'Olympic rings',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'TK2414',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/23632','P. van den Hoogenband, Eindhoven'),(54,'Found','2018-12-24','20:45:00','0','Bagpack','Everest',6022,6022,'',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'TK2414',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016/24665','F. van der Sande, Wuustwezel'),(55,'Lost','2018-01-12','00:00:00','','','',NULL,NULL,'',0,NULL,NULL,NULL,NULL,NULL,'','','',NULL,'','','','',NULL,NULL,'','','','','',NULL,',  , '),(56,'Lost','2018-01-12','11:30:00','13246876','','',9011,NULL,'',1,'AMS',NULL,NULL,NULL,NULL,'Klaproos','37','1211LL',NULL,'','7984465','','KX128','AMS','AYT','','','','','',NULL,'M, van Wilgenburg, Amsterdam'),(57,'Returned','2018-01-03','12:40:00','123486798','Suitcase','Pelican',NULL,NULL,'Heeft meerdere vakken aan de voor en achterkant voor extra spullen.\n',1,'ZTH',NULL,NULL,NULL,NULL,'Klaproos','37','1211LL',NULL,'Robin_Visser@gmail.com','0687812188','','TT7877','Amsterdam','Jumai Internationale','Maysonbay','1169','1212TT','Jumai','Rising Sun',NULL,NULL),(58,'Returned','2018-01-04','11:30:00','789456123','Suitcase','Pokemon',NULL,NULL,'Stikkers',1,'AMS',NULL,NULL,NULL,NULL,'Klaproos','37','1211LL',NULL,'Wilgenburg.Marcel@gmail.com','0683171158','','KX1771','Amsterdam','Hoorn',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(59,'Returned','2008-11-11','13:50:00',NULL,'Suitcase',NULL,NULL,NULL,'Stikkers',1,'AMS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(60,'Returned','2008-11-11','13:50:00','123486798','Suitcase','Pelican',NULL,NULL,'Stikkers',1,'AMS',NULL,NULL,NULL,NULL,'Klaproos','37','1211LL',NULL,'Robin_Visser@gmail.com','0687812188','','','','','Maysonbay','1169',NULL,'Jumai','Rising Sun',NULL,'M. van Basten, Alkmaar'),(61,'Returned','2008-11-11','13:50:00','123486798','Suitcase','Pelican',NULL,NULL,'Stikkers',1,'AMS',NULL,NULL,NULL,NULL,'Klaproos','37','1211LL',NULL,'Robin_Visser@gmail.com','0687812188','','','','','Maysonbay','1169',NULL,'Jumai','Rising Sun',NULL,'M. van Basten, Alkmaar'),(62,'Returned','2018-01-03','11:00:00','1688722916','Bag','Baggallini',NULL,NULL,'Orange stripes',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,'CAI1828',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'A. van Buren, Wassenaar'),(63,'Returned','2018-01-03','12:40:00','123486798','Suitcase','Pelican',NULL,NULL,'Heeft meerdere vakken aan de voor en achterkant voor extra spullen.\n',1,'ZTH',NULL,NULL,NULL,NULL,'Klaproos','37','1211LL',NULL,'Robin_Visser@gmail.com','0687812188','','TT7877','Amsterdam','Jumai Internationale','Maysonbay','1169','1212TT','Jumai','Rising Sun',NULL,NULL),(64,'Returned','2018-01-03','12:40:00','123486798','Suitcase','Pelican',NULL,NULL,'Heeft meerdere vakken aan de voor en achterkant voor extra spullen.\n',1,'ZTH',NULL,NULL,NULL,NULL,'Klaproos','37','1211LL',NULL,'Robin_Visser@gmail.com','0687812188','','TT7877','Amsterdam','Jumai Internationale','Maysonbay','1169','1212TT','Jumai','Rising Sun',NULL,NULL),(65,'Lost','2018-01-14','19:53:00','BAG123','Koffer','Geen',3000,7015,'De koffer heeft grijze horizontale strepen',0,'AMS',NULL,NULL,NULL,NULL,'Cunerastraat','97','1689 TL',NULL,'AAEvandiepen@vliegveld.nl','0229-872219','','TURK123','IST','AMS','','','','','Aqua fantasy',NULL,'A.A.E., van  Diepen, Nibbixwoud'),(66,'Lost','2018-01-14','19:53:00','BAG123','Koffer','Geen',3000,7015,'De koffer heeft grijze horizontale strepen',0,'AMS',NULL,NULL,NULL,NULL,'Cunerastraat','97','1689 TL',NULL,'AAEvandiepen@vliegveld.nl','0229872219','','TURK123','IST','AMS','','','','','Aqua fantasy',NULL,'A.A.E., van  Diepen, Nibbixwoud'),(67,'Lost','2018-01-14','19:53:00','BAG123','Koffer','Geen',3000,7015,'De koffer heeft grijze horizontale strepen',0,'AMS',NULL,NULL,NULL,NULL,'Cunerastraat','97','1689 TL',NULL,'AAEvandiepen@vliegveld.nl','0229872219','','TURK123','IST','AMS','','','','','Aqua fantasy',NULL,'A.A.E., van  Diepen, Nibbixwoud'),(68,'Lost','2018-01-14','19:53:00','BAG123','Koffer','Geen',3000,7015,'De koffer heeft grijze horizontale strepen',0,'AMS',NULL,NULL,NULL,NULL,'Cunerastraat','97','1689 TL',NULL,'AAEvandiepen@vliegveld.nl','0229872219','','TURK123','IST','AMS','','','','','Aqua fantasy',NULL,'A.A.E., van  Diepen, Nibbixwoud'),(69,'Lost','2018-01-14','19:53:00','BAG123','Koffer','Geen',3000,7015,'De koffer heeft grijze horizontale strepen',0,'AMS',NULL,NULL,NULL,NULL,'Cunerastraat','97','1689 TL',NULL,'AAEvandiepen@vliegveld.nl','0229872219','','TURK123','IST','AMS','','','','','Aqua fantasy',NULL,'A.A.E., van  Diepen, Nibbixwoud'),(70,'Lost','2018-01-14','19:53:00','BAG123','Koffer','Geen',3000,7015,'De koffer heeft grijze horizontale strepen',0,'AMS',NULL,NULL,NULL,NULL,'Cunerastraat','97','1689 TL',NULL,'AAEvandiepen@vliegveld.nl','0229872219','','TURK123','IST','AMS','','','','','Aqua fantasy',NULL,'A.A.E., van  Diepen, Nibbixwoud'),(71,'Lost','2018-01-14','19:53:00','BAG123','Koffer','Geen',3000,7015,'De koffer heeft grijze horizontale strepen',0,'AMS',NULL,NULL,NULL,NULL,'Cunerastraat','97','1689 TL',NULL,'AAEvandiepen@vliegveld.nl','0229872219','','TURK123','IST','AMS','','','','','Aqua fantasy',NULL,'A.A.E., van  Diepen, Nibbixwoud'),(72,'Lost','2018-01-14','19:53:00','BAG123','Koffer','Geen',3000,7015,'De koffer heeft grijze horizontale strepen',0,'AMS',NULL,NULL,NULL,NULL,'Cunerastraat','97','1689 TL',NULL,'AAEvandiepen@vliegveld.nl','0229872219','','TURK123','IST','AMS','','','','','Aqua fantasy',NULL,'A.A.E., van  Diepen, Nibbixwoud'),(73,'Lost','2018-01-14','19:53:00','BAG123','Koffer','Geen',3000,7015,'De koffer heeft grijze horizontale strepen',0,'AMS',NULL,NULL,NULL,NULL,'Cunerastraat','97','1689 TL',NULL,'AAEvandiepen@vliegveld.nl','0229872219','','TURK123','IST','AMS','','','','','Aqua fantasy',NULL,'A.A.E., van  Diepen, Nibbixwoud'),(74,'Lost','2018-01-14','19:53:00','BAG123','Koffer','Geen',3000,7015,'De koffer heeft grijze horizontale strepen',0,'AMS',NULL,NULL,NULL,NULL,'Cunerastraat','97','1689 TL',NULL,'AAEvandiepen@vliegveld.nl','0229872219','','TURK123','IST','AMS','','','','','Aqua fantasy',NULL,'A.A.E., van  Diepen, Nibbixwoud'),(75,'Returned','2018-01-14','19:53:00','BAG123','Koffer','Geen',7015,7015,'De koffer heeft grijze horizontale strepen',1,'AMS',NULL,NULL,NULL,NULL,'Cunerastraat','97','1689 TL',NULL,'AAEvandiepen@vliegveld.nl','0229-872219','','TURK123','IST','AMS','','','','','Aqua fantasy',NULL,'A.A.E., van  Diepen, Nibbixwoud'),(76,'Returned','2018-01-14','19:53:00','BAG123','Koffer','Geen',7015,7015,'De koffer heeft grijze horizontale strepen',1,'AMS',NULL,NULL,NULL,NULL,'Cunerastraat','97','1689 TL',NULL,'AAEvandiepen@vliegveld.nl','0229-872219','','TURK123','IST','AMS','','','','','Aqua fantasy',NULL,'A.A.E., van  Diepen, Nibbixwoud'),(77,'Returned','2018-01-07','02:15:00','','','',NULL,NULL,'',1,'AMS',NULL,NULL,NULL,NULL,'3e Oosterstraat','1','1211LL',NULL,'','0683171158','','KX7777','AYT','BJV','','','','','',NULL,'E. de Munck, Brugge'),(78,'Returned','2018-01-07','02:15:00','','','',NULL,NULL,'',1,'AMS',NULL,NULL,NULL,NULL,'3e Oosterstraat','1','1211LL',NULL,'','0683171158','','KX7777','AYT','BJV','','','','','',NULL,'E. de Munck, Brugge'),(79,'Returned','2018-01-07','02:15:00','','','',NULL,NULL,'',1,'AMS',NULL,NULL,NULL,NULL,'3e Oosterstraat','1','1211LL',NULL,'','0683171158','','KX7777','AYT','BJV','','','','','',NULL,'E. de Munck, Brugge'),(80,'Returned','2018-01-12','10:29:00','2147483647','Box','',NULL,NULL,'chain lock',1,'AMS',NULL,NULL,NULL,NULL,'Klaproos','37','1211LL',NULL,'','7984465','','HV799','AMS','AYT','','',NULL,'','',NULL,'N. Bonaparte, Paris');
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
INSERT INTO `gebruiker` VALUES (1,'YouriPel','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',1,0),(2,'Marcel','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4',2,0),(3,'Donovan','5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5',3,0),(4,'Koenvd','1a7648bc484b3d9ed9e2226d223a6193d64e5e1fcacd97868adec665fe12b924',3,0);
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

-- Dump completed on 2018-01-15 23:27:02
