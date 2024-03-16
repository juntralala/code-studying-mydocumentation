<?php

namespace UjunAlRantaui\Belajar\PHP\MVC\Controller;

use UjunAlRantaui\Belajar\PHP\MVC\App\View;

class AuthController {

    function login(): void {

        $user = [
            'username' => "ujun",
            'password' => "12345"
        ];

        if($_SERVER['REQUEST_METHOD'] == "POST"){
            if(!isset($_SESSION['login']) || $_SESSION['login'] != true){
                if($_POST['username'] == $user['username'] && $_POST['password'] == $user['password']){
                    $_SESSION['login'] = true;
                    header('Location: /');
                    exit();
                }
            }
        }

        View::render("Auth/login");
    }

}