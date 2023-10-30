========================================================>  operasi database:  <========================================================

SHOW DATABASES;
CREATE DATABASE _namaDatabase_;
DROP DATABASE _namaDatabase_;
RENAME DATABASE _namaDatabase_ TO _namaDatabaseBaru_;

========================================================>  operasi membuat table:  <========================================================

CREATE TABLE _namaTable_(
    field1 tipedata(panjang) PRIMARY KEY,
    field2 tipedata(panjang),
    fieldn tipedata(panjang),
    FOREIGN KEY _namaField_ references _tableParent_(nama_field);
);
CREATE TABLE _namaTable_(
    field1 tipedata(panjang),
    field2 tipedata(panjang),
    field3 DATE CURRENT_TIMESTAMP,
    fieldn tipedata(panjang),
    PRIMARY KEY (nama_field),
    FOREIGN KEY (_namaField_) references _tableParent_(nama_field);
);

===========================================================>  operasi table  <===========================================================

SHOW TABLES;
DESC _namaTable_;
SHOW CREATE TABLE _namaTable_;
DROP TABLE _namaTable_;
RENAME TABLE _namaTable_ TO _namaTableBaru_;                                                
ALTER TABLE _namaTable_ ADD COLUMN _namaField_ tipedata default 0 primary key FIRST/AFTER;
                        ADD PRIMARY KEY(nama_field);
                        ADD FOREIGN KEY (nama_field) references _namaTable_(nama_field);
                        DROP COLUMN _namaField_;                                            
                        RENAME COLUMN _namaField_ TO _namaFieldBaru_;                        <-- mengganti nama colum
                        MODIFY _namaField_ tipedata FIRST/AFTER;                                                               <-- harus disertai tipe data colum
                        CHANGE _namaField_ _namaFieldBaru_ tipedata FIRST/AFTER;             <-- ganti nama column             <-- harus disertai tipe data colum

==>  operasi record  <==

INSERT INTO _namaTable_ VALUES
    ('datafield1', 'datafield2'),
    ('datafield1', 'datafield2');
INSERT INTO _namaTable_(field1,field2) VALUES
    ('datafield1', 'datafield2'),
    ('datafield1', 'datafield2');
INSERT INTO _namaTable_ VALUES
    (field1 = 'datafield1', field2 = 'datafield2'),
    (field1 = 'datafield1', field2 = 'datafield2');
SELECT * FROM _namaTable_ WHERE ...;
SELECT field1, field2 FROM _namaTable_;
SELECT field1 AS 'ANU', field2 AS 'ANU2' FROM _namaTable_;
TRUNCATE _namaTable_;                                                                         <-- menghapus record
DELETE FROM _namaTable_ WHERE _namaField_ = _nilaiField_;                                                                      <-- menghapus record
UPDATE _namaTable_ SET _namaField_ = _nilaiBaru_ WHERE _namaField_ = _nilaiField_; 

<--------------------------------------------------- contoh SUBQUERY --->
SELECT
    emp_name AS 'Nama Pegawai',
    job_name AS 'Jabatan',
    salary AS Gaji 
FROM employees 
    WHERE salary >(SELECT salary FROM employees WHERE emp_name = 'ADELYM') AND job_name != 'PRESIDENT';

<{======================================================== operator perbandingan ========================================================}>
1. =
2. <> atau !=
3. <
4. >
5. =<
6. =>

<{=========================================================== operator logika ===========================================================}>
1. AND
2. OR
3. NOT

<{======================================================== OPERATOR ngak tau namanya ========================================================}>
1. LIKE                                                 <!--- Operator LIKE sangat lambat, oleh karena itu, tidak disarankan jika datanya telah telah besar --!>
2. ILIKE
3. IS NULL atau IS NOT NULL
4. BETWEEN atau NOT BETWEEN
5. IN atau NOT IN
6. ALL atau NOT ALL
7. ANY atu NOT ANY atau SOME

