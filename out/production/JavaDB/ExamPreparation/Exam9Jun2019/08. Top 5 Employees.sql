SELECT CONCAT(first_name,' ',last_name)
,e.started_on, COUNT(em.client_id) as `count`
 FROM employees as e
 JOIN employees_clients as em
 on em.employee_id = e.id
GROUP BY e.id
ORDER BY `count`DESC,e.id
LIMIT 5;