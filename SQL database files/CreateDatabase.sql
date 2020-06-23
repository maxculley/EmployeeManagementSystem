DROP DATABASE IF EXISTS `sql_employees`;
CREATE DATABASE `sql_employees`;
USE `sql_employees`;

SET NAMES utf8 ;
SET character_set_client = utf8mb4 ;

CREATE TABLE `personal_info` (
  `employee_id` int(4) AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `address` varchar(75) NOT NULL,
  `age` int(2) NOT NULL,
  `gender` char(1) NOT NULL,
  `employee_type` char(1) NOT NULL,
  PRIMARY KEY (`employee_id`)
  ) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
  INSERT INTO `personal_info` VALUES (1001,'Max','Culley','123 Best Street, B35T AV3',20,'M',1);
  INSERT INTO `personal_info` VALUES (1002,'George','Gao','55 Random Road, R4ND ROD',20,'M',0);
  INSERT INTO `personal_info` VALUES (1003,'Dani','Gilbride','8 Long Road, L0N6 R0D',21,'F',0);
  
CREATE TABLE `employee_info` (
  `employee_id` int(4) AUTO_INCREMENT,
  `base_salary` varchar(6) NOT NULL,
  `employee_salary` varchar(6) NOT NULL,
  PRIMARY KEY (`employee_id`)
  ) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
  INSERT INTO `employee_info` VALUES (1001,250000,250000);
  INSERT INTO `employee_info` VALUES (1002,200000,200000);
  INSERT INTO `employee_info` VALUES (1003,200000,220000);
  
CREATE TABLE `employee_passwords` (
  `employee_id` int(4) AUTO_INCREMENT,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`employee_id`)
  ) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
  INSERT INTO `employee_passwords` VALUES (1001,'Max');
  INSERT INTO `employee_passwords` VALUES (1002,'George');
  INSERT INTO `employee_passwords` VALUES (1003,'Dani');
  