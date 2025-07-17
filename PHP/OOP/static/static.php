<?php
/**
 * Kata kunci static adalah keyword yang bisa kita gunakan untuk membuat properties atau function di class yang bisa kita akses
   tanpa harus menginstansiasi class terlebih dahulu
 * Tetapi ingat, saat kita membuat static properties atau function, secara otomatis hal itu tidak akan berhubungan lagi dengan
   class instance yang kita membuat
 * Cara mengakses static properties dan function sama seperti mengakses konstan, menggunakan operator ::
 * Static function tidak bisa mengakses function biasa, karna function biasa menempel pada instance sedangkan Static function tidak
*/

require_once "Helper.php";

use Helper\Helper;

Helper::$name = "OZON";

echo "Name : ".Helper::$name .PHP_EOL;
echo "Sum  : ", Helper::sum(1 , 1, 1, 2, 5) .PHP_EOL;