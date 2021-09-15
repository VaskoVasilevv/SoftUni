SELECT s.`name`, COUNT(p.id) AS `product_count`,
ROUND( avg(p.price),2) AS `avg` FROM stores as s
LEFT JOIN products_stores as ps
ON ps.store_id = s.id
LEFT JOIN products as p
on p.id = ps.product_id
GROUP BY s.id
ORDER BY product_count DESC,`avg` DESC , s.id
;