<?php
/**
 * Tidak hanya class, kita juga bisa meletakkan function dan constant di namespace
 * Jika kita ingin menggunakan function dan constat tersebut kita perlu menyebutkan nama namespace nya
*/

require_once "Helper.php";

Helper\help();
echo Helper\APPLICATION .PHP_EOL;