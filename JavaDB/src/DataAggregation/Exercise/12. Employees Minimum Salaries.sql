SELECT `department_id`,min(`salary`) as 'min_salary'
FROM `employees`
WHERE `department_id` IN (2,5,7) AND year(`hire_date`) >= 2000
GROUP BY `department_id`
ORDER BY`department_id`;