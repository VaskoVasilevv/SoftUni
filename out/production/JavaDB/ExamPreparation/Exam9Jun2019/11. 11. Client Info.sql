USE `ruk_database`;
DROP procedure IF EXISTS `udp_calientinfo`;

DELIMITER $$
USE `ruk_database`$$
CREATE PROCEDURE `udp_clientinfo` (name VARCHAR(50))
BEGIN
SELECT c.`full_name`,c.age,b.account_number,
CONCAT('$', b.balance)
FROm clients as c
JOIN bank_accounts as b
on b.client_id = c.id
WHERE c.`full_name`= `name`;
END$$

DELIMITER ;