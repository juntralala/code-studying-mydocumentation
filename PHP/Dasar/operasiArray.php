<?php

$names = ["Ujun", "azid", "Opal"];
var_dump($names[0]);

$names[3] = "Akbar";
echo $names[3], "\n";

unset($names[1]); // menghapus tanpa menggeser index
var_dump($names);

$names[] = "Abu"; // menambah array diposisi ujung
echo $names[4];
