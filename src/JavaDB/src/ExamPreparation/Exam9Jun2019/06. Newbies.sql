SELECT e.id,CONCAT(e.first_name , " " , e.last_name) ,CONCAT('$',e.`salary`),e.started_on
FROM employees as e

WHERE e.salary >= 100000 AND
date(e.started_on) >= '2018-01-01'
ORDER BY e.salary DESC,e.id DESC;
