
SELECT p.`id`,p.`date`,`description`
,COUNT(c.id) AS `commentsCount` FROM photos as p
JOIN `comments` as c
ON c.photo_id = p.id
GROUP BY p.id
ORDER BY `commentsCount` DESC , p.id ASC
LIMIT 5;