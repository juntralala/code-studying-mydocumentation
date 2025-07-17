/**
 * One to one relationship adalah relasi antar table yang paling sederhana 
 * Artinya tiap data di satu table hanya boleh berelasi maksimal ke 1 data di table lainnya
 * Jadi, tidak boleh ada relasi lebih dari 1 data
 * Contohnya, misal kita membuat toko online yang terdapat fitur wallet, dan 1 customer, cuman boleh punya 1 wallet 
*/

/** membuat one to one relationship
 * kita bias membuat kolom foreign key, lalu set kolom tersebut menggunakan UNIQUE KEY, agar dapat mencegah terjadi data
   duplikat di kolom tersebut 
 * Atau cara lainnya, kita bisa membuat table dengan primary key yang sama, sehingga tidak dibutuhkan lagi kolom untuk
   dijadikan FOREIGN KEY
*/

CREATE TABLE wallet (
    id INT NOT NULL AUTO_INCREMENT,
    id_customer INT NOT null,
    balance INT NOT NULL DEFAULT 0,
    PRIMARY KEY (id),
    UNIQUE KEY id_customer_unique (id_customer),
    FOREIGN KEY fk_wallet_customer (id_customer) REFERENCES customers(customer));