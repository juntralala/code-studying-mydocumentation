<?php
/** Execute SQL
 * Setelah kita terkoneksi ke database, sudah pasti kita ingin mengirim perintah perintah SQL ke database tersebut
   dari aplikasi PHP kita
 * Untuk mengirim perintah SQL, kita bisa menggunakan function execute(sql) yang terdapat didalam object PDO yang
   sudah kita buat
 * Function execute(sql) bisa kita gunakan untuk semua jenis SQL yang tidak membutuhkan result data, misal CREATE TABLE
   INSERT, UPDATE, DELETE, ALTER TABLE, dll  
*/

require_once "database/helper.php";


$connection = Helper\getConnection();

$sql = <<<SQL
INSERT INTO costumers(id, name, email)
VALUES ('id20', 'Junaidi', 'junaidi@gmail.com')
SQL;

$connection->exec($sql);

$connection = null;