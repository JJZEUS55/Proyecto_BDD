-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: biblio
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
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autor` (
  `idautor` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `appPaterno` varchar(45) DEFAULT NULL,
  `appMaterno` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idautor`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
INSERT INTO `autor` VALUES (1,'STEPHEN','EDWIN','KING'),(3,'GABRIEL ANTONIO','GARCIA','MENDEZ'),(4,'GEORGE','ORWELL','GUTIERREZ'),(5,'MARIO','BENEDETTI','FARRUGIA'),(6,'GABRIEL','GARCIA','MARQUEZ');
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autor_libro`
--

DROP TABLE IF EXISTS `autor_libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autor_libro` (
  `idlibro` int(10) unsigned NOT NULL,
  `idautor` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idlibro`,`idautor`),
  KEY `fk_libro_has_autor_autor1_idx` (`idautor`),
  KEY `fk_libro_has_autor_libro_idx` (`idlibro`),
  CONSTRAINT `fk_libro_has_autor_autor1` FOREIGN KEY (`idautor`) REFERENCES `autor` (`idautor`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_libro_has_autor_libro` FOREIGN KEY (`idlibro`) REFERENCES `libro` (`idlibro`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor_libro`
--

LOCK TABLES `autor_libro` WRITE;
/*!40000 ALTER TABLE `autor_libro` DISABLE KEYS */;
INSERT INTO `autor_libro` VALUES (3,1),(2,4),(5,5),(7,5);
/*!40000 ALTER TABLE `autor_libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `biblioteca`
--

DROP TABLE IF EXISTS `biblioteca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `biblioteca` (
  `idbiblioteca` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `calle` varchar(45) NOT NULL,
  `exterior` int(11) NOT NULL,
  PRIMARY KEY (`idbiblioteca`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `biblioteca`
--

LOCK TABLES `biblioteca` WRITE;
/*!40000 ALTER TABLE `biblioteca` DISABLE KEYS */;
INSERT INTO `biblioteca` VALUES (1,'IPN','AV.POLITECNICO',50),(3,'UNAM','COPILCO',10),(5,'UAM','Xochimilco',5),(6,'Nada','0',0);
/*!40000 ALTER TABLE `biblioteca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bibliotecario`
--

DROP TABLE IF EXISTS `bibliotecario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bibliotecario` (
  `idbibliotecario` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `correo` varchar(55) NOT NULL,
  `contrasenia` varchar(55) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `appPaterno` varchar(45) NOT NULL,
  `appMaterno` varchar(45) NOT NULL,
  `calle` varchar(45) NOT NULL,
  `exterior` int(11) NOT NULL,
  `interior` int(11) DEFAULT NULL,
  `sueldo` decimal(12,2) NOT NULL,
  `cargo` varchar(45) NOT NULL,
  `idbiblioteca` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idbibliotecario`,`idbiblioteca`,`correo`),
  KEY `fk_bibliotecario_biblioteca1_idx` (`idbiblioteca`),
  CONSTRAINT `fk_bibliotecario_biblioteca1` FOREIGN KEY (`idbiblioteca`) REFERENCES `biblioteca` (`idbiblioteca`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bibliotecario`
--

LOCK TABLES `bibliotecario` WRITE;
/*!40000 ALTER TABLE `bibliotecario` DISABLE KEYS */;
INSERT INTO `bibliotecario` VALUES (5,'manuel','caos','Manuel','Arreola','Sandoval','MOlina',50,2,900.00,'L',3),(6,'isra','isra','israel','martinez','mm','d',5,5,800.00,'A',1),(7,'hamlet','hamlet','hamlet','csm','mmh','5d',12,12,1000.00,'a',1),(9,'re2ds','1234','Mario Tomás','Islas','Castro','null',20,21,0.00,'L',5),(11,'Nada','Nada','Nada','Nada','Nada','0',0,0,0.00,'A',6),(14,'Martha','12345','Martha','cordero','aaa','null',12,11,0.00,'L',5);
/*!40000 ALTER TABLE `bibliotecario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `editorial`
--

DROP TABLE IF EXISTS `editorial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `editorial` (
  `ideditorial` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`ideditorial`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `editorial`
--

LOCK TABLES `editorial` WRITE;
/*!40000 ALTER TABLE `editorial` DISABLE KEYS */;
INSERT INTO `editorial` VALUES (1,'DE BOLSILLO'),(2,'SALAMANDRA'),(3,'Manolo'),(4,'ALIANZA'),(5,'HARPER'),(6,'REIMPRESA'),(7,'EDHASA');
/*!40000 ALTER TABLE `editorial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ejemplar`
--

DROP TABLE IF EXISTS `ejemplar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ejemplar` (
  `idejemplar` int(8) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `libro` int(10) unsigned NOT NULL,
  `estadoConservacion` varchar(95) DEFAULT NULL,
  `estatus` varchar(45) NOT NULL,
  `idbiblioteca` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idejemplar`,`idbiblioteca`),
  KEY `fk_ejemplar_libro1_idx` (`libro`),
  KEY `fk_ejemplar_biblioteca1_idx` (`idbiblioteca`),
  CONSTRAINT `fk_ejemplar_biblioteca1` FOREIGN KEY (`idbiblioteca`) REFERENCES `biblioteca` (`idbiblioteca`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_ejemplar_libro1` FOREIGN KEY (`libro`) REFERENCES `libro` (`idlibro`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=50000015 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ejemplar`
--

LOCK TABLES `ejemplar` WRITE;
/*!40000 ALTER TABLE `ejemplar` DISABLE KEYS */;
INSERT INTO `ejemplar` VALUES (00000009,3,'Nuevo','Ocupado',3),(00000010,2,'NUEVO','DISPONIBLE',1),(50000010,10,'Nuevo','Disponible',5),(50000011,11,'Nuevo','Disponible',5),(50000012,12,'Nuevo','Disponible',5),(50000013,13,'Nuevo','Disponible',5),(50000014,14,'Nuevo','Disponible',5);
/*!40000 ALTER TABLE `ejemplar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genero` (
  `idgenero` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idgenero`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (2,'THRILLER'),(3,'PSICOSIS'),(4,'EPICA O NARRATIVO'),(5,'DRAMA'),(6,'FICCION'),(7,'INFANTIL'),(8,'AUTOAYUDA'),(9,'HOGAR'),(10,'EROTICA'),(11,'ENCICLOPEDIA'),(12,'POLITICA'),(13,'ECONOMIA'),(14,'SOCIEDAD'),(15,'DEPORTES'),(16,'VIAJES'),(17,'BIOGRAFIAS'),(18,'NOVELA'),(19,'Odontologia');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `libro` (
  `idlibro` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `titulo` varchar(55) NOT NULL,
  `nopaginas` int(11) DEFAULT NULL,
  `edicion` int(11) DEFAULT NULL,
  `año` int(11) DEFAULT NULL,
  `editorial` int(10) unsigned NOT NULL,
  `genero` int(10) unsigned NOT NULL,
  `idbibliotecario` int(10) unsigned NOT NULL DEFAULT '11',
  PRIMARY KEY (`idlibro`),
  KEY `fk_libro_editorial1_idx` (`editorial`),
  KEY `fk_libro_genero1_idx` (`genero`),
  KEY `idbibliotecario` (`idbibliotecario`),
  CONSTRAINT `fk_libro_editorial1` FOREIGN KEY (`editorial`) REFERENCES `editorial` (`ideditorial`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_libro_genero1` FOREIGN KEY (`genero`) REFERENCES `genero` (`idgenero`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `libro_ibfk_1` FOREIGN KEY (`idbibliotecario`) REFERENCES `bibliotecario` (`idbibliotecario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` VALUES (2,'EL PSICOANALISTA',450,1,2010,2,2,11),(3,'HP',700,10,2010,2,3,11),(5,'LA TREGUA',216,6,2006,4,18,11),(6,'CIEN ANOS DE SOLEDAD',512,4,1987,5,4,11),(7,'GRACIAS POR EL FUEGO',288,2002,202,6,18,14),(8,'PRIMAVERA CON UNA ESQUINA ROTA',252,5,2007,7,18,9),(9,'Prueba',20,2,2017,3,2,11),(10,'Odontologia Clinica',780,2,2008,5,19,11),(11,'Odontologia preventiva y comunitaria',620,3,2013,5,19,9),(12,'Operatoria Dental',820,2,2016,5,19,11),(13,'Ortodoncia Diagnostico y Planificacion',912,2,2012,5,19,9),(14,'Odontologia Pediatrica',540,2,2005,5,19,11);
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestamo`
--

DROP TABLE IF EXISTS `prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prestamo` (
  `idprestamo` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `idusuario` int(10) unsigned zerofill NOT NULL,
  `ejemplar` int(8) unsigned zerofill NOT NULL,
  `fechaPrestamo` date DEFAULT NULL,
  `fechaDevolucion` date DEFAULT NULL,
  `idbibliotecario` int(10) unsigned NOT NULL,
  `idbiblioteca` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idprestamo`,`idusuario`,`ejemplar`,`idbibliotecario`,`idbiblioteca`),
  KEY `fk_usuario_has_ejemplar1_ejemplar1_idx` (`ejemplar`),
  KEY `fk_correo_usuario1_idx` (`idusuario`),
  KEY `fk_prestamo_bibliotecario1_idx` (`idbibliotecario`,`idbiblioteca`),
  CONSTRAINT `fk_correo_usuario1` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_prestamo_bibliotecario1` FOREIGN KEY (`idbibliotecario`, `idbiblioteca`) REFERENCES `bibliotecario` (`idbibliotecario`, `idbiblioteca`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_usuario_has_ejemplar1_ejemplar1` FOREIGN KEY (`ejemplar`) REFERENCES `ejemplar` (`idejemplar`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamo`
--

LOCK TABLES `prestamo` WRITE;
/*!40000 ALTER TABLE `prestamo` DISABLE KEYS */;
INSERT INTO `prestamo` VALUES (0000000007,0000000002,00000009,'2017-08-18','2017-08-25',5,3),(0000000008,0000000003,00000010,'2012-08-17','2012-08-17',6,1);
/*!40000 ALTER TABLE `prestamo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefono_biblioteca`
--

DROP TABLE IF EXISTS `telefono_biblioteca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telefono_biblioteca` (
  `idbiblioteca` int(10) unsigned NOT NULL,
  `telefono` varchar(10) NOT NULL,
  PRIMARY KEY (`idbiblioteca`,`telefono`),
  KEY `fk_telefono_biblioteca1_idx` (`idbiblioteca`),
  CONSTRAINT `fk_telefono_biblioteca1` FOREIGN KEY (`idbiblioteca`) REFERENCES `biblioteca` (`idbiblioteca`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefono_biblioteca`
--

LOCK TABLES `telefono_biblioteca` WRITE;
/*!40000 ALTER TABLE `telefono_biblioteca` DISABLE KEYS */;
INSERT INTO `telefono_biblioteca` VALUES (1,'16775249');
/*!40000 ALTER TABLE `telefono_biblioteca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefono_usuario`
--

DROP TABLE IF EXISTS `telefono_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telefono_usuario` (
  `idusuario` int(10) unsigned zerofill NOT NULL,
  `telefono` varchar(10) NOT NULL,
  PRIMARY KEY (`telefono`,`idusuario`),
  KEY `fk_telefono_usuario1_idx` (`idusuario`),
  CONSTRAINT `fk_telefono_usuario1` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefono_usuario`
--

LOCK TABLES `telefono_usuario` WRITE;
/*!40000 ALTER TABLE `telefono_usuario` DISABLE KEYS */;
INSERT INTO `telefono_usuario` VALUES (0000000001,'16775249');
/*!40000 ALTER TABLE `telefono_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idusuario` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `correo` varchar(55) NOT NULL,
  `contrasenia` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `appPaterno` varchar(45) NOT NULL,
  `appMaterno` varchar(45) NOT NULL,
  `calle` varchar(45) NOT NULL,
  `exterior` int(11) NOT NULL,
  `interior` int(11) DEFAULT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (0000000001,'caos','caos','MANUEL','ARREOLA','SANDOVAL','MOLINA',22,11),(0000000002,'ISRA','123','ISRAEL','MARTINEZ','X','POLI',12,50),(0000000003,'pumas_03','123','CARLA','MARIA','GARCIA','TOCHAPA',22,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-22 18:50:10
