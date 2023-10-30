
<<============================================>> fitur INDEX <<============================================>>
kolom PRIMARY_KEY, UNIQUE_KEY dan FULLTEXT sudah memiliki INDEX jadi kita tidak perlu lagi menambahkan INDEX
INDEX dapat mempercepat kita ketika pencarian SELECT QUERY tetapi memperlambat proses UPDATE dan INSERT , DELETE dan perubahan table lainnya 

contohnya :
CREATE TABLE user (
    no INT NOT NULL AUTO_INCREMENT,
    nama1 VARCHAR(20) NOT NULL,
    nama2 VARCHAR(20) NOT NULL,
    nama3 VARCHAR(20) NOT NULL,
    umur SMALLINT NOT NULL,
    alamat VARCHAR(20),
    PRIMARY KEY (no),
   -- INDEX nama1_index(nama1),
    INDEX nama2_index(nama2),
    INDEX nama3_index(nama3),
    INDEX nama1_nama2_nama3_index(nama1,nama2,nama3)
);
ALTER TABLE user ADD INDEX nama1_index (nama1);
ALTER TABLE user DROP INDEX nama1_index;

contoh penggunaan :
SELECT * FROM user WHERE nama1 = "XXXX"; 
SELECT * FROM user WHERE nama1 = "XXXX" AND nama1 = "XXXX"; 
SELECT * FROM user WHERE nama1 = "XXXX" AND nama2 = "XXXX" AND nama3 = "XXXX"; 
SELECT * FROM user WHERE nama2 = "XXXX"; 
SELECT * FROM user WHERE nama3 = "XXXX"; 