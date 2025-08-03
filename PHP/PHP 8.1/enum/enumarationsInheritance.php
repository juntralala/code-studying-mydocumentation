<?php
/**
 * Enum juga bisa melakukan pewarisan di PHP, namun terhabatas cuman bisa mewarisi interface dan trait
   tidak bisa mewarisi class atau enum lainnya 
*/

interface Sapa {
    function sapa():void;
}

trait IndoesianGender {
    function inIndonesia() {
        return match ($this) {
            Gender::MALE => "Tuan",
            Gender::FEMALE => "Nyonya",
            default => throw new Exception("UNSUPPORTED INDONESIAN VALUE")
        };
    }
}

enum Gender:string implements Sapa{
    case MALE = "Mr";
    case FEMALE = "Mrs";

    
    function sapa():void{
        echo "Hallo $this->value" . PHP_EOL;
    }
    
    use IndoesianGender;
}