<?php
/**
 * Enum di PHP mirip seperti class biasa, ia bisa memiliki method atau function 
*/

enum Gender:string {
    case MALE = "Mr";
    case FEMALE = "Mrs";

    function sapa() {
        echo "Hallo $this->value" . PHP_EOL;
    }

    function inIndonesia() {
        return match ($this) {
            Gender::MALE => "Tuan",
            Gender::FEMALE => "Nyonya",
            default => throw new Exception("UNSUPPORTED INDONESIAN VALUE")
        };
    }
}

Gender::MALE->sapa();
Gender::FEMALE->sapa();

echo Gender::MALE->inIndonesia() . PHP_EOL;
echo Gender::FEMALE->inIndonesia() . PHP_EOL;