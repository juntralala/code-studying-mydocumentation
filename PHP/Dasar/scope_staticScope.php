<?php

function sapa() {
    static $counter = 1;
    echo "hai $counter" . PHP_EOL;
    $counter++;
}

sapa();
sapa();
sapa();