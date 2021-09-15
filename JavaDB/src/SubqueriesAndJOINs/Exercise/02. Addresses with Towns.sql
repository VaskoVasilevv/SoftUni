SELECT e.`first_name`,e.`last_name`,t.`name`,a.`address_text`
FROM `employees` as e
JOIN `addresses` as a
USING (`address_id`)
JOIN `towns` as t
ON t.town_id = a.town_id
ORDER BY e.`first_name`,e.`last_name`
LIMIT 5;