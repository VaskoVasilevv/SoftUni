CREATE TABLE `users`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(30) CHARACTER SET 'ascii' NOT NULL,
`password` VARCHAR(26) CHARACTER SET 'ascii' NOT NULL,
`profile_picture` BLOB,
`last_login_time` DATETIME,
`is_deleted` BOOLEAN
);

INSERT INTO `minions`.`users` (`username`, `password`, `profile_picture`, `last_login_time`, `is_deleted`) VALUES 
('Pesho', 'asd', NULL,  '1987-11-02 17-34',false),
('Gosho', 'gfdg', NULL,  '1987-11-02 18-40',false),
('Misho', 'eryt', NULL, '1987-11-02 17-50',true),
('Georgi', 'cvb', NULL,  '1987-11-02 18-19',false),
('Dani', 'rtj', NULL, '1987-11-02 14-20',true);

