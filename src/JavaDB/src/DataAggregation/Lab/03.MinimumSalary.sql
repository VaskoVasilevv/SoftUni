SELECT `department_id` , round(MIN(`salary`),2 ) 
as 'Min Salary' 
FROM `employees`
GROUP BY`department_id`
HAVING `Min Salary` > 800
;