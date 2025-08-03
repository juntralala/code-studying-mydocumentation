<?php

namespace UjunAlRantaui\PHP\Login\Management\App;

class View {

    public static function render(string $view, $model = null): void {
        require __DIR__ . "/../View/$view.php";
    }

    public static function redirect(string $url): void {
        header("Location: $url");
        if(getenv("mode") != "test"){ exit(); }
    }

}