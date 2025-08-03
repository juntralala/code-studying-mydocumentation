
<<============================================>> fitur FULL TEXT SEARCH <<============================================>>   <-- didalam FULLTEXT sudah ada terdapat index jadi kita tidak perlu lagi menambah kakn index pada FULLTEXT

contohnya :
CREATE TABLE produk (
    id          VARCHAR(10)  NOT NULL,
    nama        VARCHAR(100) NOt NULL,
    deskripsi   TEXT,
    harga       INT UNSIGNED NOt NULL ,
    kuantitas   INT UNSIGNED NOT NULL DEFAULT 0,
    dibuat_pada TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FULLTEXT produk_search (nama, deskripsi)
);
ALTER TABLE produk ADD FULLTEXT produk_search (nama, deskripsi);
ALTER TABLE produk DROP INDEX produk_search;

==================================> contoh pencarian menggunakan FULLTEXT SEARCH:
FULLTEXT SEARCH memiliki 3 mode :
1. NATURAL LANGUAGE MODE                                   <-- mencari persatu kata yang sesuai
2. BOOLEAN MODE                                            <-- mencari menggunakan + jika ingin ada kata, - jika tidak ingin ada kata tertentu
3. QUERY EXPANSION                                         <-- mencari kata yang sesuai atau mirip 

------------------> contoh NATURAL LANGUAGE
SELECT * FROM produk WHERE MATCH(nama, deskripsi) AGAINST('ayam' IN NATURAL LANGUAGE MODE);

------------------> contoh BOOLEAN
SELECT * FROM produk WHERE MATCH(nama, deskripsi) AGAINST('+ayam -Mie' IN BOOLEAN MODE);

------------------> contoh WITH QUERY EXPANSION
SELECT * FROM produk WHERE MATCH(nama, deskripsi) AGAINST('Goreng' WITH QUERY EXPANSION);