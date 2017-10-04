-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: dentsoft2
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `citas`
--

DROP TABLE IF EXISTS `citas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `citas` (
  `idCita` int(11) NOT NULL AUTO_INCREMENT,
  `idDentista` int(11) DEFAULT NULL,
  `idPaciente` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `hora` int(11) DEFAULT NULL,
  `media` tinyint(1) DEFAULT NULL,
  `actual` tinyint(1) DEFAULT NULL,
  `Descripción` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`idCita`),
  KEY `idPaciente` (`idPaciente`),
  KEY `idDentista` (`idDentista`),
  CONSTRAINT `citas_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `citas_ibfk_2` FOREIGN KEY (`idDentista`) REFERENCES `dentista` (`idDentista`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citas`
--

LOCK TABLES `citas` WRITE;
/*!40000 ALTER TABLE `citas` DISABLE KEYS */;
INSERT INTO `citas` VALUES (2,1,2,'2016-05-29',12,1,1,'Limpieza dental'),(3,1,3,'2016-05-30',13,0,0,'Eliminar caries'),(6,1,6,'2016-06-03',10,0,1,'Revisión dental'),(7,1,7,'2016-06-01',15,0,1,'chequeo mensual'),(9,2,20,'2016-06-05',15,1,1,'Ver tratamiento'),(10,2,21,'2016-06-01',18,1,1,'Revisión dental'),(11,2,22,'2016-03-30',12,1,1,'Eliminar caries'),(13,1,3,'2017-09-28',8,0,1,'prueba');
/*!40000 ALTER TABLE `citas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `costos`
--

DROP TABLE IF EXISTS `costos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `costos` (
  `idOperacion` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` float DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `idPaciente` int(11) NOT NULL,
  PRIMARY KEY (`idOperacion`),
  KEY `idPaciente` (`idPaciente`),
  CONSTRAINT `costos_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `costos`
--

LOCK TABLES `costos` WRITE;
/*!40000 ALTER TABLE `costos` DISABLE KEYS */;
INSERT INTO `costos` VALUES (3,0,'Limpieza Dental',2),(4,300,'Limpieza Dental',3),(5,500,'Extraccion de diente',5),(8,300,'prueba',3);
/*!40000 ALTER TABLE `costos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dentista`
--

DROP TABLE IF EXISTS `dentista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dentista` (
  `idDentista` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(15) DEFAULT NULL,
  `user` varchar(15) DEFAULT NULL,
  `nombres` varchar(50) DEFAULT NULL,
  `apellidos` varchar(50) DEFAULT NULL,
  `cedula` varchar(50) DEFAULT NULL,
  `telefono` varchar(12) DEFAULT NULL,
  `correoDentista` varchar(60) DEFAULT NULL,
  `especialidad` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idDentista`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dentista`
--

LOCK TABLES `dentista` WRITE;
/*!40000 ALTER TABLE `dentista` DISABLE KEYS */;
INSERT INTO `dentista` VALUES (1,'password','re2ds','Mario Tomás','Islas Castro','1234567','5519056188','mario.tomas.1996@gmail.com','Odontologo'),(2,'anto85','AntoRico','Antonio','Rico López','2237695','55250178','anto_rico85@outlook.com','Ortodoncista'),(3,'Mesa55','MesaJes55','Jesus','Mesa Rodrigo','2539615','5559515253','Mesa_Jes55@gmail.com','Maxillofacial'),(4,'12345','Martha','Martha','cordero','1234567','55443322','mcorderol@ipn.mx','ortodoncista');
/*!40000 ALTER TABLE `dentista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `odontograma`
--

DROP TABLE IF EXISTS `odontograma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `odontograma` (
  `idOdontograma` int(11) NOT NULL,
  `diente1` int(11) DEFAULT NULL,
  `diente2` int(11) DEFAULT NULL,
  `diente3` int(11) DEFAULT NULL,
  `diente4` int(11) DEFAULT NULL,
  `diente5` int(11) DEFAULT NULL,
  `diente6` int(11) DEFAULT NULL,
  `diente7` int(11) DEFAULT NULL,
  `diente8` int(11) DEFAULT NULL,
  `diente9` int(11) DEFAULT NULL,
  `diente10` int(11) DEFAULT NULL,
  `diente11` int(11) DEFAULT NULL,
  `diente12` int(11) DEFAULT NULL,
  `diente13` int(11) DEFAULT NULL,
  `diente14` int(11) DEFAULT NULL,
  `diente15` int(11) DEFAULT NULL,
  `diente16` int(11) DEFAULT NULL,
  `diente17` int(11) DEFAULT NULL,
  `diente18` int(11) DEFAULT NULL,
  `diente19` int(11) DEFAULT NULL,
  `diente20` int(11) DEFAULT NULL,
  `diente21` int(11) DEFAULT NULL,
  `diente22` int(11) DEFAULT NULL,
  `diente23` int(11) DEFAULT NULL,
  `diente24` int(11) DEFAULT NULL,
  `diente25` int(11) DEFAULT NULL,
  `diente26` int(11) DEFAULT NULL,
  `diente27` int(11) DEFAULT NULL,
  `diente28` int(11) DEFAULT NULL,
  `diente29` int(11) DEFAULT NULL,
  `diente30` int(11) DEFAULT NULL,
  `diente31` int(11) DEFAULT NULL,
  `diente32` int(11) DEFAULT NULL,
  PRIMARY KEY (`idOdontograma`),
  CONSTRAINT `odontograma_ibfk_1` FOREIGN KEY (`idOdontograma`) REFERENCES `paciente` (`idPaciente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `odontograma`
--

LOCK TABLES `odontograma` WRITE;
/*!40000 ALTER TABLE `odontograma` DISABLE KEYS */;
INSERT INTO `odontograma` VALUES (2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(3,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0),(4,0,0,0,1,0,0,0,1,0,0,0,0,0,3,0,0,0,1,0,0,0,0,2,0,0,0,2,0,0,0,0,0),(5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(11,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(12,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(14,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(15,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(16,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(17,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(18,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(19,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(20,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(21,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(22,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(23,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(24,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(25,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(26,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(27,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(28,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(29,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(30,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(31,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(32,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(33,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(34,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(35,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(36,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(37,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(38,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(39,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(40,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(41,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(42,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(43,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(44,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(45,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(46,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(47,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(48,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(49,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(50,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(51,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(52,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(53,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(54,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(55,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(56,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(57,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(58,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(59,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(60,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(62,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(63,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(64,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
/*!40000 ALTER TABLE `odontograma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente` (
  `idPaciente` int(11) NOT NULL AUTO_INCREMENT,
  `dentistaAsignado` int(11) NOT NULL,
  `nombres` varchar(50) DEFAULT NULL,
  `apellidos` varchar(50) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `sexo` varchar(12) DEFAULT NULL,
  `domicilio` varchar(120) DEFAULT NULL,
  `CURP` varchar(18) DEFAULT NULL,
  `telefono` varchar(12) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `mostrar` tinyint(1) DEFAULT NULL,
  `cantidadPagada` float DEFAULT NULL,
  PRIMARY KEY (`idPaciente`),
  KEY `dentistaAsignado` (`dentistaAsignado`),
  CONSTRAINT `paciente_ibfk_1` FOREIGN KEY (`dentistaAsignado`) REFERENCES `dentista` (`idDentista`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
INSERT INTO `paciente` VALUES (2,1,'Daniela Alejandra','Berlanga Castro',20,'M','Calle Aguete No. 547, Azcapotzalco, CDMX','BEBD950827CSSHMR01','5516754215','Daniela45@hotmail.com',1,200),(3,1,'Nadia Hortencia','Torres Victoria',54,'M','Tacuba 19, Tacuba, Miguel Hidalgo, CDMX','TOVN960223MDFRCI01','55457890','nadis.torres8@gmail.com',1,400),(4,1,'Paola Jazmín','Sánchez Rodríguez',37,'M','Rey Maxtla 61-1 Col. Sto. Domingo, Azcapotzalco, CDMX','SARP930926MDFNDL09','55616462','pao.jaz9312@hotmail.com',1,0),(5,1,'Atanasio','Ceballos Reséndez',32,'H','Bulevar Galdran, Teotihuacan, EDOMEX','HEMS960814MDFRTR09','53771074','hwnogaledo22@gmail.com',1,200),(6,1,'Paloma Daniela','Islas Rodriguez',15,'M','Rey Maxtla 61-1 Col. Sto. Domingo, Azcapotzalco, CDMX','SARP930926MDFNDL09','55616461','pal_Dan@hotmail.com',1,0),(7,1,'Marisela','Domínguez Herrera',31,'M','Saturno, No. 487, Gustavo A. Madero, CDMX','DOHM791212MDFMRI08','55887943','marisela213@hotmail.com',1,0),(8,1,'Efrain','Gamez Islas',21,'H','Calle Reliquia No. 236, Iztacalco, CDMX','HUGA961105MDFERI04','59666507','efra0@gmail.com',1,400),(9,1,'Daniel','Aguilar Aguas',22,'H','Calle Santo,Numero 26, Miguel Hidalgo, CDMX','MAFJ961217HDFRUE06','51558730','DanielAguila213@gmail.com',1,0),(10,1,'Rocio','Montalva Carbajal',31,'M','Bulevar Chacartegui No. 661, Azcapotzalco, CDMX','RORH870412MDFSSA08','55003995','ffdiegogustavo5@gmail.com',1,0),(11,1,'Sandra','Cordero Olmos',25,'M','Real del Amazonas No. 191, Chimahualcan, CDMX','SOME780516HDFLRC07','57778869','cktu123mbaco10@gmail.com',1,0),(12,1,'Nadia Daniela','Sanches Medina',38,'M','Calle Santo, Coyoacan, CDMX','PORS960802HDFZTG05','57665767','cuper1ez20@gmail.com',1,0),(14,1,'Cesar','Perez Herrera',46,'H','Calle Santo del Andorra, Azcapotzalco, CDMX','NIGE690305HDFEAI09','56000858','jkac1hahboun10@gmail.com',1,0),(15,1,'Roberto','Chacón Mateo',23,'M','Mitre No. 680, Cuahutemoc, CDMX','ISCM960719HDFLSI03','55110444','jiludov1co8@gmail.com',1,0),(16,1,'Netanel','Sanches Medina',38,'H','Calle Santo, Coyoacan, CDMX','PORS960802HDFZTG05','57665767','cuperez20@gmail.com',1,0),(17,1,'Andres','Ceballero Reséndiz',38,'H','Bulevar Galdran, Teotihuacan, EDOMEX','HEMS960814MDFRTR09','53771074','hwnogaledo22@gmail.com',1,0),(18,1,'Esperanza','Diaz Linares',19,'H','Calle Ceperuelo, Tlalpan, CDMX','DILE960827HDFRRG02','54336300','drballe17@gmail.com',1,0),(19,1,'Néstor Eduardo','Paredes Carrera',46,'H','Calle Santo del Andorra, Azcapotzalco, CDMX','NIGE690305HDFEAI09','56000858','jkachahboun10@gmail.com',1,0),(20,1,'Leonel','Sánchez Antonio',20,'H','Rey Maxtla 61-1 Col. Sto. Domingo, Azcapotzalco, CDMX','SARL960108HDFNDN05','55616461','leoipn_1996@hotmail.com',1,0),(21,2,'Itzia','Ramos Vázquez',20,'M','Calzada Azcapotzalco 13, Azcapotzalco, CDMX','RAVI960527MDFMZI04','55632188','itziaramos_96@hotmail.com',1,0),(22,2,'Hanna Zuriebal','Rosas Rosas',31,'M','Ticoman 27, Gustavo A. Madero, CDMX','RORH870412MDFSSA08','55981123','hannar.87@gmail.com',1,0),(23,2,'Eric','Solís Miranda',25,'H','El Rosario 56, Azcapotzalco Norte, CDMX','SOME780516HDFLRC07','55438721','eric_solis45@yahoo.com.mx',1,0),(24,2,'Nicholas Raphael','Jiménez Farías',28,'H','El Cerro 80, Gustavo A. Madero, CDMX','FAJN820224HDFRMO09','55782314','nicorafa67@hotmail.com',1,0),(25,2,'Marcela','Castro Flores',22,'M','Tezozomoc 13, Azcapotzalco, CDMX','CAFM900430MDFSOC05','55112590','march_castro1@gmail.com',1,0),(26,2,'Luis Alfonso','Rivera Pérez',35,'H','Farolito 34, Chimahualcan, EDOMEX','RIPL960617HDFVRS01','55348900','poncho_rivera@hotmail.com',1,0),(27,2,'José Antonio','Martínez Faustinos',40,'H','San Cosme 67, Miguel Hidalgo, CDMX','MAFJ961217HDFRUE06','55953320','faus-joseph15@yahoo.com.mx',1,0),(28,2,'Adriana Marisol','Huerta Garrido',32,'M','Oceania 12, Iztacalco, CDMX','HUGA961105MDFERI04','55693415','mary_williams19@hotmail.com',1,0),(29,2,'Sagrario','Hernández Mata',23,'M','La Piramide 77, Teotihuacan, EDOMEX','HEMS960814MDFRTR09','55871236','sagrario-hernan96@yahoo.com.mx',1,0),(30,2,'Nadia Hortencia','Torres Victoria',47,'M','Tacuba 19, Tacuba, Miguel Hidalgo, CDMX','TOVN960223MDFRCI01','55457890','nadis.torres8@gmail.com',1,0),(31,2,'Uziel','Velasco Parada',50,'H','Aquiles Serdan 99, Azcapotzalco. CDMX','VEPU730620HDFLRE04','55002947','uzi_vela9@hotmail.com',1,0),(32,2,'Roberto','Macuil Hérnandez',67,'H','Aquiles Serdan 99, Azcapotzalco, CDMX','MAHR901012HDFCRE03','55341189','robert_macuin89@hotmail.com',1,0),(33,2,'Isis','Hérnandez Garibay',37,'M','Parque Via 51, Azcapotzalco, CDMX','HEGI760106MDFRRS05','55239998','isis_god78@yahoo.com.mx',1,0),(34,2,'Brenda','Martínez Sánchez',24,'M','Edificios Sur 34-F, Iztapalapa, CDMX','MASB910929MDFRNN07','55091267','brenda.mtz3@gmail.com',1,0),(35,2,'María Alejandra','Domínguez Hernández',35,'M','Zacatenco 9, Gustavo A. Madero, CDMX','DOHM791212MDFMRI08','55887943','madh-45@hotmail.com',1,0),(36,2,'Enrique','Nieto Granados',46,'H','Vallejo 69, Azcapotzalco, CDMX','NIGE690305HDFEAI09','55673445','quique_69@gmail.com',1,0),(37,2,'Mario Tomás','Islas Castro',20,'H','La Raza 37, Cuahutemoc, CDMX','ISCM960719HDFLSI03','55565758','mtic.90@yahoo.com.mx',1,0),(38,2,'Sergio','Pózos Retana',20,'H','Perisur 88, Coyoacan, CDMX','PORS960802HDFZTG05','55010203','spr_ipn23@gmail.com',1,0),(39,2,'Jorge','Paredes Bermúdez',20,'H','Coapa 50, Tlalpan, CDMX','PABJ960827HDFRRG02','55451290','jpbermudez-99@hotmail.com',1,0),(40,2,'Paola Jazmín','Sánchez Rodríguez',23,'M','Rey Maxtla 61-1 Col. Sto. Domingo, Azcapotzalco, CDMX','SARP930926MDFNDL09','55616461','pao.jaz93@hotmail.com',1,0),(41,3,'Giancarla','Velázquez Reséndez',20,'M','Orensanz No. 20, Iztapalapa, CDMX','SARL960108HDFNDN05','55668453','fkmarti10@gmail.com',1,0),(42,3,'Panambi','Frías Jimínez',41,'M','Calle Ramisa No. 840, Gustavo A. Madero, CDMX','RAVI960527MDFMZI04','55116985','hmbirch12@gmail.com ',1,0),(43,3,'Roxana','Montano Carbajal',31,'M','Bulevar Chacartegui No. 661, Azcapotzalco, CDMX','RORH870412MDFSSA08','55003995','ffdiegogustavo5@gmail.com',1,0),(44,3,'Silvano','Cordero Olmos',25,'H','Real del Amazonas No. 191, Chimahualcan, CDMX','SOME780516HDFLRC07','57778869','cktumbaco10@gmail.com',1,0),(45,3,'Jackson','Botello Caldera',47,'H','Boulevard Vilarrubias No. 549, Gustavo A. Madero, CDMX','FAJN820224HDFRMO09','58888068','bmdomingot12@gmail.com ',1,0),(46,3,'Khalil','Díaz Solano',50,'M','Boulevard Vilarrubias No. 549, Miguel Hidalgo, CDMX','CAFM900430MDFSOC05','58888024','bmdomingot12@gmail.com ',1,0),(47,3,'Delfina','Ybarra Vera',35,'M','Boulevard Brunete No. 292, Chimahualcan, EDOMEX','RIPL960617HDFVRS01','54333478','xpericacho23@gmail.com',1,0),(48,3,'Dulas','Aguilera Aguayo',24,'M','Calle Santo, Miguel Hidalgo, CDMX','MAFJ961217HDFRUE06','51558730','edcinza3@gmail.com',1,0),(49,3,'Eira','Gamez Zúñiga',22,'M','Calle Rabat No. 236, Iztacalco, CDMX','HUGA961105MDFERI04','59666507','eafamadas0@gmail.com',1,0),(50,3,'Atanasio','Ceballos Reséndez',38,'H','Bulevar Galdran, Teotihuacan, EDOMEX','HEMS960814MDFRTR09','53771074','hwnogaledo22@gmail.com',1,0),(51,3,'Yuqui','Aguilera Aguayo',43,'M','Bull No. 966, Tacuba, Miguel Hidalgo, CDMX','TOVN960223MDFRCI01','50999138','gganghelescu6@gmail.com ',1,0),(52,3,'Gema','Benítez Leal',50,'M','Aquiles Serdan 99, Azcapotzalco. CDMX','VEPU730620HDFLRE04','51552319','hksiro10@gmail.com',1,0),(53,3,'Reuquén','Sedillo Aguilera',25,'H','Calle Aguete No. 547, Azcapotzalco, CDMX','MAHR901012HDFCRE03','56115981','cnriart13@gmail.com ',1,0),(54,3,'Imperio','Saavedra Salazar',50,'H','Privada Nonay, Azcapotzalco, CDMX','HEGI760106MDFRRS05','56990089','inangrill13@gmail.com',1,0),(55,3,'Kim','Amaya Chávez',55,'M','Privada Campañon, Iztapalapa, CDMX','MASB910929MDFRNN07','56338915','emcutrin12@gmail.com',1,0),(56,3,'Perseo','Mayonga Vela',41,'H','Privada Ulici, Gustavo A. Madero, CDMX','DOHM791212MDFMRI08','52221524','ixbita23@gmail.com',1,0),(57,3,'Néstor','Paez Carrera',46,'H','Calle Santo del Andorra, Azcapotzalco, CDMX','NIGE690305HDFEAI09','56000858','jkachahboun10@gmail.com',1,0),(58,3,'Roxana','Chacón Mateo',23,'M','Mitre No. 680, Cuahutemoc, CDMX','ISCM960719HDFLSI03','55110444','jiludovico8@gmail.com',1,0),(59,3,'Netanel','Sanches Medina',38,'H','Calle Santo, Coyoacan, CDMX','PORS960802HDFZTG05','57665767','cuperez20@gmail.com',1,0),(60,3,'Esmirna','Covarrubias Linares',19,'H','Calle Ceperuelo, Tlalpan, CDMX','PABJ960827HDFRRG02','54336300','drballe17@gmail.com',1,0),(62,1,'kfhkje','ksjfsf',24,'M','dhasjdgwydg','HEMS960814MDFRTR09','55401020','jjp@gmail.com',1,0),(63,1,'Jorge','Paredes',26,'H','asjhaghjdagjhdags','SARP930926MDFNDL09','55447710','jj@hotmail.com',1,0),(64,1,'Euler','Contreras Hernandez',30,'H','prueba','HECE770830HHGRNL19','55443322','euler@hotmail.com',1,0);
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tratamientos`
--

DROP TABLE IF EXISTS `tratamientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tratamientos` (
  `idTratamiento` int(11) NOT NULL AUTO_INCREMENT,
  `idPaciente` int(11) NOT NULL,
  `duracion` int(11) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `tratamientoActual` tinyint(1) DEFAULT NULL,
  `fechaInicio` date DEFAULT NULL,
  `finalizado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idTratamiento`),
  KEY `idPaciente` (`idPaciente`),
  CONSTRAINT `tratamientos_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tratamientos`
--

LOCK TABLES `tratamientos` WRITE;
/*!40000 ALTER TABLE `tratamientos` DISABLE KEYS */;
INSERT INTO `tratamientos` VALUES (1,2,2,'Hacer limpieza dental\nRevisar diente super numerario',1,'2017-09-21',1),(2,3,2,'prueba tratamiento',1,'2017-09-27',0);
/*!40000 ALTER TABLE `tratamientos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-03 21:03:22
