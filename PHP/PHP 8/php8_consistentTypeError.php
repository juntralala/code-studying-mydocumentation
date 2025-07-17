<?php
/** Update/Perubahan di PHP 8
 * Saat kita membuat function, kemudian mengirim argument dengan tipe data yang salah, maka akan berakibat menjadi TypeError
 * Akan tetapi, malah banyak function bawaan di PHP yang tidak mengembalikan TypeError, dan cuman memberi warning
 * Agar konsisten, sekarang di PHP, banyak function bawaan PHP yang akan error TypeError jika kita salah mengirim tipe data
 * https://wiki9.php.net/rfc/consistent_type_errors
*/