SELECT t.`name`,t.`established`,t.`fan_base` 
,(SELECT COUNT(*) from players
WHERE team_id = t.id) as count
FROM teams as t
order by count DESC,fan_base DESC;