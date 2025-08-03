<?php

namespace UjunAlRantaui\PHP\Login\Management\App {
    function header(string $value) {
        echo $value;
    }
}

namespace UjunAlRantaui\PHP\Login\Management\Service {
    function setcookie(string $name, string $value, ...$arguments) {
        echo "$name: $value";
    }
}