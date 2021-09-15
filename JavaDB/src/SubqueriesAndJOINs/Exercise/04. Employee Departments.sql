SELECT `employee_id`, `first_name`,`salary`,d.`name`
 FROM `employees`
 JOIN `departments` as d
 USING (`department_id`)
 WHERE `salary` > 15000
 ORDER BY d.`department_id` DESC
 LIMIT 5;