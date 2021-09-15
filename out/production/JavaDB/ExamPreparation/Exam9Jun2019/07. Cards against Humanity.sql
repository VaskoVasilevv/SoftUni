SELECT cards.id ,CONCAT(cards.card_number,' : ',c.full_name)
FROM cards 
 JOIN bank_accounts as b
ON b.id = cards.bank_account_id
 JOIN clients as c
ON c.id = b.client_id
ORDER BY cards.id DESC;