<>=============================================================== KLAUSA QUERY =============================================================== <>
1. FROM
2. WHERE
3. HAVING                                 <!--- digunakan bersama AGREEGATE FUNCTION
4. ORDER BY ... ASC/DESC
5. DISTINCT                                  <-- menghapus data yang duplikat pada query
6. GROUP BY                                 <!--- hanya bisa digunakan bersama AGREEGATE FUNCTION
7. JOIN
8. LIMIT


<======(contoh LIKE)======>
SELECT * FROM pegawai WHERE nama LIKE 'a%';
SELECT * FROM pegawai WHERE nama LIKE '%a';
SELECT * FROM pegawai WHERE nama LIKE '%a%';
SELECT * FROM pegawai WHERE nama NOT LIKE '%a%';

<======(contoh BETWEEN)======>
SELECT * FROM pegawai WHERE gaji BETWEEN 1000 AND 12000 ;

<(contoh BETWEEN)>
SELECT * FROM pegawai WHERE job_name IN ('SALESMAN', 'MANAGER') ;
SELECT * FROM pegawai WHERE gaji IN ( 200, 1500) ;

<======(contoh ORDER BY)======>
SELECT * FROM pegawai ORDER BY nama;
SELECT * FROM pegawai ORDER BY nama ASC;
SELECT * FROM pegawai ORDER BY nama DESC;
SELECT * FROM pegawai ORDER BY nama ASC, gaji DESC;

<======(contoh LIMIT)=====>
SELECT * FROM pegawai LIMIT 2;
SELECT * FROM pegawai WHERE gaji < 200 LIMIT 2;
SELECT * FROM pegawai WHERE job_name = 'SALESMAN' LIMIT 2;
SELECT * FROM pegawai WHERE gaji IN ( 200, 1500) LIMIT 2;
SELECT * FROM pegawai WHERE emp_name LIKE '%a%' LIMIT 2;
SELECT * FROM pegawai ORDER BY nama DESC LIMIT 2;
SELECT * FROM pegawai LIMIT 5, 2;
SELECT * FROM pegawai ORDER BY nama LIMIT 2 ,2;
SELECT * FROM _namaTable_ LIMIT _offSet_, _limit_;                          _offSet_ : skip/tempat memulai hitungan

<======(contoh DISTINCT)======>
SELECT DISTINCT job_name FROM pegawai;

<======(contoh ALL)======>
select
    emp_name as 'Nama Pegawai',
    job_name as 'Jabatan',
     salary as Gaji
from
    employees
        where salary > any(select salary from employees where job_name = 'CLERK');

<======(contoh ANY)======>
select emp_name as 'Nama Pegawai', job_name as 'Jabatan', salary as Gaji from employees where salary > any(select salary from employees where job_name = 'CLERK');

<{===== ARITHMETIC OPERATOR =====}>
1. +
2. -
3. *
4. /
5. DIV
6. % atau MOD
7. -                                            <-- merubah bilangan jadinegatif

<======(contoh operator ARITMATHIC)=======>
SELECT 10 + 10 AS hasil;
SELECT 10, 10, 10, 10 + 10 AS hasil1, 10 * 10 AS hasil2;
SELECT salary DIV 10 AS 'GAJI_50%' FROM employees;


<{======================================================== Beberapa MATHEMATICAL FUNCTIONS ========================================================}>
1. PI()
2. POWER(bilangan , pangkat) atau POW(bilangan , pangkat)
3. COS(angaka)
4. SIN(angaka)
5. TAN(angaka)

<<--------->> fitur AUTO_INCREMENT <<--------->>                              <!-- AUTO_INCREMENT hanya bisa digunakan pada PRIMARY KEY
CREATE TABLE _namaTable_ (
    field1 INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    field2 tipedata,
    fieldn DATE DEFAULT CURRENT_TIMESTAMP,
); 
SELECT LAST_INSERT_ID();                                                         <== function khusus untuk melihat id terakhir yangdi tambahkan oleh AUTO_INCREMENT


