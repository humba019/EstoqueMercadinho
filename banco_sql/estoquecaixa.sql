CREATE DATABASE  IF NOT EXISTS `estoquecaixa` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `estoquecaixa`;
-- MySQL dump 10.16  Distrib 10.1.28-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: estoquecaixa
-- ------------------------------------------------------
-- Server version	5.7.22-log

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
-- Table structure for table `caixa`
--

DROP TABLE IF EXISTS `caixa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caixa` (
  `idCaixa` int(11) NOT NULL,
  `idFun` int(11) NOT NULL,
  PRIMARY KEY (`idCaixa`),
  KEY `fk_idFun_idx` (`idFun`),
  CONSTRAINT `fk_idFun` FOREIGN KEY (`idFun`) REFERENCES `funcionario` (`idFun`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caixa`
--

LOCK TABLES `caixa` WRITE;
/*!40000 ALTER TABLE `caixa` DISABLE KEYS */;
/*!40000 ALTER TABLE `caixa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estoque`
--

DROP TABLE IF EXISTS `estoque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estoque` (
  `idEst` int(11) NOT NULL AUTO_INCREMENT,
  `qtdEst` int(11) NOT NULL,
  `entradaEst` int(11) DEFAULT NULL,
  `saidaEst` int(11) DEFAULT NULL,
  `idProd` int(11) NOT NULL,
  PRIMARY KEY (`idEst`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estoque`
--

LOCK TABLES `estoque` WRITE;
/*!40000 ALTER TABLE `estoque` DISABLE KEYS */;
INSERT INTO `estoque` VALUES (15,41,90,NULL,19),(16,90,90,NULL,20),(18,20,90,NULL,22),(20,45,90,NULL,24),(22,40,90,NULL,27),(25,40,40,35,30);
/*!40000 ALTER TABLE `estoque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `idFun` int(11) NOT NULL AUTO_INCREMENT,
  `cargaHoraFun` int(11) NOT NULL,
  `funcaoFun` varchar(45) NOT NULL,
  PRIMARY KEY (`idFun`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `idProd` int(11) NOT NULL AUTO_INCREMENT,
  `nomeProd` varchar(45) NOT NULL,
  `setorProd` varchar(45) NOT NULL,
  `precoProd` float NOT NULL,
  PRIMARY KEY (`idProd`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Detergente de Coco','Limpeza',50),(2,'Vodka','Bebidas',6),(3,'Queijo Muzarela','Frios',10),(4,'Arroz tipo 1','Massas e Grãos',9.5),(5,'Molho de Tomate','Molhos e Ervas',5.5),(6,'aaa','Limpeza',33),(7,'aaa','Limpeza',33),(8,'aaa','Limpeza',33),(9,'aaa','Limpeza',33),(10,'aaa','Limpeza',44),(11,'aa','Limpeza',33),(12,'aa','Limpeza',33),(13,'aa','Frios',33),(14,'aa','Limpeza',55),(15,'aaa','Limpeza',55),(16,'aaa','Limpeza',44),(19,'aaa','Frios',44),(20,'Guarana 2l','Bebidas',2.5),(22,'Quiejo Muzarela','Frios',4.5),(24,'Maionese','Frios',7.5),(25,'Maionese','Frios',7.5),(27,'Mortadela','Frios',15.5),(30,'Sabãu em Pó','Limpeza',12.5);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `loginUsu` varchar(20) NOT NULL,
  `senhaUsu` varchar(45) DEFAULT NULL,
  `idloginUsu` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idloginUsu`),
  UNIQUE KEY `login_UNIQUE` (`loginUsu`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('hum','11',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venda` (
  `idVen` int(11) NOT NULL AUTO_INCREMENT,
  `idFun` int(11) DEFAULT NULL,
  `totalVen` double NOT NULL,
  `dataVen` varchar(45) NOT NULL,
  PRIMARY KEY (`idVen`),
  KEY `fkidFun_idx` (`idFun`),
  CONSTRAINT `fkidFun` FOREIGN KEY (`idFun`) REFERENCES `funcionario` (`idFun`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=170 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` VALUES (15,NULL,0,'31/12/1969 21:00:00'),(16,NULL,62.5,'31/12/1969 21:00:00'),(17,NULL,62.5,'31/12/1969 21:00:00'),(19,NULL,37.5,'31/12/1969 21:00:00'),(20,NULL,90.5,'31/12/1969 21:00:00'),(22,NULL,37.5,'31/12/1969 21:00:00'),(23,NULL,37.5,'31/12/1969 21:00:00'),(24,NULL,37.5,'31/12/1969 21:00:00'),(25,NULL,25,'2019-03-20T17:07:13.252Z'),(26,NULL,37.5,'20/03/2019 14:23:40'),(27,NULL,0,'20/03/2019 14:25:20'),(28,NULL,37.5,'20/03/2019 14:25:40'),(29,NULL,37.5,'20/03/2019 14:25:45'),(30,NULL,37.5,'20/03/2019 14:25:46'),(31,NULL,50,'20/03/2019 14:28:02'),(32,NULL,50,'20/03/2019 14:35:36'),(33,NULL,37.5,'20/03/2019 14:36:59'),(34,NULL,62.5,'20/03/2019 14:41:15'),(35,NULL,125,'20/03/2019 14:43:07'),(36,NULL,12.5,'20/03/2019 14:44:49'),(37,NULL,12.5,'20/03/2019 14:46:19'),(38,NULL,25,'20/03/2019 14:46:28'),(39,NULL,12.5,'20/03/2019 14:53:52'),(40,NULL,37.5,'20/03/2019 14:55:48'),(41,NULL,62.5,'20/03/2019 14:56:14'),(42,NULL,100,'20/03/2019 14:56:19'),(43,NULL,50,'20/03/2019 14:59:10'),(44,NULL,37.5,'20/03/2019 15:03:18'),(45,NULL,62.5,'20/03/2019 15:03:29'),(46,NULL,87.5,'20/03/2019 15:04:00'),(47,NULL,37.5,'20/03/2019 15:04:19'),(48,NULL,75,'20/03/2019 15:04:43'),(49,NULL,37.5,'20/03/2019 15:05:09'),(50,NULL,37.5,'20/03/2019 15:05:17'),(51,NULL,37.5,'20/03/2019 15:05:17'),(52,NULL,37.5,'20/03/2019 15:05:18'),(53,NULL,37.5,'20/03/2019 15:07:36'),(54,NULL,25,'20/03/2019 15:07:53'),(55,NULL,25,'20/03/2019 15:08:58'),(56,NULL,25,'20/03/2019 15:09:10'),(57,NULL,0,'20/03/2019 15:09:39'),(58,NULL,0,'20/03/2019 15:11:44'),(59,NULL,0,'20/03/2019 15:11:49'),(60,NULL,0,'20/03/2019 15:11:49'),(61,NULL,0,'20/03/2019 15:11:50'),(62,NULL,0,'20/03/2019 15:11:50'),(63,NULL,0,'20/03/2019 15:11:50'),(64,NULL,12.5,'20/03/2019 15:15:17'),(65,NULL,25,'20/03/2019 15:15:28'),(66,NULL,25,'20/03/2019 15:15:33'),(67,NULL,0,'20/03/2019 15:17:02'),(68,NULL,37.5,'20/03/2019 15:19:10'),(69,NULL,37.5,'20/03/2019 23:42:18'),(70,NULL,0,'20/03/2019 23:46:18'),(71,NULL,37.5,'20/03/2019 23:47:14'),(72,NULL,25,'20/03/2019 23:47:31'),(73,NULL,37.5,'20/03/2019 23:47:37'),(74,NULL,37.5,'20/03/2019 23:49:57'),(75,NULL,25,'20/03/2019 23:53:10'),(76,NULL,37.5,'20/03/2019 23:57:13'),(77,NULL,12.5,'21/03/2019 00:02:32'),(78,NULL,25,'21/03/2019 00:09:37'),(79,NULL,25,'21/03/2019 00:09:40'),(80,NULL,25,'21/03/2019 00:13:51'),(81,NULL,37.5,'21/03/2019 00:14:21'),(82,NULL,37.5,'21/03/2019 00:20:42'),(83,NULL,37.5,'21/03/2019 00:22:02'),(84,NULL,37.5,'21/03/2019 00:22:46'),(85,NULL,37.5,'21/03/2019 00:26:45'),(86,NULL,25,'21/03/2019 00:27:38'),(87,NULL,37.5,'21/03/2019 00:29:19'),(88,NULL,37.5,'21/03/2019 13:10:34'),(89,NULL,37.5,'21/03/2019 13:11:52'),(90,NULL,37.5,'21/03/2019 13:17:51'),(91,NULL,25,'21/03/2019 13:20:49'),(92,NULL,25,'21/03/2019 13:24:28'),(93,NULL,37.5,'21/03/2019 13:25:47'),(94,NULL,25,'21/03/2019 13:25:53'),(95,NULL,37.5,'21/03/2019 13:26:33'),(96,NULL,37.5,'21/03/2019 13:27:01'),(97,NULL,25,'21/03/2019 13:30:37'),(98,NULL,12.5,'21/03/2019 13:33:43'),(99,NULL,12.5,'21/03/2019 13:33:56'),(100,NULL,25,'21/03/2019 13:34:09'),(101,NULL,12.5,'21/03/2019 13:34:24'),(102,NULL,37.5,'21/03/2019 13:34:40'),(103,NULL,25,'21/03/2019 13:36:21'),(104,NULL,25,'21/03/2019 13:37:41'),(105,NULL,25,'21/03/2019 13:38:52'),(106,NULL,25,'21/03/2019 13:39:57'),(107,NULL,50,'21/03/2019 13:40:10'),(108,NULL,25,'21/03/2019 13:41:11'),(109,NULL,37.5,'21/03/2019 13:41:21'),(110,NULL,37.5,'21/03/2019 13:52:44'),(111,NULL,25,'21/03/2019 13:53:47'),(112,NULL,37.5,'21/03/2019 13:54:04'),(113,NULL,25,'21/03/2019 13:54:32'),(114,NULL,25,'21/03/2019 13:54:43'),(115,NULL,12.5,'21/03/2019 13:54:51'),(116,NULL,25,'21/03/2019 13:55:24'),(117,NULL,0,'21/03/2019 13:55:31'),(118,NULL,25,'21/03/2019 13:59:52'),(119,NULL,25,'21/03/2019 14:00:07'),(120,NULL,12.5,'21/03/2019 15:24:03'),(121,NULL,12.5,'21/03/2019 15:26:33'),(122,NULL,25,'21/03/2019 15:26:42'),(123,NULL,12.5,'21/03/2019 15:29:14'),(124,NULL,12.5,'21/03/2019 15:29:27'),(125,NULL,12.5,'21/03/2019 15:29:43'),(126,NULL,12.5,'21/03/2019 15:48:45'),(127,NULL,62.5,'21/03/2019 15:51:50'),(128,NULL,12.5,'21/03/2019 15:53:22'),(129,NULL,12.5,'21/03/2019 15:53:45'),(130,NULL,12.5,'21/03/2019 15:55:07'),(131,NULL,12.5,'21/03/2019 15:55:19'),(132,NULL,25,'21/03/2019 15:56:22'),(133,NULL,62.5,'21/03/2019 15:58:00'),(134,NULL,100,'21/03/2019 15:59:54'),(135,NULL,12.5,'21/03/2019 16:00:07'),(136,NULL,37.5,'21/03/2019 16:01:53'),(137,NULL,37.5,'21/03/2019 16:02:00'),(138,NULL,50,'21/03/2019 16:02:30'),(139,NULL,0,'22/03/2019 11:15:29'),(140,NULL,25,'22/03/2019 11:15:42'),(141,NULL,12.5,'22/03/2019 11:15:59'),(142,NULL,12.5,'22/03/2019 11:16:14'),(143,NULL,0,'22/03/2019 11:16:15'),(144,NULL,37.5,'22/03/2019 11:16:25'),(145,NULL,25,'22/03/2019 11:16:42'),(146,NULL,25,'22/03/2019 11:16:52'),(147,NULL,50,'22/03/2019 11:20:25'),(148,NULL,50,'22/03/2019 11:20:41'),(149,NULL,0,'22/03/2019 11:20:46'),(150,NULL,25,'22/03/2019 11:22:09'),(151,NULL,25,'22/03/2019 11:22:25'),(152,NULL,25,'22/03/2019 11:22:34'),(153,NULL,25,'22/03/2019 11:22:45'),(154,NULL,25,'22/03/2019 11:23:00'),(155,NULL,12.5,'22/03/2019 11:29:50'),(156,NULL,25,'22/03/2019 11:31:15'),(157,NULL,25,'22/03/2019 11:32:37'),(158,NULL,25,'22/03/2019 11:33:17'),(159,NULL,12.5,'22/03/2019 11:34:18'),(160,NULL,25,'22/03/2019 11:36:19'),(161,NULL,25,'22/03/2019 11:38:08'),(162,NULL,37.5,'22/03/2019 11:39:54'),(163,NULL,25,'22/03/2019 11:40:06'),(164,NULL,25,'22/03/2019 11:40:19'),(165,NULL,25,'22/03/2019 11:57:02'),(166,NULL,50,'22/03/2019 11:57:10'),(167,NULL,50,'22/03/2019 11:57:21'),(168,NULL,50,'22/03/2019 11:57:34'),(169,NULL,175,'22/03/2019 14:19:17');
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'estoquecaixa'
--

--
-- Dumping routines for database 'estoquecaixa'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-22 15:54:23
