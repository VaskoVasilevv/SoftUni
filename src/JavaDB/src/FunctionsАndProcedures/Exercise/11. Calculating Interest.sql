DELIMITER ##
CREATE FUNCTION ufn_calculate_future_value(sum DECIMAL(19,4), interest DOUBLE,years INT)
RETURNS DECIMAL (19,4)
DETERMINISTIC
BEGIN
	RETURN (sum * POW(1+interest,years));
END ##



CREATE PROCEDURE usp_calculate_future_value_for_account(acc_id INT,interest DOUBLE)
BEGIN
	SELECT a.`id`AS `account_id`
    ,ah.`first_name`,ah.`last_name`
    ,a.`balance` AS `current_balance`
    ,ufn_calculate_future_value(a.`balance`,interest,5)
    AS `balance_in_5_years`
    FROM `accounts` as a
    JOIN `account_holders` as ah
    ON a.account_holder_id = ah.id
    WHERE a.id = acc_id;
END ##
DELIMITER ;