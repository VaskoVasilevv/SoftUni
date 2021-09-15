USE `ruk_database`;
DROP function IF EXISTS `udf_client_cards_count`;

DELIMITER $$
USE `ruk_database`$$
CREATE FUNCTION udf_client_cards_count(name VARCHAR(30))
RETURNS INTEGER
DETERMINISTIC
BEGIN

RETURN (SELECT count(ca.id) FROM 
clients as c
JOIN bank_accounts as b
ON b.client_id = c.id
JOIN cards as ca
on ca.bank_account_id = b.id
WHERE c.full_name = `name`);
END$$

DELIMITER ;

