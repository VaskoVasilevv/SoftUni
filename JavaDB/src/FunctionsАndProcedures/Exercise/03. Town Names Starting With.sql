DELIMITER $$
USE `soft_uni`$$
CREATE PROCEDURE `usp_get_towns_starting_with` (`town_name` VARCHAR(50))
BEGIN
SELECT `name` FROM `towns` as t
WHERE `name` LIKE CONCAT(`town_name`,'%')
ORDER BY t.`name`;
END$$

DELIMITER ;