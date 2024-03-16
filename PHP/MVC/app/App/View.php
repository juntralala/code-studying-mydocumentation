<?php

namespace UjunAlRantaui\Belajar\PHP\MVC\App;

class View{

    public static function render(string $view, $model = null){
        require __DIR__ . "/../View/$view.php";
    }

}