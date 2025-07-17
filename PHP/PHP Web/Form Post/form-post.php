<?php
/** Form Post
 * Saat kita belajar HTML, kita tahu bahasa di HTML terdapat form 
 * Form biasanya digunakan untuk mengirim data dari Client ke Server
 * Secara default, method di form adalah GET, sehingga saat kita submit, data akan dikirim dalam bentuk
   Query Parameter yang ditangkap menggunakan $_GET di PHP 
 * Namun jika kita gunakan Form dengan method POST, maka secara otomatis request Client ke Server akan
   berupa HTTP POST, hal ini menyebabkan data form yang dikirim akan dikirim melalui Body, bukan Query
   Parameter, dan untuk menerima datanya di PHP, kita perlu menggunakan $_POST
 */