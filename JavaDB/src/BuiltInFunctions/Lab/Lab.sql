#01 Lab
SELECT title FROM books
WHERE substr(title,1,3) = 'the'
ORDER BY `id`ASC;

#02 Lab
SELECT replace(title,'The','***') AS newtitle FROM books
WHERE substr(title,1,3) = 'the'
ORDER BY `id`ASC;

