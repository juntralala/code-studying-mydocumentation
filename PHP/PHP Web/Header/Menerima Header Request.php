<?php
/** Menerima Header Request
 * Semua Header yang dikirim oleh Client, secara otomatis akan dimasukkan ke global variable $_SERVER
 * Namun key header akan secara otomatis di konversi menjadi UPPERCASE, dan jika terdapat spasi atau -
   maka otomatis akan diganti menjadi _
 * Selain untuk membedakan request header dan lainnya, khusus header akan ditambah prefix HTTP _
 * Misal header Content-Type akan menjadi HTTP_CONTENT_TYPE
 * Header Accept-Language akan menjadi HTTP_ACCEPT_LANGUAGE 
 */

// bisa test kode pakai postman.com untuk menambah key value Header di Request

// kode menangkap header

echo "HOST : " . $_SERVER['HTTP_HOST'];
echo "<br>Accept-Languange : " . $_SERVER['HTTP_ACCEPT_LANGUAGE'];
