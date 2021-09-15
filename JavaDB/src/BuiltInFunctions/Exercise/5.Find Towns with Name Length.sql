SELECT `name` FROM towns
WHERE char_length(`name`) = 5 or char_length(`name`) = 6
order by `name`;