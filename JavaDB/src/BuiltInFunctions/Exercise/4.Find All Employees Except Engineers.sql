SELECT `first_name`,`last_name`,`job_title` FROM soft_uni.employees
WHERE `job_title` not like '%engineer%'
ORDER BY `employee_id`;