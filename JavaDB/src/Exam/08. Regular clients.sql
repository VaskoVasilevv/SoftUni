SELECT 
    cl.full_name,
    COUNT(c.id) AS 'count_of_cars',
    SUM(co.bill) AS 'total_sum'
FROM
    clients AS cl
        JOIN
    courses AS co ON cl.id = co.client_id
        JOIN
    cars AS c ON co.car_id = c.id
GROUP BY cl.id
HAVING cl.full_name LIKE '_a%'
    AND count_of_cars > 1
ORDER BY cl.full_name;