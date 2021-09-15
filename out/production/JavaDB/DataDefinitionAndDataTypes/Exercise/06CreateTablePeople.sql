CREATE TABLE `people`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` BLOB,
`height` FLOAT(5,2) ,
`weight` FLOAT(5,2) ,
`gender` ENUM('M','F') NOT NULL,
`birthdate` DATE NOT NULL,
`biography` TEXT
);

INSERT INTO `minions`.`people` (`name`, `height`, `weight`, `gender`, `birthdate`) VALUES ('Pesho', '1.33', '55', 'm', '1987-11-02');
INSERT INTO `minions`.`people` (`name`, `height`, `weight`, `gender`, `birthdate`) VALUES ('Gosho', '1.55', '67', 'f', '1987-11-02');
INSERT INTO `minions`.`people` (`name`, `height`, `weight`, `gender`, `birthdate`) VALUES ('Misho', '1.44', '76', 'm', '1987-11-02');
INSERT INTO `minions`.`people` (`name`, `height`, `weight`, `gender`, `birthdate`) VALUES ('Georgi', '1.55', '67', 'f', '1987-11-02');
INSERT INTO `minions`.`people` (`name`, `height`, `weight`, `gender`, `birthdate`) VALUES ('Dani', '1.45', '34', 'm', '1987-11-02');