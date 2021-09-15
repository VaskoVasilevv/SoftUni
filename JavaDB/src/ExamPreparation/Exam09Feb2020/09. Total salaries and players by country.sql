SELECT c.`name`,COUNT(p.id) as total_sum_of_salaries,SUM(salary) AS total_count_of_players
FROM players as p
RIGHT JOIN teams as t on p.team_id = t.id
RIGHT JOIN stadiums as s on t.stadium_id = s.id
RIGHT JOIN towns on s.town_id = towns.id
RIGHT JOIN countries as c on towns.country_id = c.id
GROUP BY c.`name`
ORDER BY total_count_of_players DESC , c.`name`;