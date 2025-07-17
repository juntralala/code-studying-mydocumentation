SELECT * 
FROM products
WHERE category = 'Makanan' OR (quanity > 50 AND price > 10000);  