DELETE FROM `employees`
WHERE id != 3 and manager_id IS NOT NULL and salary >= 6000;