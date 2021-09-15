SELECT CONCAT( u.`id`,' ',`username` ) AS `id_username`
, u.`email` FROM `users` as u
JOIN `users_photos` as up
ON up.user_id = u.id
WHERE up.photo_id = up.user_id
ORDER By u.id;