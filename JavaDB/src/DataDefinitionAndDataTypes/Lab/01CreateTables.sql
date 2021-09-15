CREATE DATABASE `gamebar`;
USE `gamebar`;

CREATE TABLE `employees`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(30) NOT NULL,
    `last_name` VARCHAR(30) NOT NULL
);

CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL

);

CREATE TABLE `products`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL,
`category_id` INT
);


INSERT INTO `employees` 
VALUES 
(1, 'Pesho', 'Peshov'),
(2, 'Gosho','Goshov'),
(3,'Ivan','Ivanov');

SELECT * FROM `employees`;
