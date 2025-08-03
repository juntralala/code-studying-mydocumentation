/**
 * Selain secara otomatis, kadang saat kita membuat aplikasi, kita sering melakukan SELECT query terlebih dahulu sebelum melakukan
   melakukan proses UPDATE misalnya
 * Jika kita ingin melakukan locking sebuah data secara manual, kita bisa tamabahkan perintah FOR UPDATE di belakang query SELECT
 * Saat kita lock record yang kita select, maka jika ada proses lain yang akan melakukan UPDATE, DELETE atau SELECT FOR UPDATE lagi,
   maka proses lain tersebut akan diminta menuggu sampai kita selesai melakukan COMMIT atau ROLLBACK transaction
*/ 

-- user 1
SELECT * FROM products FOR UPDATE;

UPDATE products
SET quantity = quantity - 10
WHERE id = 'P001';

COMMIT;

-- user 2
SELECT * FROM products FOR UPDATE;

UPDATE products
SET quantity = quantity - 10
WHERE id = 'P001';

COMMIT;