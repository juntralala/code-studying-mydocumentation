<?php
/*
deafult argument value pada php bisa diletakkan pada posisi manapun

namun jika parameternya lebih dari lebih dari satu, dan kita menyimpan deault value nya
padda parameter awal, maka itu jadi tidak berguna
*/

function sapa($nama = "Anonymous") {
    echo "hai $nama" . PHP_EOL;
}

sapa("udin");
sapa();