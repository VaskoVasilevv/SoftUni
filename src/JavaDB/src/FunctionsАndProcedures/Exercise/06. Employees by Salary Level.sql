CREATE FUNCTION `ufn_get_salary_level` (e_salary DECIMAL )
RETURNS VARCHAR(10)
DETERMINISTIC
BEGIN
	RETURN   (CASE
			WHEN e_salary < 30000 THEN 'Low'
            WHEN e_salary BETWEEN 30000 AND 50000 THEN 'Average'
            WHEN e_salary > 50000 Then 'High' 
			END
         );
END;



CREATE PROCEDURE `usp_get_employees_by_salary_level` (s_level VARCHAR(10))
BEGIN
	SELECT `first_name`,`last_name` FROM `employees`
    WHERE ufn_get_salary_level(salary) = s_level
    ORDER BY `first_name` DESC, `last_name` DESC;
END;