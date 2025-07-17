/** DEADLOCK
 * Saat kita melakukan terlalu banyak proses Locking (manual), akan masalah yang bisa terjadi, yaitu DEADLOCK   
 * Deadlock adalah situasi ada 2 proses yang saling menuggu satu sama lain, namun data yang ditunggu dua-duanya di lock oleh
   proses lainnya, sehingga proses menuggunya ini tidak akan pernah selesai
*/

/** Contoh Deadlock
 * Proses 1 melakukan SELECT FOR UPDATE untuk data 001
 * Proses 2 melakukan SELECT FOR UPDATE untuk data 002
 * Proses 1 melakukan SELECT FOR UPDATE untuk data 002, diminta menunggu karena dilock oleh Proses 2
 * Proses 2 melakukan SELECT FOR UPDATE untuk data 001, diminta menunggu karena dilock oleh Proses 1
 * Akhirnya Proses 1 dan Proses 2 saling menunggu 
 * Deadlock pun terjadi
-- Proses = user
*/

-- user 1
SELECT * FROM products FOR UPDATE;

SELECT * FROM products FOR UPDATE;

-- user 2
SELECT * FROM products FOR UPDATE;

SELECT * FROM products FOR UPDATE;