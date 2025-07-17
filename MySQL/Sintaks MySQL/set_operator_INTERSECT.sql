/**
 * INTERSECT adalah operasi menggabungkan dua query, namun yang diambil hanya data yang terdapat pada hasil query pertama
   dan query kedua
 * Data yang tidak hanyak di salah satu query, akan dihapus dihasil operasi INTERSECT
 * Datanya muncul dalam kedaan duplikat
 * Sayangnya, MySQL tidak memiliki operator INTERSECT, dengan demikian untuk melakukan operasi INTERSECT, kita harus melakukannya
   secara manual menggunakan JOIN atau SUBQUERY
*/

SELECT DISTINCT email FROM customers 
WHERE email IN (SELECT DISTINCT email FROM guestbook);

SELECT email FROM customers 
INNER JOIN guestbooks ON (guestbooks.email = customers.emailcl);