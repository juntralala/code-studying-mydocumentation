<?php
/**
 * Jika kita telah selesai melakukan operasi ke database, lalu kita sudah tidak memerlukanya
   lagi, maka kita wajib mennutup koneksi ke databasennya
 * Setiap database memiliki batas koneksi ke database, contohnya MySQL secara default batas
   maksimalnya adalah 151 koneksi
 * Jika kita sampai lupa menutup koneksi sehingga koneksi dianggap masi terbuka, maka kelamaan
   koneksi akan mencapai batas maksimal koneksi, sehingga setelahnya jika kita ingin membuat
   konekksi baru akan ditolak oleh MySQL  
*/

/** cara menutup koneksi 
 * berbeda dengan mysqli function atau mysql function harus menggunakan function tertentu
 * Di PDO tidak usah, cukup set variable PDO menjadi null
 * jadi ketika request user selesai, nanti saat php akan merunning garbage collectionya, ketidak adalah variable yang
   mengacu ke koneksi PDO tersebut maka secara otomatis PHP akan menghapus semua koneksinya
*/

require_once "database/Config.php";

$config = new Database\Config();

try {
    $connection = new PDO("mysql:host=$config->host:$config->port;dbname=$config->database", $config->username, $config->password);
    echo "Berhasil terkoneksi ke database MySQL" . PHP_EOL;
  } catch (PDOException $e) {
    echo "PHP gagal terkoneksi ke Database : " . $e->getMessage() . PHP_EOL;
  } finally {
    $connection = null;
  }