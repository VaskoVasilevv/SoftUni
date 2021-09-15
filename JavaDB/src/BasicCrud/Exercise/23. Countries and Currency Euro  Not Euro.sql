SELECT `country_name`,`country_code`,
If(`currency_code` = 'EUR','Euro','Not Euro') as 'currency'
from `countries`
ORDER BY `country_name`;