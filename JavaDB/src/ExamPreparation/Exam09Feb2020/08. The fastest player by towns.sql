SELECT max(sd.speed) as `max_speed`,towns.`name`
FROM players as p
RIGHT JOIN skills_data as sd
on p.skills_data_id = sd.id
RIGHT JOIN teams as t
on p.team_id = t.id
RIGHT JOIN stadiums as s
on t.stadium_id = s.id
RIGHT JOIN towns 
on s.town_id = towns.id
WHERE t.`name` != 'Devify'
GROUP BY towns.`name`
ORDER BY max_speed DESC , towns.`name`;