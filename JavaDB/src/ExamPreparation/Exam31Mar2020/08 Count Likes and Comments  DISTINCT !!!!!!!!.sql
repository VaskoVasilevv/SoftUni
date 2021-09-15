SELECT p.id AS `photo_id` ,
 COUNT(DISTINCT l.id) AS `likes_count`
,COUNT(DISTINCT c.id) AS `comments_count` 
FROM `photos` as p
LEFT JOIN likes as l
on l.photo_id = p.id
 JOIN comments as c
ON c.photo_id = p.id
GROUP BY p.id
ORDER BY likes_count DESC , comments_count DESC,
p.id ASC;