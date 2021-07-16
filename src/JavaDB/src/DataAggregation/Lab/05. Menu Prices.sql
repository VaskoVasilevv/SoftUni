SELECT `category_id`, ROUND(AVG(`price`),2) AS 'Average Price' ,
ROUND(min(`price`),2) AS 'Cheapest Product',
ROUND(max(`price`),2) AS 'Most Expencive Product'
FROM products
GROUP BY `category_id`
ORDER BY`category_id`;