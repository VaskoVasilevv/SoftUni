SELECT e.`first_name`,e.`last_name`,e.`hire_date`,d.`name`
FROM `employees` as e
JOIN `departments` as d
ON e.`department_id` = d.department_id
WHERE DATE(e.`hire_date`) > 1999-01-01 AND
d.`name` IN ('Sales', 'Finance')
ORDER BY `hire_date`;