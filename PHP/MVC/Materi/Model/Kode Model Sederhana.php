<?php
class HomeController{

    function index(): void {
        $model = [
            'title' => "Belajar MVC",
            'content' => "Selamat belajas PHP MVC di Channel Youtube Programmer Zaman Now"
        ];
        echo "HomeController.index()";
    }

}