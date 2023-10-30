/**
 * UNION adalan operasi mengabungkan dua buah SELECT query, nimana jika ada data duplikat, data duplikatnya akan dihapus dari query 
*/
SELECT DISTINCT email FROM customers 
UNION 
SELECT DISTINCT email FROM guestbooks;