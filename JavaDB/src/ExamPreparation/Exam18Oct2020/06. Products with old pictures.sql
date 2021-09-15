SELECT p.`name` AS product_name,p.price,
p.best_before,CONCAT( LEFT( p.`description`,10),'...')
AS short_description , pi.url
from `products` as p
LEFT JOIN pictures AS pi
 ON pi.id = p.picture_id
 WHERE  char_length(p.`description`) > 100
 AND YEAR(pi.added_on) < 2019
 AND p.price > 20
 ORDER BY price DESC;