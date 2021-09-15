DELIMITER $$
USE `stc`$$
CREATE FUNCTION `udf_courses_by_client` (phone_num VARCHAR (20)) 
RETURNS INTEGER
DETERMINISTIC
BEGIN

RETURN (SELECT COUNT(co.id) FROM clients as c
JOIN courses as co
ON co.client_id = c.id
WHERE phone_number = phone_num);
END$$

DELIMITER ;