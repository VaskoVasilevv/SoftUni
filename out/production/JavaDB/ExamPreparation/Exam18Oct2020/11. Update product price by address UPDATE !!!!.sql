DELIMITER ##
CREATE PROCEDURE udp_update_product_price(address_name VARCHAR (50))
BEGIN
	UPDATE `products` as p
    JOIN products_stores as ps
	ON ps.product_id  = p.id
	JOIN stores as s
	on s.id = ps.store_id
    JOIN addresses as a
    on s.address_id = a.id
    SET p.price =
    if(LEFT(a.`name`,1) = 0, p.price + 100, p.price + 200) 
WHERE a.`name` = address_name;
END ##
DELIMITER ;