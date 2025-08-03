<?php
/*
perbedaan require_once include_once dan require include adalah :
1. require_once include_once ketika mengimport file yang sama akan
TERJADI ERROR
2. require include ketika mengimport file yang sama akan
TIDAK TERJADI ERROR
*/

require_once 'lib/myFunction.php';
// include_once 'lib/myFunction.php';

echo sayHello("ujun");