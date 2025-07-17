<?php

for ($i = 0 ; $i < 10 ; $i++) {
    echo "loop ke $i" . PHP_EOL;
}

// alternatif :
/*
di akhiri endfor
*/
for ($i = 0 ; $i < 10 ; $i++) :
    echo "loop : $i" . PHP_EOL;
endfor;
    
