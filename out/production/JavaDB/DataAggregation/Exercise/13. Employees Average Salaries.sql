CREATE TABLE `hpe` as
SELECT * FROM `employees`
where `salary` > 30000 and `manager_id` != 42;
UPDATE `hpe`
SET `salary` = `salary` + 5000
WHERE `department_id` = 1;
SELECT `department_id`, avg(`salary`) as 'avg_salary'
FROM `hpe`
GROUP BY `department_id` 
order BY `department_id`;