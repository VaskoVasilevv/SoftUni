SELECT e.`employee_id`,e.`job_title`,a.`address_id`,
a.`address_text` from `employees` as e
JOIN `addresses` AS a
ON a.`address_id` = e.`address_id`
ORDER BY `address_id` ASC
LIMIT 5
;