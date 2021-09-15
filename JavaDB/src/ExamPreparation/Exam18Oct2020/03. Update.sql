
update employees as e
join stores as s
on e.store_id = s.id
set e.manager_id = 3 
where year(e.hire_date) > 2003 and s.`name` not in('Cardguard','Veribet');

update employees as e
join stores as s
on e.store_id = s.id
set e.salary = e.salary - 500
where year(e.hire_date) > 2003 and s.`name` not in('Cardguard','Veribet');
 