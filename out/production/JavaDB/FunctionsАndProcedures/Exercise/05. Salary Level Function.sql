DELIMITER ##
CREATE FUNCTION `ufn_get_salary_level` (e_salary DECIMAL (19,4))
RETURNS VARCHAR(10)
DETERMINISTIC
BEGIN
	RETURN   (CASE
			WHEN e_salary < 30000 THEN 'Low'
            WHEN e_salary BETWEEN 30000 AND 50000 THEN 'Average'
            WHEN e_salary > 50000 Then 'High' 
			END
         );
END##
DELIMITER ;