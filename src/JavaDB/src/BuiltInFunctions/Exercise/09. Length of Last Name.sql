# Ex 07
SELECT `town_id`,`name` FROM `towns`
WHERE `name` REGEXP '^[^RBD]{1}'
ORDER BY `name`;

# Ex 08
CREATE VIEW `v_employees_hired_after_2000` AS
SELECT `first_name`,`last_name` FROM `employees`
WHERE year(`hire_date`) > 2000;
SELECT * FROM`v_employees_hired_after_2000`;

# Ex 09
SELECT `first_name`,`last_name` FROM `employees`
WHERE char_length(`last_name`) = 5;

# Ex 10
SELECT `country_name`,`iso_code` FROM`countries`
WHERE `country_name` LIKE '%A%A%A%'
ORDER BY `iso_code`;

# Ex 11
SELECT 
    `peak_name`,
    `river_name`,
    LOWER(CONCAT(`peak_name`, SUBSTRING(`river_name`, 2))) AS `mix`
FROM
    `peaks`,
    `rivers`
WHERE
    RIGHT(`peak_name`, 1) = LEFT(`river_name`, 1)
ORDER BY `mix`;

# Ex 12
SELECT `name`, DATE_FORMAT(`start`,'%Y-%m-%d') AS `start`
 FROM `games`
 WHERE year(`start`) BETWEEN 2011 and 2012
 ORDER BY`start`,`name`
 LIMIT 50;
 
# Ex 13
SELECT 
    `user_name`,
    SUBSTR(`email`,
        LOCATE('@', `email`) + 1) AS 'Email Provider'
FROM
    `users`
ORDER BY `Email Provider` , `user_name`;

# Ex 14
SELECT `user_name`,`ip_address` FROM `users`
WHERE `ip_address` LIKE '___.1%.%.___'
ORDER BY `user_name`;

# Ex 15
SELECT 
    `name`,
    (CASE
        WHEN HOUR(`start`) BETWEEN 0 AND 11 THEN 'Morning'
        WHEN HOUR(`start`) BETWEEN 12 AND 17 THEN 'Afternoon'
        ELSE 'Evening'
    END) AS 'Part of the Day',
    (CASE
        WHEN `duration` < 4 THEN 'Extra Short'
        WHEN `duration` < 7 THEN 'Short'
        WHEN `duration` < 11 THEN 'Long'
        ELSE 'Extra Long'
    END) AS 'Duration'
FROM
    `games`;
    
    
# Ex 16
SELECT 
    `product_name`,
    `order_date`,
    DATE_ADD(`order_date`, INTERVAL 3 DAY) AS 'pay_due',
    DATE_ADD(`order_date`, INTERVAL 1 MONTH) AS 'deliver_due'
FROM
    `orders`;






