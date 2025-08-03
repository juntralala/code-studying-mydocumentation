<?php

namespace UjunAlRantaui\PHP\Logging\Controller;
use UjunAlRantaui\PHP\Logging\App\View;

class HomeController {

    public function index(): void {
        View::render("index");
    }

    public function ujun(): void {
        View::render("ujun");
    }
}