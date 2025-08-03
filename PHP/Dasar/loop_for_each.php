<?php

$names = ["UJUN", "Akbar", "barizi", "Ipul"];
foreach ($names as $val) {
    echo $val . PHP_EOL;
}

// for each dengan key
$fullName = [
    "firstName" => "Muhammad",
    "lastName"  => "Junaidi",
    "nisbah"    => "al rantaui"
]; 
foreach ($fullName as $index => $val) {
    echo "index : $index\t\tvalue : $val" . PHP_EOL;
}