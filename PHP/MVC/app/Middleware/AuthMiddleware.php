<?php

namespace UjunAlRantaui\Belajar\PHP\MVC\Middleware;

class AuthMiddleware implements Middleware {

    function before(): void{
        session_start();
        if(!isset($_SESSION['login']) || $_SESSION['login'] == false){
            header('Location: /login');
            exit();
        }
    }

}