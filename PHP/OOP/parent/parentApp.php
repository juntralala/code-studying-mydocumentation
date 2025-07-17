<?php

// keyword parent digunakan untuk mengakses class isi parent
// parent fungsi nya sama kaya super kalau di bahasa pemrograman lain

require_once "Shape.php";

$kotak = new Rectangle();

echo "getCorner       : ",$kotak->getCorner(),PHP_EOL;
echo "getParentCorner : ",$kotak->getParentCorner(),PHP_EOL;
