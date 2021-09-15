
DELETE FROM `clients` 
WHERE `id` NOT IN (SELECT `client_id` FROM courses) and char_length(full_name) > 3;