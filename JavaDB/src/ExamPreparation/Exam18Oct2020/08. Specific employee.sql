SELECT concat_ws(' ',e.first_name,e.last_name) AS
`full_name`,s.`name`,a.`name`as `address`,e.salary
FROM employees as e
JOIN stores as s
on s.id = e.store_id
JOIN addresses as a
on a.id = s.address_id
WHERE e.salary < 4000 AND
a.`name` LIKE '%5%' AND
char_length( s.`name` ) > 8 AND
right( e.last_name ,1) = 'n'
;