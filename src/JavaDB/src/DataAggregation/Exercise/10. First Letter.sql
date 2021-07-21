SELECT  LEFT( `first_name`,1)  as `f_char`
FROM `wizzard_deposits`
WHERE `deposit_group` = 'Troll Chest'
GROUP BY `f_char` 
ORDER BY `f_char`;