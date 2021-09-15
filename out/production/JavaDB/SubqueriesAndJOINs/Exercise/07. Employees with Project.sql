SELECT e.`employee_id`,e.`first_name`,p.`name`
FROM employees as e
JOIN `employees_projects` as ep
USING (`employee_id`)
JOIN `projects` as p
USING (`project_id`)
WHERE DATE(p.`start_date`) > 2002-08-13 And p.end_date is null
ORDER BY e.`first_name`ASC , p.`name` ASC
LIMIT 5;