-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: fitness
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `fitness_branch`
--

DROP TABLE IF EXISTS `fitness_branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fitness_branch` (
  `branch_id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `contact` varchar(255) NOT NULL,
  `branch_info` varchar(255) NOT NULL,
  `branch_name` varchar(255) NOT NULL,
  PRIMARY KEY (`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fitness_branch`
--

LOCK TABLES `fitness_branch` WRITE;
/*!40000 ALTER TABLE `fitness_branch` DISABLE KEYS */;
INSERT INTO `fitness_branch` VALUES (1,'shivaji Nagar,pune','98345776512','Meditation Centre in pune','Mental Health,shivajinagar'),(2,'Hadapsar Branch','+91-1234567890','Best For Gymanstics','Hadapsar,pune'),(3,'Katraj Branch','+91-1234567899','Best For Body Building','Katraj,pune'),(4,'Wanaj Branch','+91-1234567799','Best For Muscle Building','Wanaj,pune');
/*!40000 ALTER TABLE `fitness_branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `memb_package`
--

DROP TABLE IF EXISTS `memb_package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `memb_package` (
  `pkg_id` int NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `duration` int NOT NULL,
  `pkg_name` varchar(255) NOT NULL,
  PRIMARY KEY (`pkg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `memb_package`
--

LOCK TABLES `memb_package` WRITE;
/*!40000 ALTER TABLE `memb_package` DISABLE KEYS */;
INSERT INTO `memb_package` VALUES (1,1500,'Just for 1 months',1,'Basic Plan'),(2,4000,'Just for 3 months',3,'Quarterly Plan'),(3,7000,'Just for 6 months',6,'HalfYearly Plan'),(4,12000,'Just for 12 months',12,'Yearly Plan');
/*!40000 ALTER TABLE `memb_package` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monthly_fitness_report`
--

DROP TABLE IF EXISTS `monthly_fitness_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monthly_fitness_report` (
  `report_id` int NOT NULL AUTO_INCREMENT,
  `end_date` date NOT NULL,
  `fat` double NOT NULL,
  `height` double NOT NULL,
  `month` varchar(255) DEFAULT NULL,
  `muscle` double NOT NULL,
  `start_date` date NOT NULL,
  `weight` double NOT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`report_id`),
  KEY `FKcu0t4aq1uad1btcglr8s9r2gv` (`user_id`),
  CONSTRAINT `FKcu0t4aq1uad1btcglr8s9r2gv` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monthly_fitness_report`
--

LOCK TABLES `monthly_fitness_report` WRITE;
/*!40000 ALTER TABLE `monthly_fitness_report` DISABLE KEYS */;
INSERT INTO `monthly_fitness_report` VALUES (1,'2021-05-01',13,176,'MARCH',50,'2020-11-01',78,1);
/*!40000 ALTER TABLE `monthly_fitness_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (501,'ROLE_ADMIN'),(502,'ROLE_MANAGER'),(503,'ROLE_CUSTOMER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  KEY `FKj345gk1bovqvfame88rcx7yyx` (`user_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKj345gk1bovqvfame88rcx7yyx` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,501),(2,502),(3,502),(4,502),(5,501),(6,503),(7,502),(14,502);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `cust_address` varchar(255) DEFAULT NULL,
  `age` int NOT NULL,
  `contact_no` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `payment_status` varchar(255) NOT NULL,
  `branch_id` int DEFAULT NULL,
  `package_id` int DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FKni39x9v3ok64ee45q9attcfpv` (`branch_id`),
  KEY `FKbbycefaej3vcn8pwmhjyqdf6l` (`package_id`),
  CONSTRAINT `FKbbycefaej3vcn8pwmhjyqdf6l` FOREIGN KEY (`package_id`) REFERENCES `memb_package` (`pkg_id`),
  CONSTRAINT `FKni39x9v3ok64ee45q9attcfpv` FOREIGN KEY (`branch_id`) REFERENCES `fitness_branch` (`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Karol Bagh',25,'9499806341','bhushan@gmail.com','MALE','11632a0a-64c7-4035-9d92-69c4b5e983fd.jfif','Bhushan Lokhande','$2a$10$NU/kp6KYWTk7qrYBbl7onuXFWl1VlYwkXzA.7vTCiuV89vLnPg0WO','UNPAID',2,3),(2,'Karol Bagh',25,'9497986341','shubham@gmail.com','MALE','3c9a5446-e39e-418d-9c91-2e0898f2a931.jpg','Shubham Lokhande','$2a$10$3RjJIe3ROH5HGhrK1Ji2wOVlv6W.1mKzf.ENSNgal8kqgcb9wTHp6','UNPAID',2,2),(3,'Karol Bagh',25,'9490986341','dhawal@gmail.com','MALE','default.png','Dhawal Lokhande','$2a$10$.mVo6zwqT0bO6OjbR6UQJeHkZZqgEoS6gh7.GZ46vnHSQtphrJsje','UNPAID',NULL,NULL),(4,'Karol Bagh',25,'9490686341','jayesh@gmail.com','MALE','default.png','Jayesh Lokhande','$2a$10$EoOVNDVDBO7HOcZJYX/Ha.2Y8To4GxGcFDxAAjr6d/bYHi1Ssngza','UNPAID',NULL,NULL),(5,'Karol Bagh',25,'9499806341','mahesh@gmail.com','MALE','default.png','Mahesh Lokhande','$2a$10$7qxb3v9AkNcmuUSkTmJZde1nNDFBd2/khL6ZMVI2f0byUTDuCkRvu','UNPAID',NULL,NULL),(6,'Karol Bagh',25,'9495606341','lokesh@gmail.com','MALE','default.png','Lokesh Lokhande','$2a$10$U6TECU1YHI7lB2WoNKK7F./57KNRhbGrIOzUi5S7PsQfAMJER/IjG','UNPAID',NULL,NULL),(14,'Karol Bagh',25,'9878565645','saurabh@gmail.com','MALE','default.png','Saurabh Lokhande','$2a$10$jgB9JRRrpTHvHnm6KSZwzupBazjrpwyTlqraZmIPeX394tOQITC0i','UNPAID',NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-05 20:15:54
