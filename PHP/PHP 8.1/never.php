<?php
/** Never Return Type
 * Sebelumnya kita tahu ada kata kunci void untuk digunakan pada return value, utuk menandai bahwa function tersebut tidak
   mengembalikan apapun
 * Di PHP 8.1 Terdapat returntype baru, yaitu never
 * Never adalah penanda bahwa sebuah function tidak akan mengembalikan value dan function akan thow exception atau menghentikan
   eksekusi script dengan memangil function die(), exit() atau trigger_error()
 * Never ini cocok ketika kita inginmembuat function yang setelah itu kita ingin menghentikan eksekusi program PHP nya misal
*/

function stop():never{     // ini hanya penanda bahwa function ini akan menghentikan program
    echo "Stop" . PHP_EOL;

    exit();
}

stop();

echo "Hidup?" . PHP_EOL;