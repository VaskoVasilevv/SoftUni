SELECT `deposit_group`,MAX(`magic_wand_size`) AS 'max_size'
FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `max_size`,`deposit_group`;