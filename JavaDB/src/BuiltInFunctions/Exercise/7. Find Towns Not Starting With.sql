SELECT `town_id`,`name` FROM `towns`
WHERE `name` REGEXP '^[^RBD]{1}'
ORDER BY `name`;