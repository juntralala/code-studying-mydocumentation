<?php
/*  Download File di PHP
 * Memaksa client untuk melakukan download file, sebenarnya sudah ada di standard HTTP Header, ini
   menggunakan Content-Disposition :
   https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Disposition
 * Jadi di PHP kita cukup dengan menambahkan header tersebut, maka kita bisa secara otomatis memaksa browser
   untuk mendownload file yang kita buat menggunakan PHP
 * Untuk membaca file dan me-load nya di PHP, kita bisa menggunakan function readfile(filename):
   https://www.php.net/manual/en/function.readfile.php
 */