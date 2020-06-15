DROP DATABASE IF EXISTS `sql_employees`;
CREATE DATABASE `sql_employees`;
USE `sql_employees`;

CREATE TABLE `employees` (
  `employee_id` int(4) NOT NULL AUTO_INCREMENT DEFAULT '1000',
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `address` varchar(75) NOT NULL,
  `age` int(2) NOT NULL,
  `gender` char(1) NOT NULL,
  PRIMARY KEY (`employee_id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
  INSERT INTO `employees` VALUES (37270,'Yovonnda','Magrannell','Executive Secretary',63996,NULL,10);