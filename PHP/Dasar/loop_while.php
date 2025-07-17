<?php

$counter = 0;
while ($counter < 10) {
    echo "while $counter" . PHP_EOL;
    $counter++;
}

// alter :
/*
diakhiri endwhile
*/
$counter = 0;
while ($counter < 10) :
    echo "while : $counter" . PHP_EOL;
    $counter++;
endwhile;