INSERT INTO `cards`(card_number,card_status,bank_account_id)

SELECT reverse(`full_name`),'Active',id FROM clients
WHERE id BETWEEN 191 and 200;