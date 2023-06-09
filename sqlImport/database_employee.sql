CREATE DATABASE  IF NOT EXISTS `database` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `database`;
-- MariaDB dump 10.19  Distrib 10.4.27-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: database
-- ------------------------------------------------------
-- Server version	10.4.27-MariaDB

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
  `emp_ID` varchar(12) NOT NULL,
  `fullname` varchar(45) DEFAULT NULL,
  `birth` varchar(12) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `gender` varchar(12) DEFAULT NULL,
  `role_ID` varchar(16) DEFAULT NULL,
  `department_ID` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`emp_ID`),
  KEY `employee_ibfk_2` (`department_ID`),
  KEY `employee_ibfk_1` (`role_ID`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`role_ID`) REFERENCES `role` (`role_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`department_ID`) REFERENCES `department` (`department_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('DES00001','Nguyễn Ngọc Bảo Trân','23/12/1999','baotran2313@gmail.com','Female','DESIGNER','PB0006'),('DES00002','Phạm Minh Huy','19/09/1992','Minhhuyne25@gmail.com','Male','DESIGNER','PB0005'),('DES00003','Phạm Hoàng Tuấn','07/12/1999','hoangtuan0712@gmail.com','Male','DESIGNER','PB0001'),('DES00004','Jason Nguyen','26/03/1993','Jasonnguyen26@gmail.com','Male','DESIGNER','PB0001'),('DES00006','Nguyen Quang Vinh','20/12/2002','quangzin@gmail.com','Male','DESIGNER','PB0006'),('DES00007','Nguyen Thi Thao','10/02/2000','thiThao@gmail.com','Female','DESIGNER','PB0005'),('DEV00001','Trần Cao Nguyên','10/11/2003','caonguyentran1011@gmail.com','Male','DEVELOPER','PB0003'),('DEV00003','Lê Xuân Mai','06/06/1998','BeXuanMai@gmail.com','Female','DEVELOPER','PB0009'),('DEV00004','Trần Thị Hòa','09/12/1991','Hoatran@gmail.com','Female','DEVELOPER','PB0005'),('DEV00005','Hoàng Ngọc Anh Xuân','25/05/2001','AnhXuan23@gmail.com','Male','DEVELOPER','PB0004'),('DEV00006','Lê Minh Tuấn','24/05/1995','Minhtuanle@gmail.com','Male','DEVELOPER','PB0003'),('NV00001','Lê Minh Quang','12/02/2000','minhquangle@gmail.com','Male','BINHTHUONG','PB0003'),('NV00002','Nguyễn Thu Thủy','20/11/1998','thuthuynguyen10@gmail.com','Female','BINHTHUONG','PB0002'),('NV00003','Hồ Thị Ngọc Anh','07/02/1999','ngocAnh@gmail.com','Female','BINHTHUONG','PB0006'),('NV00004','Hoàng Ly Ly','25/05/1992','LyLy@gmail.com','Female','BINHTHUONG','PB0008'),('TES00001','Trần Thúy Kiều','21/02/1996','Thuykieuolaungungbich@gmail.com','Female','TESTER','PB0004'),('TES00002','Nguyễn Mai Anh','08/08/1998','PemaiAnh@gmail.com','Female','TESTER','PB0007'),('TES00003','Trần Thị Thu Thảo','10/11/2003','tsun@gmail.com','Female','TESTER','PB0006'),('TES00004','Phạm Hoàng Gia Bảo','05/04/2000','Giabaone@gmail.com','Male','TESTER','PB0004'),('TES00005','Ngô Bảo Trang','06/06/1992','BaoTrangg@gmail.com','Female','TESTER','PB0003'),('TES00006','Ngô Thị Thu','25/02/1999','nnt@gmail.com','Female','TESTER','PB0007');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-20 22:29:35
