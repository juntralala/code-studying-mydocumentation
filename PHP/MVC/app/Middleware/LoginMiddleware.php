<?php

namespace UjunAlRantaui\Belajar\PHP\MVC\Middleware;

class LoginMiddleware implements Middleware {

    function before(): void {
        session_start();
        if(isset($_SESSION['login']) && $_SESSION['login'] == true){
            header('Location: /');
            exit();
        }
    }

} 