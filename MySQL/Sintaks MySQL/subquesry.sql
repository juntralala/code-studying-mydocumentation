/**
 * Mysql Mendukung pencarian data menggunakan WHERE dari hasil SELECT query
 * fitur ini dinamakan Subquery
 * Contoh, kita ingin mencari products yang harganya di atas harga rata-rata, artinya kita akan melakukan SELECT 
   dengan WHERE price > harga rata, dimana harga rata-rata perlu kita hitung menggunakan query SELECT lainya menggunakan
   agregate function AVG
*/

-- subquery pada FROM 
SELECT * FROM products WHERE price > (select AVG(price) from products) 