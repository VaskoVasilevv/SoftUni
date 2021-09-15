SELECT * FROM soft_uni.towns
WHERE `name` REGEXP '^[MKBE]{1}[a-z]+'
ORDER BY `name`;