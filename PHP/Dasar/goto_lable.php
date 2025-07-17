<?php

echo "hello dawi" . PHP_EOL;

a:
echo "Hello A" . PHP_EOL;

$counter = 0;
while (true) {
    $counter++;
    echo "perulangan ke $counter" . PHP_EOL;

    if ($counter === 4) goto END;
}

END:
echo "Akhir program";

