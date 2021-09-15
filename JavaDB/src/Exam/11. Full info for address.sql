DELIMITER $$
USE `stc`$$
CREATE PROCEDURE `udp_courses_by_address` (address_name VARCHAR (100))
BEGIN
SELECT a.`name`,cl.`full_name`,
(CASE
    WHEN co.bill <= 20 THEN 'Low'
    WHEN co.bill <= 30 THEN 'Medium'
    ELSE 'High'
 END) as 'level_of_bill'
 ,ca.make,ca.`condition`,c.`name`
FROM addresses as a
JOIN courses as co
ON co.from_address_id = a.id
JOIN clients as cl
ON cl.id = co.client_id
JOIN cars as ca
ON ca.id = co.car_id
JOIN categories as c
on c.id = ca.category_id
WHERE a.`name` = address_name
ORDER BY make,cl.full_name;
END$$

DELIMITER ;