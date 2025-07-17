<?php
/** Menambah Header Response
 * Kadang kita ingin menambahkan informasi tambahan di HTTP Response
 * Seperti versi aplikasi kita atau yang lainnya
 * Kita juga bisa menambahkan header header dengan function header("key: value") di PHP
 * Perlu diigat di spesifikasi HTTP, header bearada di posisi atas sebelum Content dibuat, oleh karena itu
   pastikan menambah header sebelum kita membuat content
 */

// ada 2 cara menambah header 
header('Aplication: Belajar PHP Web');
header('Author: Muhammad Junaidi');

echo "Lihat Network Tool di browser";
