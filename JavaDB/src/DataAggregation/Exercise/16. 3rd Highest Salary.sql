SELECT e.`department_id`,
(
	SELECT DISTINCT e2.`salary`
	FROM `employees`as e2
	WHERE e2.`department_id` = e.`department_id`
	ORDER BY `salary` DESC
	LIMIT 1 OFFSET 2
) as `ths`
FROM `employees` as e
GROUP BY e.`department_id`
HAVING `ths` IS NOT NULL
ORDER BY e.`department_id`;