<{========================================================== Beberapa STRING FUNCTIONS ==========================================================}>
1. LOWER()
2. UPPER()
3. LENGTH()

contohnya :
SELECT LOWER(emp_name), UPPER(emp_name), LENGTH(emp_name) FROM employees;


<{===== Beberapa DATE FUNCTIONS =====}>
1. EXTRACT(YEAR/MONTH/DAY FROM DATE/_namaField_)
2. YEAR(DATE)
3. MONTH(DATE)
4. DAY(DATE)

contohnya :
SELECT no, nama, EXTRACT(YEAR FROM tanggal_dibuat) FROM test;
SELECT no, nama, EXTRACT(MONTH FROM tanggal_dibuat) FROM test;
SELECT no, nama, EXTRACT(DAY FROM tanggal_dibuat) FROM test;
SELECT no, nama, YEAR(tanggal_dibuat) FROM test;
SELECT no, nama, MONTH(tanggal_dibuat) FROM test;
SELECT no, nama, DAY(tanggal_dibuat) FROM test;

<<======================================================>> CONTROL FLOW FUNCTIONS <<======================================================>>

=================================> FLOW CONTROL OPERATOR 
1. CASE
2. IF()
3. IFNULL()
4. NULLIF()

contoh CASE :
SELECT
    emp_name as Nama,
    job_name as 'Perkerjaan',
    CASE  job_name
        WHEN 'PRESIDENT' THEN 'BOSNYA'
        WHEN 'MANAGER' THEN 'Tangan Kanan'
        WHEN 'SALESMAN' THEN 'Anak Buah'
        WHEN 'ANALYST' THEN 'Penganalisa'
        WHEN 'clerk' THEN 'Pegawai Toko'
        ELSE ''
        END AS p
from employees;

contoh IF() :
SELECT
    emp_name AS Nama,
    job_name AS Perkerjaan,
    salary AS Gaji,
        IF( salary >= 2000, 'Banyak',
            IF( salary < 2000 AND salary >= 1000, 'Sedang', 'Sedikit')
            ) AS Keterangan
FROM employees;

contoh IFNULL() :
SELECT
    emp_name AS Nama,
    IFNULL(commission, '') AS Gaji
from employees;

<(----------------------------------- Beberapa AGREEGATE FUNCTION -----------------------------------)>
1. SUM(kolom)
2. COUNT(kolom)
3. AVG(kolom)                                                                     <== rata-rata         

contohnya :
SELECT SUM(salary) FROM employees;
SELECT COUNT(emp_id) FROM employees;
SELECT AVG(emp_id) FROM employees;
contoh menggunakan GROUP BY :
SELECT job_name AS Profesi, COUNT(job_name) AS Jumlah FROM employees GROUP BY job_name;
SELECT job_name AS Profesi, AVG(salary) AS Jumlah FROM employees GROUP BY job_name;
SELECT job_name AS Profesi, AVG(salary) AS Jumlah FROM employees GROUP BY job_name ORDER BY FIELD(job_name,
                                                                                        'PRESIDENT',
                                                                                        'MANAGER',
                                                                                        'ANALYST',
                                                                                        'SALESMAN',
                                                                                        'CLERK');


<<============================================>>  CONSTRAINT  <<============================================>>
1. PRIMARY KEY
2. FOREIGN KEY
3. UNIQUE KEY
4. CHECK

<<-------------------------------- << contoh UNIQUE KEY >>------------------------------------>>
CREATE TABLE pengguna (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nama VARCHAR(15),
    email VARCHAR(20),
    UNIQUE KEY email_unique (email)
);
ALTER TABLE test2 ADD CONSTRAINT id_unique UNIQUE KEY (id);
ALTER TABLE test2 DROP CONSTRAINT id_unique;

