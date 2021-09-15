SELECT reverse(s.`name`) AS `reversed_name`,
CONCAT(UPPER( t.`name`),'-', a.`name`) as full_address,COUNT(e.id) AS `employees_count`
FROM stores as s
JOIN addresses  as a
on a.id = s.address_id
JOIN towns as t
ON t.id = a.town_id
JOIN employees as e
on e.store_id = s.id
GROUP BY s.id
ORDER BY full_address 
;