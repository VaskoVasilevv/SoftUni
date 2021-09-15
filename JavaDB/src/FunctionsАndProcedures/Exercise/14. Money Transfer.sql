DELIMITER ##
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DOUBLE(19,4)) 
BEGIN
START TRANSACTION;
	IF(SELECT COUNT(*) FROM accounts WHERE id = from_account_id) = 0
		OR (amount <= 0)
		OR (from_account_id IS NULL)
		OR ((SELECT `balance` FROM accounts WHERE id = from_account_id) < amount)
        THEN ROLLBACK;
	ELSE
		UPDATE accounts
        SET balance = balance + amount
        WHERE id = to_account_id
        ;
        UPDATE accounts
        SET balance = balance - amount
        WHERE id = from_account_id;
	END IF;
END##
    
DELIMITER ;