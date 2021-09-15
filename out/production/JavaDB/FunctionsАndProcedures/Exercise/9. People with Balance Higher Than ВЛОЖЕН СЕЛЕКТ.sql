CREATE PROCEDURE usp_get_holders_with_balance_higher_than(amount DECIMAL(19,4))

BEGIN

SELECT ah.first_name, ah.last_name
        
        FROM account_holders ah
        JOIN accounts a ON a.account_holder_id = ah.id
        WHERE (SELECT SUM(a.balance)  GROUP BY ah.id) > amount
        GROUP BY ah.id
        ORDER BY a.id, ah.first_name, ah.last_name;

END