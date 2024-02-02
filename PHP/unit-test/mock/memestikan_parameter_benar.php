<?php

/**
 * Setelah menggunakan Mock object, kita bisa memastikan beberapa banyak jumlah function dipanggil
 * Namun jika paramter yang dikirim salah, maka secara otomatis unitTest akan tetap sukses, padahal
   seharusnya unitTest tersebut gagal
 * Pada kasus ini, mock object mendukung parameter vervication juga, untuk memastikan bahwa paramter yang
   diterima function benar
 * Kita bisa menggunakan method with(...constraint) pada mock object
 * semua class constraint terdapat disini:
   https://github.com/sebastionbergmann/phpunit/tree/master/src/Framework/Constraint
 * Namun kita tidak perlu membuat nya secara manual kita bisa menggunakan static function di Assert class
 */

 // Contohnya ada di ProductServiceMockTest.php di testDeleteSuccess()