<<------------------------------------<< contoh CHECK >>------------------------------------>>
CREATE TABLE siswa (
    id INT ZEROFILL PRIMARY KEY AUTO_INCREMENT,
    nama VARCHAR(20) NOT NULL,
    umur SMALLINT,
    email VARCHAR(25),
    UNIQUE KEY email_unique (email),
    CONSTRAINT umur_check CHECK (NOT umur > 25)
);
ALTER TABLE siswa ADD CONSTRAINT umur_check CHECK (NOT umur > 25 );
ALTER TABLE siswa DROP CONSTRAINT umur_check;


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
    INDEX nama1_index(nama1),
    INDEX nama2_index(nama2),
    INDEX nama3_index(nama3),
    INDEX nama1_nama2_nama3_index(nama1,nama2,nama3)
);
ALTER TABLE user ADD INDEX nama1_index (nama1);
ALTER TABLE user DROP INDEX nama1_index;

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
1. NATURAL LANGUAGE MODE                                          <-- mencari persatu kata yang sesuai
2. BOOLEAN MODE                                                     <-- mencari menggunakan + jika ingin ada kata, - jika tidak ingin ada kata tertentu
3. QUERY EXPANSION

------------------> contoh NATURAL LANGUAGE
SELECT * FROM produk WHERE MATCH(nama, deskripsi) AGAINST('ayam' IN NATURAL LANGUAGE MODE);

------------------> contoh BOOLEAN
SELECT * FROM produk WHERE MATCH(nama, deskripsi) AGAINST('+ayam -Mie' IN BOOLEAN MODE);

------------------> contoh WITH QUERY EXPANSION
SELECT * FROM produk WHERE MATCH(nama, deskripsi) AGAINST('Goreng' WITH QUERY EXPANSION);

<<============================================>> fitur FOREIGN KEY <<============================================>> 

contohnya :
CREATE TABLE wishlist (
    id          INT         NOT NULL AUTO_INCREMENT,
    id_produk   VARCHAR(10) NOT NULL,
    deskripsi   TEXT,
    PRIMARY KEY (id),
    CONSTRAINT fk_wishlist_produk FOREIGN KEY (id_produk) REFERENCES produk (id)
);
ALTER TABLE wishlist ADD CONSTRAINT fk_wishlist_produk FOREIGN KEY id_produk REFERENCES produk (id);
ALTER TABLE wishlist DROP CONSTRAINT fk_wishlist_produk;

<<============================================>> BEHAVIOR FOREIGN KEY <<============================================>>
secara default behavior FOREIGN KEY adalah TESTRICT

1. RESTRICT
2. CASCADE
3. NO ACTION
4. SET NULL
+===========+===================+=======================+
| Behavior  | ON DELETE         | ON UPDATE             |
+-----------+-------------------+-----------------------+
| RESTRICT  | ditolak           | ditolak               |
| CASCADE  | data akan dihapus | data akan ikut diubah |
| NO ACTION | data dibiarkan    | data dibiarkan        |
| SET FULL  | diubah jadi null  | diubah jadi null      |
+===========+===================+=======================+

contoh BEHAVIOR FOREIGN KEY :
CREATE TABLE wishlist (
    id          INT NOT NULL AUTO_INCREMENT,
    id_produk   VARCHAR(10) NOT NULL,
    deskripsi   TEXT,
    PRIMARY KEY (id),
    CONSTRAINT fk_wishlist_produk FOREIGN KEY id_produk REFERENCES produk (id) ON DELETE CASCADE ON UPDATE CASCADE 
);

<<============================================>> fitur JOIN <<============================================>>

SELECT *
FROM employees AS e
    JOIN departement AS d
        ON (e.dep_id = d.dep_id);

SELECT  e.emp_id AS 'ID Pegawai',
        e.dep_id AS 'ID Departemen'
        e.emp_name AS 'Nama Pegawai',
        e.job_name AS 'Profesi',
        d.dep_name AS 'Nama Departement'
FROM employees AS e 
    JOIN departement AS d
        ON (e.dep_id = d.dep_id);










                                        
