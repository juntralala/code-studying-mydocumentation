<?php

/**
 * sejak php versi 7.4 kita sudah bisa menggunakan keyword const untuk membuat constant
*/

echo "membuat constant pakai define function".PHP_EOL;
define("AUTHOR", "Muhammad Junaidi");
define("VERSION_APP", "v1.00");

echo AUTHOR, "\n";
echo VERSION_APP . "\n\n";

echo "membuat constant pakai const keyword".PHP_EOL;
const DEVLOPER = "Muhammad Junaidi";
const VERSION = "v1.0.0";

echo DEVLOPER, "\n";
echo VERSION. "\n";