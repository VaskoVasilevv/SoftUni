SELECT concat_ws(' ',`first_name`,`last_name`)
AS 'Full Name',timestampdiff(day,born,died) AS 'Days Lived'
FROM authors;