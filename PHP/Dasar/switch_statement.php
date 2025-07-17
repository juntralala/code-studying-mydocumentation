<?php

$nilai = "A";

switch ($nilai) {
    case "A" :
        echo "Anda lulus dengan baik" . PHP_EOL;
        break;
        case "B":
            echo "Anda lulus" . PHP_EOL;
            break;
        case "C":
            echo "Anda lulus dengan buruk" . PHP_EOL;
        break;
    default:
        echo "Mungkin anda salah jurusan" . PHP_EOL;
}

// dengan opsi :
/*
harus diakhiri endswitch
*/
switch ($nilai) : 
    case "A" :
        echo "Anda lulus dengan baik" . PHP_EOL;
        break;
    case "B":
        echo "Anda lulus";
        break;
    case "C":
        echo "Anda lulus dengan buruk" . PHP_EOL;
        break;
    default:
        echo "Mungkin anda salah jurusan" . PHP_EOL;
endswitch;