-- liat contohnya di file 'sintak MySQL.sql' --

<(================ TAMBAHAN ================)>

Menyisipkan data dari tabel lain dengan menggunakan perintah SELECT. Contoh: 
INSERT INTO table_name SELECT column1, column2 FROM another_table;

Menyisipkan data dengan opsi IGNORE atau ON DUPLICATE KEY UPDATE untuk menangani duplikasi kunci. Contoh:
 INSERT IGNORE INTO table_name VALUES (value1, value2, value3);