CREATE FUNCTION `udf_stadium_players_count` (stadium_name VARCHAR(30)) 
RETURNS INTEGER
BEGIN

RETURN (SELECT COUNT(p.id) as count
 FROM stadiums as s
 LEFT  JOIN teams as t
 on t.stadium_id = s.id
 LEFT JOIN players as p
 on p.team_id = t.id
 WHERE s.`name` = stadium_name);
END