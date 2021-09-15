SELECT p.id , CONCAT(first_name,' ',last_name) AS 'full_name',
`age`,`position`,hire_date
FROM `players` as p
JOIN `skills_data` as s
on p.skills_data_id = s.id
WHERE position = 'A' AND hire_date IS NULL AND age < 23
AND strength > 50
ORDER BY salary ASC, age ASC; 