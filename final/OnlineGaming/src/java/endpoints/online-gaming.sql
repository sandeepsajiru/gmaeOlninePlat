-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	5.6.25-log

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
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game` (
  `GameId` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `Desc` varchar(200) DEFAULT NULL,
  `Help` varchar(200) DEFAULT NULL,
  `MinUsers` int(11) DEFAULT NULL,
  `MaxUsers` int(11) DEFAULT NULL,
  `ImgPath` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`GameId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (1,'tic tac to','gfghf','jdjdj',1,2,NULL),(2,'dot dot','dfxvgsdsdfsd','sdff',2,2,'xdsvsd');
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gameinstance`
--

DROP TABLE IF EXISTS `gameinstance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gameinstance` (
  `GameInstanceId` int(11) NOT NULL AUTO_INCREMENT,
  `GameId` int(11) NOT NULL,
  `Status` varchar(45) DEFAULT NULL,
  `StartTime` datetime DEFAULT NULL,
  `EndTime` datetime DEFAULT NULL,
  `InitiatingUser` int(11) NOT NULL,
  PRIMARY KEY (`GameInstanceId`,`InitiatingUser`),
  KEY `fk_GameInstance_Game_idx` (`GameId`),
  KEY `fk_GameInstance_User1_idx` (`InitiatingUser`),
  CONSTRAINT `fk_GameInstance_Game` FOREIGN KEY (`GameId`) REFERENCES `game` (`GameId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_GameInstance_User1` FOREIGN KEY (`InitiatingUser`) REFERENCES `user` (`UserId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gameinstance`
--

LOCK TABLES `gameinstance` WRITE;
/*!40000 ALTER TABLE `gameinstance` DISABLE KEYS */;
INSERT INTO `gameinstance` VALUES (1,1,'1','2015-06-13 10:20:30','2015-06-13 10:25:30',1),(2,1,'Waiting','2015-11-03 00:00:00',NULL,1),(3,1,'Waiting','2015-11-03 00:00:00',NULL,1),(4,1,'Finished','2015-11-03 17:32:18','2015-11-03 17:59:53',1);
/*!40000 ALTER TABLE `gameinstance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gameinstanseonlineusers`
--

DROP TABLE IF EXISTS `gameinstanseonlineusers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gameinstanseonlineusers` (
  `GameInstanceId` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `UserScore` int(11) DEFAULT NULL,
  `UserGameStatus` int(11) DEFAULT NULL,
  `UserJoiningTime` datetime DEFAULT NULL,
  `UserLeavingTime` datetime DEFAULT NULL,
  PRIMARY KEY (`GameInstanceId`,`UserId`),
  KEY `fk_GameInstanseOnlineUsers_GameInstance1_idx` (`GameInstanceId`),
  KEY `fk_GameInstanseOnlineUsers_User1_idx` (`UserId`),
  CONSTRAINT `fk_GameInstanseOnlineUsers_GameInstance1` FOREIGN KEY (`GameInstanceId`) REFERENCES `gameinstance` (`GameInstanceId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_GameInstanseOnlineUsers_User1` FOREIGN KEY (`UserId`) REFERENCES `user` (`UserId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gameinstanseonlineusers`
--

LOCK TABLES `gameinstanseonlineusers` WRITE;
/*!40000 ALTER TABLE `gameinstanseonlineusers` DISABLE KEYS */;
INSERT INTO `gameinstanseonlineusers` VALUES (3,1,10002,1,'2015-11-03 20:43:18','2015-11-03 21:09:22');
/*!40000 ALTER TABLE `gameinstanseonlineusers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `onlineusers`
--

DROP TABLE IF EXISTS `onlineusers`;
/*!50001 DROP VIEW IF EXISTS `onlineusers`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `onlineusers` AS SELECT 
 1 AS `UserId`,
 1 AS `Name`,
 1 AS `Nickname`,
 1 AS `AvatarImgPath`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `runninggame`
--

DROP TABLE IF EXISTS `runninggame`;
/*!50001 DROP VIEW IF EXISTS `runninggame`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `runninggame` AS SELECT 
 1 AS `GameInstanceId`,
 1 AS `GameId`,
 1 AS `Status`,
 1 AS `StartTime`,
 1 AS `EndTime`,
 1 AS `InitiatingUser`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `Email` varchar(45) NOT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Nickname` varchar(45) DEFAULT NULL,
  `AvatarImgPath` varchar(45) DEFAULT NULL,
  `OnlineStatus` int(11) DEFAULT '0',
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'aaa','aaa',NULL,NULL,NULL,0),(2,'dummy','test','testPWD','nick','',0),(4,'aaaaaaaa','aaaaaa@aaa.com','11111aaaa','aaa','x',0),(5,'aaaaaaaa','baaaaa@aaa.com','11111aaaa','aaa','x',0),(6,'aaaaaaaa','caaaaa@aaa.com','11111aaaa','aaa','x',0),(7,'aaaaaaaa','daaaaa@aaa.com','11111aaaa','aaa','x',0),(8,'aaaaaaaa','eaaaaa@aaa.com','11111aaaa','aaa','x',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `onlineusers`
--

/*!50001 DROP VIEW IF EXISTS `onlineusers`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `onlineusers` AS select `user`.`UserId` AS `UserId`,`user`.`Name` AS `Name`,`user`.`Nickname` AS `Nickname`,`user`.`AvatarImgPath` AS `AvatarImgPath` from `user` where (`user`.`OnlineStatus` = 1) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `runninggame`
--

/*!50001 DROP VIEW IF EXISTS `runninggame`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `runninggame` AS select `gameinstance`.`GameInstanceId` AS `GameInstanceId`,`gameinstance`.`GameId` AS `GameId`,`gameinstance`.`Status` AS `Status`,`gameinstance`.`StartTime` AS `StartTime`,`gameinstance`.`EndTime` AS `EndTime`,`gameinstance`.`InitiatingUser` AS `InitiatingUser` from `gameinstance` where (`gameinstance`.`Status` = 'Running') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-04 11:34:03
