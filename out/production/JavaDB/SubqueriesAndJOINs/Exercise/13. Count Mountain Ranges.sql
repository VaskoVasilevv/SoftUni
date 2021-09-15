SELECT mc.`country_code`, COUNT(m.`mountain_range`)
 FROM mountains_countries AS `mc`
 JOIN mountains AS `m` ON mc.`mountain_id` = m.`id`
 WHERE mc.`country_code` IN ('BG', 'US', 'RU')
 GROUP BY mc.`country_code`
 ORDER BY COUNT(m.`mountain_range`) DESC; 