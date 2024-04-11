<?php

namespace UjunAlRantaui\PHP\Logging\App;

class View {

    public static function render(string $path,$model = []): void {
        include __DIR__ . "/../View/$path.php";
    }

    public static function redirect(string $path): void {
        header("Location: $path");
    }  
} 