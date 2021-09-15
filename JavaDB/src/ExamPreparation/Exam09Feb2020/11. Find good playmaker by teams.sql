CREATE PROCEDURE `udp_find_playmaker` (min_dribble_points INT,team_name VARCHAR(45))
BEGIN
 SELECT concat_ws(' ',first_name,last_name)as `full_name`
 ,age,salary,dribbling,speed,t.`name`
 FROM players as p
 JOIN skills_data as sd
 on sd.id = p.skills_data_id
 JOIN teams as t
 on t.id = p.team_id
 WHERE dribbling >= min_dribble_points and t.`name` = team_name
 ORDER BY speed DESC
 LIMIT 1;
END