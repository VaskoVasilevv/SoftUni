SELECT `country_name` ,`continent_code`,`population`
 FROM countries
 WHERE `continent_code` = 'EU'
 ORDER BY `population` DESC,`country_name`
 LIMIT 30;