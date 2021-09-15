SELECT `department_id`,count(*) AS
'Numbefr of employees' FROM `employees` as `e`
GROUP BY e.department_id
;