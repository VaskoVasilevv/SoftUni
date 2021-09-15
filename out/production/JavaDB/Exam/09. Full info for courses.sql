SELECT a.`name`, 
IF (HOUR(co.`start`) BETWEEN 6 and 20,'Day','Night'),
co.bill,cl.full_name,ca.make,ca.model,c.`name`
FROM addresses as a
JOIN courses AS co
ON co.from_address_id = a.id
JOIN cars as ca
ON ca.id = co.car_id
JOIN clients as cl
ON cl.id = co.client_id
JOIN categories as c
ON c.id = ca.category_id
ORDER BY co.id;