/**
 * Minus adalah operasi dimana query pertama akan dihilangkan oleh query kedua
 * Artinya jika ada data di query pertama yang sama dengan data yang ada di query kedua, maka data tersebut akan dihapus dari
   hasil query MINUS
 * Sayang nya, di MySQL tidak ada operator MINUS, namun hal ini bisa kita lakukan menggunakan JOIN
*/

SELECT DISTINCT customers.email, guestbooks.email FROM customers
LEFT JOIN guestbooks ON (customers.email = guestbooks.email)
WHERE guestbooks.eamil IS NULL;