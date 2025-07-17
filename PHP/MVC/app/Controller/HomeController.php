<?php

namespace UjunAlRantaui\Belajar\PHP\MVC\Controller;
use UjunAlRantaui\Belajar\PHP\MVC\App\View;

class HomeController {

    public function index(): void {
        $model = [
            'title' => "Belajar MVC",
            'content' => "Selamat belajas PHP MVC di Channel Youtube Programmer Zaman Now"
        ];
        
        View::render("Home/index", $model);
    }

    public function hello(): void {
        echo "HomeController.hello()";
    }

    public function sapa(): void {
        echo "HomeController.sapa()";
    }

    public function login(): void {
        $request = [
            'username' => $_POST['username'],
            'password' => $_POST['password']
        ];

        $user = [
        ];

        $response = [
            'message' => "Login Sukses"
        ];
    }

}