<?php
/**
 * PHP 8 mengenalkan fitur Just In Time Compilation
 * Dimana fitur ini akan mempercepat proses eksekusi program PHP yang kita buat
 * Namun sebelum kita bahas fitur JIT ini, kita perlu tahu dulu bagaimana cara PHP menjalankan kode program kita 
*/

/** OPcache
 * Secara default, PHP akan selalu membaca source code PHP ketika menjalankan program PHP
 * OPCache digunakan untuk menigkatkan performace PHP, dengan cara menyimpan hasil kompilasi kode ke memory
 * Dengan demikian, PHP tidak perlu lagi membaca ulang kode program PHP setiap kali program PHP dijalankan
 * Jadi, PHP akan langsung membaca dari OPcache yang sudah disimpan di memory
 * Fitur OPcache harus diaktifkan terlebih dahulu, sebelum kita bisa menggunakannya
 * https://www.php.net/manual/en/book.opcache.php  
*/
// mengecek apakah opcache telah aktif atau tidak
$status = opcache_get_status();
echo var_dump($status["opcache_enabled"]);
echo var_dump($status);
/** catatan ku
 * Kang Eko : PHP 8.0 : secara default, opcache pada macOS tidak aktif
 * PHP 8.1.2 : secara default, opcache pada linux aktif, tetapi untuk php yang cli nya tetap harus diaktifkan secara manual
 * Untuk mengaktifkan OPcache ubah config PHP di file php.ini, kemudian cari "opcache"
*/


/** Just-In-Time Compilation
 * Opcache akan membuat kode prgram kita terhindar dari harus melakukan tokenize, parsing dan compile lagi secara terus-menerus
   tiap request 
 * JIT, akan membuat hasil kompilasi kita tidak perlu diterjemahkan  oleh virtual mechine PHP, melainkan langsung dijalankan oleh mechine
 * JIT di PHP, menggunakan liblary pemrograman bahasa C bernama DyASM, oleh karena itu JIT bisa mentranslate hasil compile opcodes ke intruksi mechine
*/