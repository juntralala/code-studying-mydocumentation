<?php
/** Solusi SQL Injection
 * Jangan membuat query SQL secara manual dengan menggabungkan String secara mentah atau bulat-bulat
 * function query dan execute() tidak bisa menangani celah SQL Injection, jadi kita harus
   menanganinya secara manual
 * Direkomendaikan menggunakan function query() dan execute() jika kita memang tidak butuh
   parameter input dari user ketika membuat perintah input SQL 
 * Jika membuatuhkan parameter input dari user, kita wajib menggunakan function prepare(sql)
   yang akan kita bahas selanjutnya
 * Atau juga bisa memastikan input user aman dengan menggunakan function quote();
*/

// contoh ada di sql.quote.php dan sql.prepare.php

