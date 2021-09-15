SELECT `employee_id`, `first_name`,`last_name`,d.`name`
 FROM `employees`
 JOIN `departments` as d
 USING (`department_id`)
 WHERE d.`name` = 'Sales'
 ORDER BY `employee_id` DESC;